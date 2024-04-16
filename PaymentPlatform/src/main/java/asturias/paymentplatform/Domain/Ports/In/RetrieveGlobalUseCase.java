package asturias.paymentplatform.Domain.Ports.In;

import asturias.paymentplatform.Domain.Models.Customer;
import asturias.paymentplatform.Domain.Models.Merchant;
import asturias.paymentplatform.Domain.Models.Payment;
import asturias.paymentplatform.Domain.Models.Refund;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RetrieveGlobalUseCase {

    Optional<Customer> getCustomerById(UUID id);

    List<Customer> getAllCustomers();

    Optional<Merchant> getMerchantById(UUID id);

    List<Merchant> getAllMerchants();

    Optional<Payment> getPaymentById(UUID id);

    List<Payment> getAllPayments();

    Optional<Refund> getRefundById(UUID id);

    List<Refund> getAllRefunds();

}
