package asturias.paymentplatform.Infrastructure.Controllers;


import asturias.paymentplatform.Application.Services.GlobalService;
import asturias.paymentplatform.Domain.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private GlobalService globalService;

    @PostMapping
    public ResponseEntity<Customer> create( @RequestBody Customer customer2) {
        Customer customer = globalService.createCustomer(customer2);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }


    @GetMapping("/{Id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable UUID Id) {
        return globalService.getCustomerById(Id)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = globalService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }


    //ACTUALIZAR PRODUCTO
    @PutMapping("/{Id}")
    public ResponseEntity<Customer> updateCustomer( @PathVariable UUID Id, @RequestBody Customer customer) {
        return globalService.updateCustomer(Id, customer)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    //ELIMINAR PRODUCTO
    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID Id) {
        if (globalService.deleteCustomer(Id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
