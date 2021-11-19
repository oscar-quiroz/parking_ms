package com.misiontic.parking_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {

    @Id
    private String id;
    private Date fecha_entrada;
    private Date fecha_salida ;
    private Vehiculo vehiculo;
    private Double valorTotal;

    public Transaction() {

    }

    public Transaction(String id, Date fecha_entrada, Date fecha_salida, Vehiculo vehiculo, Double valorTotal) {
        this.id = id;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.vehiculo = vehiculo;
        this.valorTotal = valorTotal;
    }



    /**
     *getters and setters
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valor) {
        this.valorTotal = valor;
    }
}
