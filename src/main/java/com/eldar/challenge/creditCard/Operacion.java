package com.eldar.challenge.creditCard;


public class Operacion {

    Double monto;
    TarjetaCredito tarjetaCredito;

    public Operacion(Double amount, TarjetaCredito card) {
        this.monto = amount;
        this.tarjetaCredito = card;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public boolean isValid(){
        int i = monto.compareTo(1000d);
        return i < 0;
    }

    private double getRate() {
        return tarjetaCredito.getMarca().calcularTasa();
    }
}
