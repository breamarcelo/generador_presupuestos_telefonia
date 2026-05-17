package com.budgetsgenerator.models;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TDescuentos")
public class DescuentosEntity {
    @Id
    @Column(name="PK_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="Porciento")
    private int porciento;

    @OneToMany(mappedBy="descuento")
    private List<PresupuestosEntity> presupuesto;

    public DescuentosEntity(){
    }

    public DescuentosEntity(int id, int porciento) {
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
    };

    
}
