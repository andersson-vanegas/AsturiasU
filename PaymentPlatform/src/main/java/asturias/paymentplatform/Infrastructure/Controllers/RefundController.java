package asturias.paymentplatform.Infrastructure.Controllers;

import asturias.paymentplatform.Application.Services.GlobalService;
import asturias.paymentplatform.Application.Services.RefundService;
import asturias.paymentplatform.Domain.Models.Refund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/refunds")
public class RefundController {

    @Autowired
    private RefundService refundService;

    @Autowired
    private GlobalService globalService;

    @GetMapping("/payment/{paymentId}")
    public ResponseEntity<List<Refund>> getRefundsByPaymentId(@PathVariable UUID paymentId) {
        List<Refund> refunds = refundService.getRefundsByPaymentId(paymentId);
        return ResponseEntity.ok(refunds);
    }

    @GetMapping("/{refundId}")
    public ResponseEntity<Refund> getRefundById(@PathVariable UUID refundId) {
        return globalService.getRefundById(refundId)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
