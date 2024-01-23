package org.example.paymentapiprj.model;

// 예시로 주어진 API 응답 형식을 표현
public class BalanceResponse {

    private String userId;
    private double balance;
    private String currency;

    public BalanceResponse() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
