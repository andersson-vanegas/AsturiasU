package asturias.paymentplatform.Infrastructure.Repositories;

import asturias.paymentplatform.Infrastructure.Entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
