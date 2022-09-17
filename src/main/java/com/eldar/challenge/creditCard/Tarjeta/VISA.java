package com.eldar.challenge.creditCard.Tarjeta;

import com.eldar.challenge.creditCard.Marca;

import java.time.LocalDate;

public class VISA extends Marca {
    private static VISA instance;

    private VISA(){
    }

    public static VISA getInstance() {
        if (instance == null) {
            instance = new VISA();
        }
        return instance;
    }

    @Override
    public Double calcularTasa() {
        double tasa = (double) LocalDate.now().getYear() / LocalDate.now().getMonthValue();
        if(tasa < 0.3) return 0.3;
        if(tasa > 5) return 5d;
        return tasa;
    }
}
