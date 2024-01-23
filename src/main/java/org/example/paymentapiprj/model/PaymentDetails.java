package org.example.paymentapiprj.model;

// 결제 승인 요청 API에서 사용되는 신용카드 세부 정보를 표현
public class PaymentDetails {

    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

}
