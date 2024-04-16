package asturias.paymentplatform.Infrastructure.Repositories;

import asturias.paymentplatform.Infrastructure.Entities.PaymentEntity;
import asturias.paymentplatform.Infrastructure.Entities.RefundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaRefundRepository extends JpaRepository<RefundEntity, UUID> {

    List<RefundEntity> findByPaymentId_Id(UUID paymentId);
}
