package asturias.paymentplatform.Infrastructure.Entities;
import asturias.paymentplatform.Domain.Enums.PaymentMethods;
import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "Customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "paymentMethod")
    private PaymentMethods paymentMethod;

    public CustomerEntity(UUID id, String name, String email, PaymentMethods paymentMethod) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.paymentMethod = paymentMethod;
    }

    public CustomerEntity() {

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
