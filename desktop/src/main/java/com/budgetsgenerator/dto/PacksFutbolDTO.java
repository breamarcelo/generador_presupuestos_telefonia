package com.budgetsgenerator.dto;

public class PacksFutbolDTO {
    private Integer id;
    private String nombre;
    private double precio;
    
    public PacksFutbolDTO() {
    }
    
    public PacksFutbolDTO(Integer id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
