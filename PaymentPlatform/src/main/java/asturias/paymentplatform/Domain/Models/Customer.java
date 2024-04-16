package asturias.paymentplatform.Domain.Models;

import asturias.paymentplatform.Domain.Enums.PaymentMethods;

import java.util.UUID;

public class Customer {

    private UUID id;
    private String name;
    private String email;
    private PaymentMethods paymentMethod;

    public Customer(UUID id, String name, String email, PaymentMethods paymentMethod) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.paymentMethod = paymentMethod;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
