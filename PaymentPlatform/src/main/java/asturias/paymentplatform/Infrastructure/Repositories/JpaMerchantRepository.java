package asturias.paymentplatform.Infrastructure.Repositories;

import asturias.paymentplatform.Infrastructure.Entities.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface JpaMerchantRepository extends JpaRepository<MerchantEntity, UUID>  {
}
