package asturias.paymentplatform.Infrastructure.Adapters;

import asturias.paymentplatform.Domain.Models.Refund;
import asturias.paymentplatform.Domain.Ports.Out.CustomerRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.RefundRepositoryPort;
import asturias.paymentplatform.Infrastructure.Entities.CustomerEntity;
import asturias.paymentplatform.Infrastructure.Entities.RefundEntity;
import asturias.paymentplatform.Infrastructure.Mapper.CustomerMapper;
import asturias.paymentplatform.Infrastructure.Mapper.RefundMapper;
import asturias.paymentplatform.Infrastructure.Repositories.JpaCustomerRepository;
import asturias.paymentplatform.Infrastructure.Repositories.JpaRefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaRefundAdapter implements RefundRepositoryPort {

    @Autowired
    private JpaRefundRepository jpaRefundRepository;

    @Autowired
    private RefundMapper refundMapper;

    public JpaRefundAdapter(JpaRefundRepository jpaRefundRepository, RefundMapper refundMapper) {
        this.jpaRefundRepository = jpaRefundRepository;
        this.refundMapper = refundMapper;
    }


    @Override
    public Refund save(Refund refund) {
        RefundEntity customerEntity = refundMapper.REFUND_ENTITY(refund);
        return refundMapper.REFUND(jpaRefundRepository.save(customerEntity));
    }

    @Override
    public Optional<Refund> findById(UUID id) {
        return jpaRefundRepository.findById(id).map(productEntity -> refundMapper.REFUND(productEntity));
    }

    @Override
    public List<Refund> findAll() {
        List<RefundEntity> customerEntities =  jpaRefundRepository.findAll();
        return  refundMapper.REFUND_LIST(customerEntities);
    }

    @Override
    public Optional<Refund> update(Refund refund) {
        if (jpaRefundRepository.existsById(refund.getId())){
            RefundEntity customerEntity = refundMapper.REFUND_ENTITY(refund);
            RefundEntity customer1 = jpaRefundRepository.save(customerEntity);
            return Optional.of(refundMapper.REFUND(customer1));
        }
        return  Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (jpaRefundRepository.existsById(id)){
            jpaRefundRepository.deleteById(id);
            return true;
        }
        return  false;
    }
}
