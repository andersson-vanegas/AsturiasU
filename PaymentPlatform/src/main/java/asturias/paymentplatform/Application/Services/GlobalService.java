package asturias.paymentplatform.Application.Services;

import asturias.paymentplatform.Domain.Models.Customer;
import asturias.paymentplatform.Domain.Models.Merchant;
import asturias.paymentplatform.Domain.Models.Payment;
import asturias.paymentplatform.Domain.Models.Refund;
import asturias.paymentplatform.Domain.Ports.In.CreateGlobalUseCase;
import asturias.paymentplatform.Domain.Ports.In.DeleteGlobalUseCase;
import asturias.paymentplatform.Domain.Ports.In.RetrieveGlobalUseCase;
import asturias.paymentplatform.Domain.Ports.In.UpdateGlobalUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GlobalService implements CreateGlobalUseCase, DeleteGlobalUseCase, RetrieveGlobalUseCase, UpdateGlobalUseCase {

    private final  CreateGlobalUseCase createGlobalUseCase;
    private final DeleteGlobalUseCase deleteGlobalUseCase;
    private final RetrieveGlobalUseCase retrieveGlobalUseCase;
    private final UpdateGlobalUseCase updateGlobalUseCase;

    public GlobalService(CreateGlobalUseCase createGlobalUseCase, DeleteGlobalUseCase deleteGlobalUseCase, RetrieveGlobalUseCase retrieveGlobalUseCase, UpdateGlobalUseCase updateGlobalUseCase) {
        this.createGlobalUseCase = createGlobalUseCase;
        this.deleteGlobalUseCase = deleteGlobalUseCase;
        this.retrieveGlobalUseCase = retrieveGlobalUseCase;
        this.updateGlobalUseCase = updateGlobalUseCase;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return createGlobalUseCase.createCustomer(customer);
    }

    @Override
    public Merchant createMerchant(Merchant merchant) {
        return createGlobalUseCase.createMerchant(merchant);
    }

    @Override
    public Payment createPayment(Payment payment) {
        return createGlobalUseCase.createPayment(payment);
    }

    @Override
    public Refund createRefund(Refund refund) {
        return createGlobalUseCase.createRefund(refund);
    }

    @Override
    public Boolean deleteCustomer(UUID id) {
            return deleteGlobalUseCase.deleteCustomer(id);
    }

    @Override
    public Boolean deleteMerchant(UUID id) {
        return deleteGlobalUseCase.deleteMerchant(id);
    }

    @Override
    public Boolean deletePayment(UUID id) {
        return deleteGlobalUseCase.deletePayment(id);
    }

    @Override
    public Boolean deleteRefund(UUID id) {
        return deleteGlobalUseCase.deleteRefund(id);
    }

    @Override
    public Optional<Customer> getCustomerById(UUID id) {
        return retrieveGlobalUseCase.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return retrieveGlobalUseCase.getAllCustomers();
    }

    @Override
    public Optional<Merchant> getMerchantById(UUID id) {
        return retrieveGlobalUseCase.getMerchantById(id);
    }

    @Override
    public List<Merchant> getAllMerchants() {
        return retrieveGlobalUseCase.getAllMerchants();
    }

    @Override
    public Optional<Payment> getPaymentById(UUID id) {
        return retrieveGlobalUseCase.getPaymentById(id);
    }

    @Override
    public List<Payment> getAllPayments() {
        return retrieveGlobalUseCase.getAllPayments();
    }

    @Override
    public Optional<Refund> getRefundById(UUID id) {
        return retrieveGlobalUseCase.getRefundById(id);
    }

    @Override
    public List<Refund> getAllRefunds() {
        return retrieveGlobalUseCase.getAllRefunds();
    }

    @Override
    public Optional<Customer> updateCustomer(UUID id, Customer producto) {
        return updateGlobalUseCase.updateCustomer(id, producto);
    }

    @Override
    public Optional<Merchant> updateMerchant(UUID id, Merchant producto) {
        return updateGlobalUseCase.updateMerchant(id, producto);
    }

    @Override
    public Optional<Payment> updatePayment(UUID id, Payment producto) {
        return updateGlobalUseCase.updatePayment(id, producto);
    }

    @Override
    public Optional<Refund> updateRefund(UUID id, Refund producto) {
        return updateGlobalUseCase.updateRefund(id, producto);
    }
}
