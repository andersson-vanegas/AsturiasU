package asturias.paymentplatform.Domain.Models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Refund {

    private UUID id;
    private Payment paymentId;
    private LocalDateTime timestamp;
    private Customer customerId;
    private  Merchant merchantId;

    public Refund(UUID id, Payment paymentId, LocalDateTime timestamp, Customer customerId, Merchant merchantId) {
        this.id = id;
        this.paymentId = paymentId;
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

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
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
