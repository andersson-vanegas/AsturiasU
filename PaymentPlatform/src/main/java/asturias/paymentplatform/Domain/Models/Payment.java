package asturias.paymentplatform.Domain.Models;

import asturias.paymentplatform.Domain.Enums.PaymentMethods;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private UUID id;
    private Integer amount;
    private PaymentMethods paymentMethods;
    private LocalDateTime timestamp;
    private Customer customerId;
    private  Merchant merchantId;


    public Payment(UUID id, Integer amount, PaymentMethods paymentMethods, LocalDateTime timestamp, Customer customerId, Merchant merchantId) {
        this.id = id;
        this.amount = amount;
        this.paymentMethods = paymentMethods;
        this.timestamp = timestamp;
        this.customerId = customerId;
        this.merchantId = merchantId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Merchant getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Merchant merchantId) {
        this.merchantId = merchantId;
    }
}
