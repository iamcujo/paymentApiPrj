package org.example.paymentapiprj.service;

import org.example.paymentapiprj.Repository.BalanceRepository;
import org.example.paymentapiprj.Entity.BalanceEntity;
import org.example.paymentapiprj.model.BalanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;

    @Autowired
    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public BalanceResponse getBalanceByUserId(String userId) {
        Optional<BalanceEntity> balanceEntityOptional = balanceRepository.findByUserId(userId);
        BalanceEntity balanceEntity = balanceEntityOptional.orElse(new BalanceEntity(userId, 0.0, "USD"));

        BalanceResponse response = new BalanceResponse();
        response.setUserId(userId);
        response.setBalance(balanceEntity.getBalance());
        response.setCurrency(balanceEntity.getCurrency());

        return response;
    }

}
