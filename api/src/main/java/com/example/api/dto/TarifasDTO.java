package com.example.api.dto;

public class TarifasDTO {
    private int id;
    private String nombre;
    private String tipo;
    private int lineasMoviles;
    private String llamadasMovil;
    private String gbMovil;
    private double precio;
    private ServiciosAdicionalesDTO serviciosAdicionales;
    private boolean tv;
    private boolean streaming;
    public TarifasDTO() {
    }
    public TarifasDTO(int id, String nombre, String tipo, int lineasMoviles, String llamadasMovil, String gbMovil,
            double precio, ServiciosAdicionalesDTO serviciosAdicionales, boolean tv, boolean streaming) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.lineasMoviles = lineasMoviles;
        this.llamadasMovil = llamadasMovil;
        this.gbMovil = gbMovil;
        this.precio = precio;
        this.serviciosAdicionales = serviciosAdicionales;
        this.tv = tv;
        this.streaming = streaming;
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
    public int getLineasMoviles() {
        return lineasMoviles;
    }
    public void setLineasMoviles(int lineasMoviles) {
        this.lineasMoviles = lineasMoviles;
    }
    public String getLlamadasMovil() {
        return llamadasMovil;
    }
    public void setLlamadasMovil(String llamadasMovil) {
        this.llamadasMovil = llamadasMovil;
    }
    public String getGbMovil() {
        return gbMovil;
    }
    public void setGbMovil(String gbMovil) {
        this.gbMovil = gbMovil;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public ServiciosAdicionalesDTO getServiciosAdicionales() {
        return serviciosAdicionales;
    }
    public void setServiciosAdicionales(ServiciosAdicionalesDTO serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }
    public boolean isTv() {
        return tv;
    }
    public void setTv(boolean tv) {
        this.tv = tv;
    }
    public boolean isStreaming() {
        return streaming;
    }
    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }
    
}
