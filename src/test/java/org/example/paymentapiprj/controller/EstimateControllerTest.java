package org.example.paymentapiprj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.paymentapiprj.model.EstimateRequest;
import org.example.paymentapiprj.model.EstimateResponse;
import org.example.paymentapiprj.service.EstimateService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(EstimateController.class)
public class EstimateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EstimateService estimateService;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private EstimateController estimateController;

    @Test
    void getEstimatedTotal() throws Exception {
        // Mock 데이터 설정
        EstimateRequest request = new EstimateRequest(150.00, "USD", "merchantId123", "12345");
        EstimateResponse response = new EstimateResponse(155.00, 5.00, "USD");

        when(estimateService.calculateEstimatedTotal(any(EstimateRequest.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/payment/estimate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.estimatedTotal").value(response.getEstimatedTotal()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fees").value(response.getFees()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value(response.getCurrency()));
    }
}
