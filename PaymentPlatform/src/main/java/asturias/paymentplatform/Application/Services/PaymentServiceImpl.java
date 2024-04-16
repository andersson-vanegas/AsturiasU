package asturias.paymentplatform.Application.Services;

import asturias.paymentplatform.Domain.Models.Payment;
import asturias.paymentplatform.Infrastructure.Entities.PaymentEntity;
import asturias.paymentplatform.Infrastructure.Mapper.PaymentMapper;
import asturias.paymentplatform.Infrastructure.Repositories.JpaPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    private GlobalService transactionRepository;

    @Autowired
    private final JpaPaymentRepository jpaPaymentRepository;
    @Autowired
    private PaymentMapper paymentMapper;

    public PaymentServiceImpl(JpaPaymentRepository jpaPaymentRepository) {
        this.jpaPaymentRepository = jpaPaymentRepository;
    }


    @Override
    public UUID processPayment(Payment transaction) {
        PaymentEntity paymentEntity = paymentMapper.CUSTOMER_ENTITY(transaction);
        paymentEntity.setId(UUID.randomUUID()); // Generar un ID único
        Payment payment = paymentMapper.PAYMENT(paymentEntity);
        return transactionRepository.createPayment(payment).getId();
    }

    @Override
    public Payment getPaymentTransaction(UUID transactionId) {
        return transactionRepository.getPaymentById(transactionId).orElse(null);
    }

    @Override
    public void processRefund(UUID transactionId) {
        transactionRepository.deletePayment(transactionId);
    }

    @Override
    public List<Payment> getTransactionsByCustomerId(UUID customerId) {
                 List<PaymentEntity> payment =  jpaPaymentRepository.findByCustomerId_Id(customerId);
                 return paymentMapper.PAYMENT_LIST(payment);
    }

    @Override
    public List<Payment> getTransactionsByMerchantId(UUID merchantId) {
        List<PaymentEntity> payment =  jpaPaymentRepository.findByMerchantId_Id(merchantId);
        return paymentMapper.PAYMENT_LIST(payment);
    }
}
