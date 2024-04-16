package asturias.paymentplatform.Infrastructure.Adapters;

import asturias.paymentplatform.Domain.Models.Customer;
import asturias.paymentplatform.Domain.Ports.Out.CustomerRepositoryPort;
import asturias.paymentplatform.Infrastructure.Entities.CustomerEntity;
import asturias.paymentplatform.Infrastructure.Mapper.CustomerMapper;
import asturias.paymentplatform.Infrastructure.Repositories.JpaCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
public class JpaCustomerAdapter implements CustomerRepositoryPort {

    @Autowired
    private  JpaCustomerRepository jpaCustomerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public JpaCustomerAdapter(JpaCustomerRepository jpaCustomerRepository, CustomerMapper customerMapper) {
        this.jpaCustomerRepository = jpaCustomerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = customerMapper.CUSTOMER_ENTITY(customer);
        return customerMapper.CUSTOMER(jpaCustomerRepository.save(customerEntity));
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return jpaCustomerRepository.findById(id).map(productEntity -> customerMapper.CUSTOMER(productEntity));
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> customerEntities =  jpaCustomerRepository.findAll();
        return  customerMapper.CUSTOMER_LIST(customerEntities);
    }

    @Override
    public Optional<Customer> update(Customer customer) {
        if (jpaCustomerRepository.existsById(customer.getId())){
            CustomerEntity customerEntity = customerMapper.CUSTOMER_ENTITY(customer);
            CustomerEntity customer1 = jpaCustomerRepository.save(customerEntity);
            return Optional.of(customerMapper.CUSTOMER(customer1));
        }
        return  Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (jpaCustomerRepository.existsById(id)){
            jpaCustomerRepository.deleteById(id);
            return true;
        }
        return  false;
    }
}
