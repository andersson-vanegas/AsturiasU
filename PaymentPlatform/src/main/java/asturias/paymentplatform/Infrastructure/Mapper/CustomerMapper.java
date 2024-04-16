package asturias.paymentplatform.Infrastructure.Mapper;


import asturias.paymentplatform.Domain.Models.Customer;
import asturias.paymentplatform.Infrastructure.Entities.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "paymentMethod",target = "paymentMethod"),

    })
    Customer CUSTOMER(CustomerEntity customerEntity);

    List<Customer> CUSTOMER_LIST(List<CustomerEntity>customerEntities);

    @InheritInverseConfiguration
    CustomerEntity CUSTOMER_ENTITY(Customer customer);

}
