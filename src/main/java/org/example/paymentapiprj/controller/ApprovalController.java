package org.example.paymentapiprj.controller;

import org.example.paymentapiprj.Entity.PaymentEntity;
import org.example.paymentapiprj.Repository.PaymentRepository;
import org.example.paymentapiprj.model.ApprovalRequest;
import org.example.paymentapiprj.model.ApprovalResponse;
import org.example.paymentapiprj.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 결제 승인 요청
@RestController
@RequestMapping("/api/payment")
public class ApprovalController {

    private final ApprovalService approvalService;
    private final PaymentRepository paymentRepository;

    @Autowired
    public ApprovalController(ApprovalService approvalService, PaymentRepository paymentRepository) {
        this.approvalService = approvalService;
        this.paymentRepository = paymentRepository;
    }

    @PostMapping("/approval")
    public ApprovalResponse approvePayment(@RequestBody ApprovalRequest request) {

        // ApprovalService의 메서드 호출
        ApprovalResponse response = approvalService.approvePayment(request);

        // 데이터베이스에 저장
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setUserId(request.getUserId());
        paymentEntity.setAmount(request.getAmount());
        paymentEntity.setCurrency(request.getCurrency());
        paymentRepository.save(paymentEntity);

        return response;
    }

}
