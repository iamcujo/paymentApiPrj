package org.example.paymentapiprj.model;

// 결제 예상 결과 조회 API의 요청 형식을 표현
public class EstimateRequest {

    private double amount;
    private String currency;
    private String destination;
    private String userId;

    public EstimateRequest(double v, String usd, String merchantId123, String number) {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
