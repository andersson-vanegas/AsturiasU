package asturias.paymentplatform.Domain.Ports.Out;

import asturias.paymentplatform.Domain.Models.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepositoryPort {


    Customer save (Customer customer);

    Optional<Customer> findById (UUID id);

    List<Customer> findAll();

    Optional <Customer> update (Customer customer);
    boolean deleteById(UUID id);
}
