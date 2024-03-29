package org.example.paymentapiprj.service;

import org.example.paymentapiprj.Entity.PaymentEntity;
import org.example.paymentapiprj.Repository.PaymentRepository;
import org.example.paymentapiprj.model.ApprovalRequest;
import org.example.paymentapiprj.model.ApprovalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ApprovalService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public ApprovalService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public ApprovalResponse approvePayment(ApprovalRequest request) {
        return createApprovedResponse(request);
    }

    public ApprovalResponse processApproval(ApprovalRequest request) {
        return createApprovedResponse(request);
    }

    private ApprovalResponse createApprovedResponse(ApprovalRequest request) {
        PaymentEntity paymentEntity = paymentRepository.save(new PaymentEntity(request.getUserId(), request.getAmount(), request.getCurrency()));

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));

        ApprovalResponse response = new ApprovalResponse();
        response.setPaymentId(String.valueOf(paymentEntity.getId()));
        response.setStatus("approved");
        response.setAmount(paymentEntity.getAmount());
        response.setCurrency(paymentEntity.getCurrency());
        response.setTimestamp(timestamp);

        return response;
    }

    private ApprovalResponse createRejectedResponse(ApprovalRequest request) {
        ApprovalResponse response = new ApprovalResponse();
        response.setStatus("rejected");
        response.setAmount(request.getAmount());
        response.setCurrency(request.getCurrency());
        return response;
    }

}
