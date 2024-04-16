package asturias.paymentplatform.Infrastructure.Mapper;


import asturias.paymentplatform.Domain.Models.Merchant;
import asturias.paymentplatform.Infrastructure.Entities.MerchantEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MerchantMapper {

    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "email",target = "email")

    })
    Merchant MERCHANT(MerchantEntity merchant);

    List<Merchant> MERCHANT_LIST(List<MerchantEntity>merchantEntities);

    @InheritInverseConfiguration
    MerchantEntity MERCHANT_ENTITY(Merchant merchant);
}
