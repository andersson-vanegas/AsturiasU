package asturias.paymentplatform.Application.Services;

import asturias.paymentplatform.Domain.Models.Refund;

import java.util.List;
import java.util.UUID;

public interface RefundService {
    List<Refund> getRefundsByPaymentId(UUID paymentId);
}
