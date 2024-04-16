package asturias.paymentplatform.Infrastructure.Controllers;

import asturias.paymentplatform.Application.Services.GlobalService;
import asturias.paymentplatform.Domain.Models.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

    @Autowired
    private GlobalService globalService;

    @PostMapping
    public ResponseEntity<Merchant> create(@RequestBody Merchant merchant) {
        Merchant merchant1 = globalService.createMerchant(merchant);
        return new ResponseEntity<>(merchant1, HttpStatus.CREATED);
    }


    @GetMapping("/{Id}")
    public ResponseEntity<Merchant> getMerchantById(@PathVariable UUID Id) {
        return globalService.getMerchantById(Id)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping
    public ResponseEntity<List<Merchant>> getAllCustomers() {
        List<Merchant> allCustomers = globalService.getAllMerchants();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }


    //ACTUALIZAR PRODUCTO
    @PutMapping("/{Id}")
    public ResponseEntity<Merchant> updateMerchant( @PathVariable UUID Id, @RequestBody Merchant merchant) {
        return globalService.updateMerchant(Id, merchant)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    //ELIMINAR PRODUCTO
    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable UUID Id) {
        if (globalService.deleteMerchant(Id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
