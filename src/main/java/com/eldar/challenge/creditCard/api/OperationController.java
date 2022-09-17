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
            final String marca = request.marca;
            final Double monto = request.monto;

            final Marca brand = utils.getTarjetaNombre(marca);
            final Double rate = brand.calcularTasa();

            return  ResponseEntity.ok(("Request approved"+ (double) Math.round(rate)+ brand + monto));

        } catch (final IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
}
