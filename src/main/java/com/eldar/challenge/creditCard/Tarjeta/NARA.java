package com.eldar.challenge.creditCard.Tarjeta;

import com.eldar.challenge.creditCard.Marca;

import java.time.LocalDate;

public class NARA extends Marca {
    private static NARA instance;

    private NARA(){
    }

    public static NARA getInstance() {
        if (instance == null) {
            instance = new NARA();
        }
        return instance;
    }

    @Override
    public Double calcularTasa() {
        double tasa = LocalDate.now().getDayOfMonth() * 0.5;
        if(tasa < 0.3) return 0.3;
        if(tasa > 5) return 5d;
        return tasa;
    }
}
