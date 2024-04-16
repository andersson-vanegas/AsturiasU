package asturias.paymentplatform.Domain.Ports.Out;

import asturias.paymentplatform.Domain.Models.Merchant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MerchantRepositoryPort {

    Merchant save (Merchant merchant);

    Optional<Merchant> findById (UUID id);

    List<Merchant> findAll();

    Optional <Merchant> update (Merchant merchant);
    boolean deleteById(UUID id);
}
