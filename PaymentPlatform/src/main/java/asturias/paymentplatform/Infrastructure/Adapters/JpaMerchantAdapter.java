package asturias.paymentplatform.Infrastructure.Adapters;

import asturias.paymentplatform.Domain.Models.Merchant;
import asturias.paymentplatform.Domain.Ports.Out.MerchantRepositoryPort;
import asturias.paymentplatform.Infrastructure.Entities.MerchantEntity;
import asturias.paymentplatform.Infrastructure.Mapper.MerchantMapper;
import asturias.paymentplatform.Infrastructure.Repositories.JpaMerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaMerchantAdapter implements MerchantRepositoryPort {

    @Autowired
    private JpaMerchantRepository jpaMerchantRepository;

    @Autowired
    private MerchantMapper merchantMapper;

    public JpaMerchantAdapter(JpaMerchantRepository jpaMerchantRepository, MerchantMapper merchantMapper) {
        this.jpaMerchantRepository = jpaMerchantRepository;
        this.merchantMapper = merchantMapper;
    }

    @Override
    public Merchant save(Merchant merchant) {
        MerchantEntity merchantEntity = merchantMapper.MERCHANT_ENTITY(merchant);
        return merchantMapper.MERCHANT(jpaMerchantRepository.save(merchantEntity));
    }

    @Override
    public Optional<Merchant> findById(UUID id) {
        return jpaMerchantRepository.findById(id).map(productEntity -> merchantMapper.MERCHANT(productEntity));
    }

    @Override
    public List<Merchant> findAll() {
        List<MerchantEntity> customerEntities =  jpaMerchantRepository.findAll();
        return  merchantMapper.MERCHANT_LIST(customerEntities);
    }

    @Override
    public Optional<Merchant> update(Merchant merchant) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (jpaMerchantRepository.existsById(id)){
            jpaMerchantRepository.deleteById(id);
            return true;
        }
        return  false;
    }
}
