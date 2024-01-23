package org.example.paymentapiprj.model;

// 결제 승인 요청 API의 요청 형식을 표현
public class ApprovalRequest {

    private String userId;
    private double amount;
    private String currency;
    private String merchantId;
    private String paymentMethod;
    private PaymentDetails paymentDetails;

    public ApprovalRequest() {
    }

    public ApprovalRequest(String userId, double amount, String currency, String merchantId, String paymentMethod, PaymentDetails paymentDetails) {
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.merchantId = merchantId;
        this.paymentMethod = paymentMethod;
        this.paymentDetails = paymentDetails;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public static class PaymentDetails {
        private String cardNumber;
        private String expiryDate;
        private String cvv;

        public PaymentDetails() {
        }

        public PaymentDetails(String cardNumber, String expiryDate, String cvv) {
            this.cardNumber = cardNumber;
            this.expiryDate = expiryDate;
            this.cvv = cvv;
        }

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

}
