package com.example.api.dto;

public class LineasAdicionalesDTO {
    private int id;
    private String nombre;
    private String tipo;
    private int numeroLineas;
    private String llamadas;
    private String gb;
    private String fibra;
    private double precio;
    public LineasAdicionalesDTO() {
    }
    public LineasAdicionalesDTO(int id, String nombre, String tipo, int numeroLineas, String llamadas, String gb,
            String fibra, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numeroLineas = numeroLineas;
        this.llamadas = llamadas;
        this.gb = gb;
        this.fibra = fibra;
        this.precio = precio;
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
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getNumeroLineas() {
        return numeroLineas;
    }
    public void setNumeroLineas(int numeroLineas) {
        this.numeroLineas = numeroLineas;
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
    
}
