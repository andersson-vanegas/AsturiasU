package asturias.paymentplatform.Application.Services;

import asturias.paymentplatform.Domain.Models.Payment;
import asturias.paymentplatform.Infrastructure.Entities.PaymentEntity;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    UUID processPayment(Payment transaction);
    Payment getPaymentTransaction(UUID transactionId);
    void processRefund(UUID transactionId);
    List<Payment> getTransactionsByCustomerId(UUID customerId);
    List<Payment> getTransactionsByMerchantId(UUID merchantId);
}
