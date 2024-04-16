package asturias.paymentplatform.Domain.Ports.In;

import asturias.paymentplatform.Domain.Models.Customer;
import asturias.paymentplatform.Domain.Models.Merchant;
import asturias.paymentplatform.Domain.Models.Payment;
import asturias.paymentplatform.Domain.Models.Refund;

public interface CreateGlobalUseCase {

    Customer createCustomer (Customer   customer);
    Merchant createMerchant (Merchant  merchant);
    Payment createPayment (Payment  payment);
    Refund createRefund (Refund  refund);
}
