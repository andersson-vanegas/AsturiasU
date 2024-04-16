package asturias.paymentplatform.Infrastructure.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Refund")
public class RefundEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name="payment_id", referencedColumnName = "id", nullable=false)
    private PaymentEntity paymentId;
    @CreationTimestamp
    @Column(name = "timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private LocalDateTime timestamp;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name="customer_id", referencedColumnName = "id", nullable=false)
    private CustomerEntity customerId;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name="merchant_id", referencedColumnName = "id", nullable=false)
    private MerchantEntity merchantId;

    public RefundEntity(UUID id, PaymentEntity paymentId, LocalDateTime timestamp, CustomerEntity customerId, MerchantEntity merchantId) {
        this.id = id;
        this.paymentId = paymentId;
        this.timestamp = timestamp;
        this.customerId = customerId;
        this.merchantId = merchantId;
    }

    public RefundEntity() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PaymentEntity getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(PaymentEntity paymentId) {
        this.paymentId = paymentId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public CustomerEntity getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerEntity customerId) {
        this.customerId = customerId;
    }

    public MerchantEntity getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(MerchantEntity merchantId) {
        this.merchantId = merchantId;
    }
}
