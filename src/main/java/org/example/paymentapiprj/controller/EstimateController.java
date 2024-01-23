package org.example.paymentapiprj.controller;

import org.example.paymentapiprj.Entity.EstimateEntity;
import org.example.paymentapiprj.Repository.EstimateRepository;
import org.example.paymentapiprj.model.EstimateRequest;
import org.example.paymentapiprj.model.EstimateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 결제 예상 결과 조회
@RestController
@RequestMapping("/api/payment")
public class EstimateController {

    private final EstimateRepository estimateRepository;

    @Autowired
    public EstimateController(EstimateRepository estimateRepository) {
        this.estimateRepository = estimateRepository;
    }

    @PostMapping("/estimate")
    public EstimateResponse getEstimate(@RequestBody EstimateRequest request) {
        EstimateEntity estimateEntity = estimateRepository.save(new EstimateEntity(
                request.getAmount(),
                request.getCurrency(),
                request.getDestination(),
                request.getUserId()
        ));

        EstimateResponse response = new EstimateResponse();
        response.setEstimatedTotal(estimateEntity.getAmount() + 5.0); // 임의의 가공
        response.setFees(5.0);
        response.setCurrency(estimateEntity.getCurrency());

        return response;
    }

}
