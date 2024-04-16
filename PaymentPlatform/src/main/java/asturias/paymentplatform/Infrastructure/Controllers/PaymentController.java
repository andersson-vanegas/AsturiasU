package asturias.paymentplatform.Infrastructure.Controllers;


import asturias.paymentplatform.Application.Services.PaymentService;
import asturias.paymentplatform.Domain.Models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<UUID> processPayment(@RequestBody Payment transaction) {
        UUID transactionId = paymentService.processPayment(transaction);
        return new ResponseEntity<>(transactionId, HttpStatus.CREATED);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Payment> getPaymentTransaction(@PathVariable UUID transactionId) {
        Payment transaction = paymentService.getPaymentTransaction(transactionId);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{transactionId}/refund")
    public ResponseEntity<String> processRefund(@PathVariable UUID transactionId) {
        paymentService.processRefund(transactionId);
        return ResponseEntity.ok("Reembolso procesado para la transacción con ID: " + transactionId);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Payment>> getTransactionsByCustomerId(@PathVariable UUID customerId) {
        List<Payment> transactions = paymentService.getTransactionsByCustomerId(customerId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/merchant/{merchantId}")
    public ResponseEntity<List<Payment>> getTransactionsByMerchantId(@PathVariable UUID merchantId) {
        List<Payment> transactions = paymentService.getTransactionsByMerchantId(merchantId);
        return ResponseEntity.ok(transactions);
    }
}
