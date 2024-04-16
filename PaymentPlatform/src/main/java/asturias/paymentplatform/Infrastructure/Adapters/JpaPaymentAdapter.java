package asturias.paymentplatform.Infrastructure.Adapters;

import asturias.paymentplatform.Domain.Models.Customer;
import asturias.paymentplatform.Domain.Models.Payment;
import asturias.paymentplatform.Domain.Ports.Out.CustomerRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.PaymentRepositoryPort;
import asturias.paymentplatform.Infrastructure.Entities.CustomerEntity;
import asturias.paymentplatform.Infrastructure.Entities.PaymentEntity;
import asturias.paymentplatform.Infrastructure.Mapper.CustomerMapper;
import asturias.paymentplatform.Infrastructure.Mapper.PaymentMapper;
import asturias.paymentplatform.Infrastructure.Repositories.JpaCustomerRepository;
import asturias.paymentplatform.Infrastructure.Repositories.JpaPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaPaymentAdapter implements PaymentRepositoryPort {


    @Autowired
    private JpaPaymentRepository jpaPaymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    public JpaPaymentAdapter(JpaPaymentRepository jpaPaymentRepository, PaymentMapper paymentMapper) {
        this.jpaPaymentRepository = jpaPaymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public Payment save(Payment payment) {
        PaymentEntity customerEntity = paymentMapper.CUSTOMER_ENTITY(payment);
        return paymentMapper.PAYMENT(jpaPaymentRepository.save(customerEntity));
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        return jpaPaymentRepository.findById(id).map(productEntity -> paymentMapper.PAYMENT(productEntity));
    }

    @Override
    public List<Payment> findAll() {
        List<PaymentEntity> customerEntities =  jpaPaymentRepository.findAll();
        return  paymentMapper.PAYMENT_LIST(customerEntities);
    }

    @Override
    public Optional<Payment> update(Payment payment) {
        if (jpaPaymentRepository.existsById(payment.getId())){
            PaymentEntity customerEntity = paymentMapper.CUSTOMER_ENTITY(payment);
            PaymentEntity customer1 = jpaPaymentRepository.save(customerEntity);
            return Optional.of(paymentMapper.PAYMENT(customer1));
        }
        return  Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (jpaPaymentRepository.existsById(id)){
            jpaPaymentRepository.deleteById(id);
            return true;
        }
        return  false;
    }
}
