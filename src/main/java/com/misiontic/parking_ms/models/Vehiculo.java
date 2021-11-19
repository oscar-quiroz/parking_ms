package com.misiontic.parking_ms.models;

import org.springframework.data.annotation.Id;

public class Vehiculo {

    @Id
    private String placa;
    private String tipo_vehiculo;
    private String propietario;
    private Double valorHora;
    private boolean estaDentro;

    public Vehiculo(String placa, String tipo_vehiculo, String propietario, Double valorHora, boolean estaDentro) {
        this.placa = placa;
        this.tipo_vehiculo = tipo_vehiculo;
        this.propietario = propietario;
        this.valorHora = valorHora;
        this.estaDentro = estaDentro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public boolean isEstaDentro() {
        return estaDentro;
    }

    public void setEstaDentro(boolean estaDentro) {
        this.estaDentro = estaDentro;
    }
}
