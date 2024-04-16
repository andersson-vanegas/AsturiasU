package asturias.paymentplatform.Application.UseCases;

import asturias.paymentplatform.Domain.Models.Customer;
import asturias.paymentplatform.Domain.Models.Merchant;
import asturias.paymentplatform.Domain.Models.Payment;
import asturias.paymentplatform.Domain.Models.Refund;
import asturias.paymentplatform.Domain.Ports.In.RetrieveGlobalUseCase;
import asturias.paymentplatform.Domain.Ports.Out.CustomerRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.MerchantRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.PaymentRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.RefundRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RetrieveGlobalUseCaseImpl implements RetrieveGlobalUseCase {


    private final CustomerRepositoryPort customerRepositoryPort;
    private final MerchantRepositoryPort merchantRepositoryPort;
    private final PaymentRepositoryPort paymentRepositoryPort;
    private final RefundRepositoryPort refundRepositoryPort;

    public RetrieveGlobalUseCaseImpl(CustomerRepositoryPort customerRepositoryPort, MerchantRepositoryPort merchantRepositoryPort, PaymentRepositoryPort paymentRepositoryPort, RefundRepositoryPort refundRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
        this.merchantRepositoryPort = merchantRepositoryPort;
        this.paymentRepositoryPort = paymentRepositoryPort;
        this.refundRepositoryPort = refundRepositoryPort;
    }

    @Override
    public Optional<Customer> getCustomerById(UUID id) {
        return customerRepositoryPort.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepositoryPort.findAll();
    }

    @Override
    public Optional<Merchant> getMerchantById(UUID id) {
        return merchantRepositoryPort.findById(id);
    }

    @Override
    public List<Merchant> getAllMerchants() {
        return merchantRepositoryPort.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(UUID id) {
        return paymentRepositoryPort.findById(id);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepositoryPort.findAll();
    }

    @Override
    public Optional<Refund> getRefundById(UUID id) {
        return refundRepositoryPort.findById(id);
    }

    @Override
    public List<Refund> getAllRefunds() {
        return refundRepositoryPort.findAll();
    }
}
