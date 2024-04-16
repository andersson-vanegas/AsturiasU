package asturias.paymentplatform.Application.UseCases;

import asturias.paymentplatform.Domain.Models.Customer;
import asturias.paymentplatform.Domain.Models.Merchant;
import asturias.paymentplatform.Domain.Models.Payment;
import asturias.paymentplatform.Domain.Models.Refund;
import asturias.paymentplatform.Domain.Ports.In.UpdateGlobalUseCase;
import asturias.paymentplatform.Domain.Ports.Out.CustomerRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.MerchantRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.PaymentRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.RefundRepositoryPort;

import java.util.Optional;
import java.util.UUID;

public class UpdateGlobalUseCaseImpl implements UpdateGlobalUseCase {

    private final CustomerRepositoryPort customerRepositoryPort;
    private final MerchantRepositoryPort merchantRepositoryPort;
    private final PaymentRepositoryPort paymentRepositoryPort;
    private final RefundRepositoryPort refundRepositoryPort;

    public UpdateGlobalUseCaseImpl(CustomerRepositoryPort customerRepositoryPort, MerchantRepositoryPort merchantRepositoryPort, PaymentRepositoryPort paymentRepositoryPort, RefundRepositoryPort refundRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
        this.merchantRepositoryPort = merchantRepositoryPort;
        this.paymentRepositoryPort = paymentRepositoryPort;
        this.refundRepositoryPort = refundRepositoryPort;
    }


    @Override
    public Optional<Customer> updateCustomer(UUID id, Customer producto) {
        return customerRepositoryPort.update(producto);
    }

    @Override
    public Optional<Merchant> updateMerchant(UUID id, Merchant producto) {
        return merchantRepositoryPort.update(producto);
    }

    @Override
    public Optional<Payment> updatePayment(UUID id, Payment producto) {
        return paymentRepositoryPort.update(producto);
    }

    @Override
    public Optional<Refund> updateRefund(UUID id, Refund producto) {
        return refundRepositoryPort.update(producto);
    }
}
