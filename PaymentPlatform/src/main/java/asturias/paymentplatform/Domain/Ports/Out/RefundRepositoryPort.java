package asturias.paymentplatform.Domain.Ports.Out;

import asturias.paymentplatform.Domain.Models.Refund;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RefundRepositoryPort {

    Refund save (Refund refund);

    Optional<Refund> findById (UUID id);

    List<Refund> findAll();

    Optional <Refund> update (Refund refund);
    boolean deleteById(UUID id);
}
