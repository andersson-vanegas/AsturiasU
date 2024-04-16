package asturias.paymentplatform.Infrastructure.Repositories;


import asturias.paymentplatform.Infrastructure.Entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaPaymentRepository extends JpaRepository<PaymentEntity, UUID> {
    List<PaymentEntity> findByCustomerId_Id(UUID customerId);
    List<PaymentEntity> findByMerchantId_Id(UUID merchantId);

}
