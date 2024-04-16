package asturias.paymentplatform.Infrastructure.Mapper;


import asturias.paymentplatform.Domain.Models.Payment;
import asturias.paymentplatform.Infrastructure.Entities.PaymentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "amount",target = "amount"),
            @Mapping(source = "paymentMethods",target = "paymentMethods"),
            @Mapping(source = "timestamp",target = "timestamp"),
            @Mapping(source = "customerId",target = "customerId"),
            @Mapping(source = "merchantId",target = "merchantId"),

    })
    Payment PAYMENT(PaymentEntity paymentEntity);

    List<Payment> PAYMENT_LIST(List<PaymentEntity>paymentEntities);

    @InheritInverseConfiguration
    PaymentEntity CUSTOMER_ENTITY(Payment payment);
}
