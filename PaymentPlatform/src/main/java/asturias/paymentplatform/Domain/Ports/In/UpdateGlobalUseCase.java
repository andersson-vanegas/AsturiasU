package asturias.paymentplatform.Domain.Ports.In;

import asturias.paymentplatform.Domain.Models.Customer;
import asturias.paymentplatform.Domain.Models.Merchant;
import asturias.paymentplatform.Domain.Models.Payment;
import asturias.paymentplatform.Domain.Models.Refund;

import java.util.Optional;
import java.util.UUID;

public interface UpdateGlobalUseCase {

    Optional<Customer> updateCustomer(UUID id, Customer producto);
    Optional<Merchant> updateMerchant(UUID id, Merchant producto);
    Optional<Payment> updatePayment(UUID id, Payment producto);
    Optional<Refund> updateRefund(UUID id, Refund producto);


}
