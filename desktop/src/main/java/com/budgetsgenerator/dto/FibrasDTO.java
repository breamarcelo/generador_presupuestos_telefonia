package com.budgetsgenerator.dto;

public class FibrasDTO {
    private int id;
    private String nombre;
    private double sobrecargo;
    private int tarifas;
    
    public FibrasDTO() {
    }

    public FibrasDTO(int id, String nombre, double sobrecargo, int tarifas) {
        this.id = id;
        this.nombre = nombre;
        this.sobrecargo = sobrecargo;
        this.tarifas = tarifas;
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
    public int getTarifas() {
        return tarifas;
    }
    public void setTarifas(int tarifas) {
        this.tarifas = tarifas;
    }
}
