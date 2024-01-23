package org.example.paymentapiprj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.paymentapiprj.model.ApprovalRequest;
import org.example.paymentapiprj.model.ApprovalResponse;
import org.example.paymentapiprj.service.ApprovalService;
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

@WebMvcTest(ApprovalController.class)
public class ApprovalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ApprovalService approvalService;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private ApprovalController approvalController;

    @Test
    void requestApproval() throws Exception {

        ApprovalRequest request = new ApprovalRequest(
                "12345",
                200.00,
                "USD",
                "merchantId123",
                "creditCard",
                new ApprovalRequest.PaymentDetails("1234-5678-9123-4567", "12/24", "123")
        );
        ApprovalResponse response = new ApprovalResponse(
                "paymentId12345",
                "approved",
                200.00,
                "USD",
                "2023-01-23T10:00:00Z"
        );

        when(approvalService.processApproval(any(ApprovalRequest.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/payments/approval")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.paymentId").value(response.getPaymentId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(response.getStatus()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount").value(response.getAmount()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value(response.getCurrency()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").value(response.getTimestamp()));
    }
}
