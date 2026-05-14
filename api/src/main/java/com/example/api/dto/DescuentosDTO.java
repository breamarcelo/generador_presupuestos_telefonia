package com.example.api.dto;

public class DescuentosDTO {
    private int id;
    private int porciento;
    public DescuentosDTO() {
    }
    public DescuentosDTO(int id, int porciento) {
        this.id = id;
        this.porciento = porciento;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPorciento() {
        return porciento;
    }
    public void setPorciento(int porciento) {
        this.porciento = porciento;
    }
    
}
