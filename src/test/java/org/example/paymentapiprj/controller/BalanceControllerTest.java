package org.example.paymentapiprj.controller;

import org.example.paymentapiprj.Entity.BalanceEntity;
import org.example.paymentapiprj.Repository.BalanceRepository;
import org.example.paymentapiprj.config.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BalanceController.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
public class BalanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BalanceRepository balanceRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getBalance() throws Exception {
        // Given
        String userId = "testUser";
        double balanceAmount = 500.0;
        String currency = "USD";
        when(balanceRepository.findByUserId(userId))
                .thenReturn(Optional.of(new BalanceEntity(userId, balanceAmount, currency)));

        MvcResult result = mockMvc.perform(get("/api/payment/balance/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(userId))
                .andExpect(jsonPath("$.balance").value(balanceAmount))
                .andExpect(jsonPath("$.currency").value(currency))
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        System.out.println("Response Body: " + responseBody);
    }

}
