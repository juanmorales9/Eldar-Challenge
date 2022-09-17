package com.eldar.challenge.creditCard.Tarjeta;

import com.eldar.challenge.creditCard.Marca;

import java.time.LocalDate;

public class AMEX extends Marca {
    private static AMEX instance;

    private AMEX(){
    }

    public static AMEX getInstance() {
        if (instance == null) {
            instance = new AMEX();
        }
        return instance;
    }

    @Override
    public Double calcularTasa() {
        double tasa = LocalDate.now().getMonthValue() * 0.1;
        if(tasa < 0.3) return 0.3;
        if(tasa > 5) return 5d;
        return tasa;
    }
}
