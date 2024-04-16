package asturias.paymentplatform.Application.UseCases;

import asturias.paymentplatform.Domain.Models.Customer;
import asturias.paymentplatform.Domain.Models.Merchant;
import asturias.paymentplatform.Domain.Models.Payment;
import asturias.paymentplatform.Domain.Models.Refund;
import asturias.paymentplatform.Domain.Ports.In.CreateGlobalUseCase;
import asturias.paymentplatform.Domain.Ports.Out.CustomerRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.MerchantRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.PaymentRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.RefundRepositoryPort;

public class CreateGlobalUseCaseImpl implements CreateGlobalUseCase {

    private final CustomerRepositoryPort customerRepositoryPort;
    private final MerchantRepositoryPort merchantRepositoryPort;
    private final PaymentRepositoryPort paymentRepositoryPort;
    private final RefundRepositoryPort refundRepositoryPort;

    public CreateGlobalUseCaseImpl(CustomerRepositoryPort customerRepositoryPort, MerchantRepositoryPort merchantRepositoryPort, PaymentRepositoryPort paymentRepositoryPort, RefundRepositoryPort refundRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
        this.merchantRepositoryPort = merchantRepositoryPort;
        this.paymentRepositoryPort = paymentRepositoryPort;
        this.refundRepositoryPort = refundRepositoryPort;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepositoryPort.save(customer);
    }

    @Override
    public Merchant createMerchant(Merchant merchant) {
        return merchantRepositoryPort.save(merchant);
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepositoryPort.save(payment);
    }

    @Override
    public Refund createRefund(Refund refund) {
        return refundRepositoryPort.save(refund);
    }
}
