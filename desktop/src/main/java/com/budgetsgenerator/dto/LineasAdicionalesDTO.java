package com.budgetsgenerator.dto;

public class LineasAdicionalesDTO {
    private Integer id;
    private String nombre;
    private String tipo;
    private int numLineas;
    private String llamadas;
    private String gb;
    private String fibra;
    private double precio;
    
    public LineasAdicionalesDTO() {
    }

    public LineasAdicionalesDTO(Integer id, String nombre, String tipo, int numLineas, String llamadas, String gb, String fibra,
            double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numLineas = numLineas;
        this.llamadas = llamadas;
        this.gb = gb;
        this.fibra = fibra;
        this.precio = precio;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getNumLineas() {
        return numLineas;
    }
    public void setNumLineas(int numLineas) {
        this.numLineas = numLineas;
    }
    public String getLlamadas() {
        return llamadas;
    }
    public void setLlamadas(String llamadas) {
        this.llamadas = llamadas;
    }
    public String getGb() {
        return gb;
    }
    public void setGb(String gb) {
        this.gb = gb;
    }
    public String getFibra() {
        return fibra;
    }
    public void setFibra(String fibra) {
        this.fibra = fibra;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
