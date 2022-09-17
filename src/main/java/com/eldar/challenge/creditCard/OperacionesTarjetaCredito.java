package com.eldar.challenge.creditCard;

import com.eldar.challenge.creditCard.Tarjeta.AMEX;
import com.eldar.challenge.creditCard.Tarjeta.NARA;
import com.eldar.challenge.creditCard.Tarjeta.VISA;

public class OperacionesTarjetaCredito {
    // Informacion de la tarjeta
    public String getInfoTarjeta(TarjetaCredito tarjetaCredito) {
        return  "Marca = " + tarjetaCredito.getMarca().getNombre() +
                ", Numero = " + tarjetaCredito.getNumero() +
                ", Cardholder = '" + tarjetaCredito.getCardholder() + '\'' +
                ", Fecha Vencimiento = " + tarjetaCredito.getFechaVencimiento();
    }

    public boolean OperacionValida(Operacion operacion){
        return operacion.isValid();
    }

    /// Retornar si la tarjeta es valida
    public boolean isCreditCardValid(TarjetaCredito card){
        return card.isValid();
    }

    // Comparar si es la misma tarjeta de Credito
    public boolean mismaTarjeta(TarjetaCredito tarjetaCredito, TarjetaCredito tarjetaCredito1){
        return tarjetaCredito.equals(tarjetaCredito1);
    }

    // Retorna la tasa con la marca y el monto de operacion
    public String getTasaOperacion(Operacion operacion){
        final Marca marca = operacion.getTarjetaCredito().getMarca();
        Double tasa = marca.calcularTasa();
        Double monto = operacion.getMonto();
        return  "Tasa = " + Math.round(tasa) +
                ", Marca = " + marca.getNombre() +
                ", Monto = " + monto;
    }

    public Marca getTarjetaNombre(String nombre){
        switch (nombre.toLowerCase()) {
            case "visa":
                return VISA.getInstance();
            case "nara":
                return NARA.getInstance();
            case "amex":
                return AMEX.getInstance();
            default:
                throw new IllegalArgumentException("La tarjeta no existe");
        }
    }
}
