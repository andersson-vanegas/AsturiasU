package asturias.paymentplatform.Domain.Ports.In;

import java.util.UUID;

public interface DeleteGlobalUseCase {

    Boolean deleteCustomer(UUID id);
    Boolean deleteMerchant(UUID id);
    Boolean deletePayment(UUID id);
    Boolean deleteRefund(UUID id);
}
