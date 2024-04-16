package asturias.paymentplatform.Infrastructure.Mapper;


import asturias.paymentplatform.Domain.Models.Customer;
import asturias.paymentplatform.Domain.Models.Refund;
import asturias.paymentplatform.Infrastructure.Entities.CustomerEntity;
import asturias.paymentplatform.Infrastructure.Entities.RefundEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RefundMapper {

    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "paymentId",target = "paymentId"),
            @Mapping(source = "timestamp",target = "timestamp"),
            @Mapping(source = "customerId",target = "customerId"),
            @Mapping(source = "merchantId",target = "merchantId"),
    })
    Refund REFUND(RefundEntity refundEntity);

    List<Refund> REFUND_LIST(List<RefundEntity>refundEntities);

    @InheritInverseConfiguration
    RefundEntity REFUND_ENTITY(Refund refund);
}
