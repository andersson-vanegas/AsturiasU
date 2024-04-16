package asturias.paymentplatform.Application.Services;

import asturias.paymentplatform.Domain.Models.Refund;
import asturias.paymentplatform.Infrastructure.Entities.PaymentEntity;
import asturias.paymentplatform.Infrastructure.Entities.RefundEntity;
import asturias.paymentplatform.Infrastructure.Mapper.PaymentMapper;
import asturias.paymentplatform.Infrastructure.Mapper.RefundMapper;
import asturias.paymentplatform.Infrastructure.Repositories.JpaRefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    private JpaRefundRepository refundRepository;

    @Autowired
    private RefundMapper refundMapper;

    @Override
    public List<Refund> getRefundsByPaymentId(UUID paymentId) {
        List<RefundEntity> payment =  refundRepository.findByPaymentId_Id(paymentId);
        return refundMapper.REFUND_LIST(payment);
    }


}
