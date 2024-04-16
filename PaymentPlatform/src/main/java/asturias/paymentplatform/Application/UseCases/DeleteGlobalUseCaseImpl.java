package asturias.paymentplatform.Application.UseCases;

import asturias.paymentplatform.Domain.Ports.In.DeleteGlobalUseCase;
import asturias.paymentplatform.Domain.Ports.Out.CustomerRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.MerchantRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.PaymentRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.RefundRepositoryPort;

import java.util.UUID;

public class DeleteGlobalUseCaseImpl  implements DeleteGlobalUseCase  {


    private final CustomerRepositoryPort customerRepositoryPort;
    private final MerchantRepositoryPort merchantRepositoryPort;
    private final PaymentRepositoryPort paymentRepositoryPort;
    private final RefundRepositoryPort refundRepositoryPort;

    public DeleteGlobalUseCaseImpl(CustomerRepositoryPort customerRepositoryPort, MerchantRepositoryPort merchantRepositoryPort, PaymentRepositoryPort paymentRepositoryPort, RefundRepositoryPort refundRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
        this.merchantRepositoryPort = merchantRepositoryPort;
        this.paymentRepositoryPort = paymentRepositoryPort;
        this.refundRepositoryPort = refundRepositoryPort;
    }

    @Override
    public Boolean deleteCustomer(UUID id) {
        return customerRepositoryPort.deleteById(id);
    }

    @Override
    public Boolean deleteMerchant(UUID id) {
        return merchantRepositoryPort.deleteById(id);
    }

    @Override
    public Boolean deletePayment(UUID id) {
        return paymentRepositoryPort.deleteById(id);
    }

    @Override
    public Boolean deleteRefund(UUID id) {
        return refundRepositoryPort.deleteById(id);
    }
}
