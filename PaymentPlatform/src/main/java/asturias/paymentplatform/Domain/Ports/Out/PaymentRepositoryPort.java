package asturias.paymentplatform.Domain.Ports.Out;

import asturias.paymentplatform.Domain.Models.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepositoryPort {

    Payment save (Payment payment);

    Optional<Payment> findById (UUID id);

    List<Payment> findAll();

    Optional <Payment> update (Payment payment);
    boolean deleteById(UUID id);
}
