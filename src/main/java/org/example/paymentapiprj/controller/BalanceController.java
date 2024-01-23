package org.example.paymentapiprj.controller;

import org.example.paymentapiprj.Entity.BalanceEntity;
import org.example.paymentapiprj.Repository.BalanceRepository;
import org.example.paymentapiprj.model.BalanceResponse;
import org.example.paymentapiprj.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 잔액 조회
@RestController
@RequestMapping("/api/payment")
public class BalanceController {

    private final BalanceRepository balanceRepository;

    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceRepository balanceRepository, BalanceService balanceService) {
        this.balanceRepository = balanceRepository;
        this.balanceService = balanceService;
    }

    @GetMapping("/balance/{userId}")
    public BalanceResponse getBalance(@PathVariable String userId) {
        BalanceEntity balanceEntity = balanceRepository.findByUserId(userId)
                .orElse(new BalanceEntity(userId, 0.0, "USD"));

        BalanceResponse response = new BalanceResponse();
        response.setUserId(userId);
        response.setBalance(balanceEntity.getBalance());
        response.setCurrency(balanceEntity.getCurrency());

        return response;
    }

}
