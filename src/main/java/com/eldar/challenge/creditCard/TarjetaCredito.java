package com.eldar.challenge.creditCard;

import java.time.Instant;
import java.util.Date;

public class TarjetaCredito {

    private Marca marca;
    private Long numero;
    private String cardholder;
    private Date fechaVencimiento;

    public TarjetaCredito(Marca brand, Long number, String cardholder, Date expiringDate) {
        this.marca = brand;
        this.numero = number;
        this.cardholder = cardholder;
        this.fechaVencimiento = expiringDate;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isValid(){
        return fechaVencimiento.after(Date.from(Instant.now()));
    }
}
