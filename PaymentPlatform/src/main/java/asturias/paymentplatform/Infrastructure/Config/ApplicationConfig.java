package asturias.paymentplatform.Infrastructure.Config;


import asturias.paymentplatform.Application.Services.GlobalService;
import asturias.paymentplatform.Application.UseCases.CreateGlobalUseCaseImpl;
import asturias.paymentplatform.Application.UseCases.DeleteGlobalUseCaseImpl;
import asturias.paymentplatform.Application.UseCases.RetrieveGlobalUseCaseImpl;
import asturias.paymentplatform.Application.UseCases.UpdateGlobalUseCaseImpl;
import asturias.paymentplatform.Domain.Ports.Out.CustomerRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.MerchantRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.PaymentRepositoryPort;
import asturias.paymentplatform.Domain.Ports.Out.RefundRepositoryPort;
import asturias.paymentplatform.Infrastructure.Adapters.JpaCustomerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"asturias.paymentplatform"})
public class ApplicationConfig {

    @Bean
    public GlobalService service(CustomerRepositoryPort customerRepositoryPort, MerchantRepositoryPort merchantRepositoryPort,
                                        PaymentRepositoryPort paymentRepositoryPort, RefundRepositoryPort refundRepositoryPort
    ) {
        return  new GlobalService(
                new CreateGlobalUseCaseImpl(customerRepositoryPort, merchantRepositoryPort, paymentRepositoryPort, refundRepositoryPort),
                new DeleteGlobalUseCaseImpl( customerRepositoryPort, merchantRepositoryPort, paymentRepositoryPort, refundRepositoryPort),
                new RetrieveGlobalUseCaseImpl(customerRepositoryPort, merchantRepositoryPort, paymentRepositoryPort, refundRepositoryPort),
                new UpdateGlobalUseCaseImpl(customerRepositoryPort, merchantRepositoryPort, paymentRepositoryPort, refundRepositoryPort)
        );
    }

    @Bean
    public CustomerRepositoryPort customerRepositoryPort(JpaCustomerAdapter jpaCustomerAdapter){
        return  jpaCustomerAdapter;
    }

}
