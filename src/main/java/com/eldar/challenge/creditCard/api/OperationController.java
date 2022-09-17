package com.eldar.challenge.creditCard.api;

import com.eldar.challenge.creditCard.Marca;
import com.eldar.challenge.creditCard.OperacionesTarjetaCredito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "operation", produces = "application/JSON", consumes = "application/JSON")
public class OperationController {

    @GetMapping
    public ResponseEntity getOperationInfo(@RequestBody OperationRequest request) {
        try {
            final OperacionesTarjetaCredito utils = new OperacionesTarjetaCredito();
            final String brandName = request.brand;
            final Double amount = request.amount;

            final Marca brand = utils.getTarjetaNombre(brandName);
            final Double rate = brand.calcularTasa();

            return  ResponseEntity.ok(("Request approved"+ (double) Math.round(rate)+ brand + amount));

        } catch (final IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

           // return  ResponseEntity.badRequest(("Request body format error"+ 0d+ VISA.getInstance()+ 0d));
        }
    }
}
