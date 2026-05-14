package com.budgetsgenerator.dto;

public class DescuentosDTO {
    private Integer id;
    private int porciento;
    
    public DescuentosDTO() {
    }
    
    public DescuentosDTO(Integer id, int porciento) {
        this.id = id;
        this.porciento = porciento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPorciento() {
        return porciento;
    }

    public void setPorciento(int porciento) {
        this.porciento = porciento;
    }
}
