package asturias.paymentplatform.Infrastructure.Entities;

import asturias.paymentplatform.Domain.Enums.PaymentMethods;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "Payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "amount")
    private Integer amount;

    @Column(name = "paymentMethods")
    private PaymentMethods paymentMethods;
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


    public PaymentEntity(UUID id, Integer amount, PaymentMethods paymentMethods, LocalDateTime timestamp, CustomerEntity customerId, MerchantEntity merchantId) {
        this.id = id;
        this.amount = amount;
        this.paymentMethods = paymentMethods;
        this.timestamp = timestamp;
        this.customerId = customerId;
        this.merchantId = merchantId;
    }

    public PaymentEntity() {

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
