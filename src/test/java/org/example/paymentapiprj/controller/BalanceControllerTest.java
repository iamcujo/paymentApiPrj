package org.example.paymentapiprj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.paymentapiprj.Entity.BalanceEntity;
import org.example.paymentapiprj.Repository.BalanceRepository;
import org.example.paymentapiprj.model.BalanceResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(BalanceController.class)
public class BalanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BalanceRepository balanceRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private BalanceController balanceController;

    @Test
    void getBalance() throws Exception {
        // Mock 데이터 생성
        String userId = "testUser";
        double balanceAmount = 500.0;
        String currency = "USD";

        when(balanceRepository.findByUserId(userId))
                .thenReturn(Optional.of(new BalanceEntity(userId, balanceAmount, currency)));

        // API 호출 및 응답 확인
        mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/balance/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(userId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(balanceAmount))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value(currency));
    }
}
