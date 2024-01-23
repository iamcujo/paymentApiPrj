package org.example.paymentapiprj.model;

// 결제 예상 결과 조회 API의 응답 형식을 표현
public class EstimateResponse {

    private double estimatedTotal;
    private double fees;
    private String currency;

    public EstimateResponse() {

    }

    public double getEstimatedTotal() {
        return estimatedTotal;
    }

    public void setEstimatedTotal(double estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
