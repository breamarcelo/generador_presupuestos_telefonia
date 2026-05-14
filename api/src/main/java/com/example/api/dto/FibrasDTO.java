package com.example.api.dto;

public class FibrasDTO {
    private int id;
    private String nombre;
    private double sobrecargo;
    private TarifasDTO tarifa;
    public FibrasDTO() {
    }
    public FibrasDTO(int id, String nombre, double sobrecargo, TarifasDTO tarifa) {
        this.id = id;
        this.nombre = nombre;
        this.sobrecargo = sobrecargo;
        this.tarifa = tarifa;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSobrecargo() {
        return sobrecargo;
    }
    public void setSobrecargo(double sobrecargo) {
        this.sobrecargo = sobrecargo;
    }
    public TarifasDTO getTarifa() {
        return tarifa;
    }
    public void setTarifa(TarifasDTO tarifa) {
        this.tarifa = tarifa;
    }
    
}
