package org.example.paymentapiprj.controller;

import org.example.paymentapiprj.Entity.BalanceEntity;
import org.example.paymentapiprj.Repository.BalanceRepository;
import org.example.paymentapiprj.model.BalanceResponse;
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

    @Autowired
    public BalanceController(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @GetMapping("/balance/{userId}")
    public BalanceResponse getBalance(@PathVariable String userId) {
        // H2 데이터베이스에서 잔액 정보 조회
        BalanceEntity balanceEntity = balanceRepository.findByUserId(userId)
                .orElse(new BalanceEntity(userId, 0.0, "USD"));

        // 조회한 정보를 기반으로 응답 생성
        BalanceResponse response = new BalanceResponse();
        response.setUserId(userId);
        response.setBalance(balanceEntity.getBalance());
        response.setCurrency(balanceEntity.getCurrency());

        return response;
    }

}
