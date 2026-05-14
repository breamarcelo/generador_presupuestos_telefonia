package com.budgetsgenerator.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TFibras")
public class FibrasEntity {
    @Id
    @Column(name="PK_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="Nombre")
    private String nombre;

    @Column(name="Sobrecargo")
    private double sobrecargo;

    @ManyToOne
    @JoinColumn(name="FK_Tarifas_ID")
    private TarifasEntity tarifa;

    @OneToOne(mappedBy="fibra")
    private PresupuestosEntity presupuesto;

    public FibrasEntity() {
    }

    public FibrasEntity(int id, String nombre, double sobrecargo, TarifasEntity tarifa) {
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

    public TarifasEntity getTarifa() {
        return tarifa;
    }

    public void setTarifa(TarifasEntity tarifa) {
        this.tarifa = tarifa;
    }
}
