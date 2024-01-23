package org.example.paymentapiprj.service;

import org.example.paymentapiprj.model.EstimateRequest;
import org.example.paymentapiprj.model.EstimateResponse;
import org.springframework.stereotype.Service;

@Service
public class EstimateService {

    public EstimateResponse calculateEstimate(EstimateRequest request) {
        double estimatedTotal = request.getAmount() + 5.00;
        return new EstimateResponse(estimatedTotal, 5.00, request.getCurrency());
    }

}
