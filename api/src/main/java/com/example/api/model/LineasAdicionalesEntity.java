package com.example.api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TLineas_adicionales")
public class LineasAdicionalesEntity {
    @Id
    @Column(name="PK_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Nombre")
    private String nombre;

    @Column(name="Tipo")
    private String tipo;

    @Column(name="Num_lineas")
    private int numLineas;

    @Column(name="Llamadas")
    private String llamadas;

    @Column(name="Gb")
    private String gb;
    
    @Column(name="Fibra")
    private String fibra;

    @Column(name="Precio")
    private double precio;

    @OneToMany(mappedBy="lineaAdicional", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LineasPresupuestoEntity> lineasPresupuesto;

    public LineasAdicionalesEntity() {
    }

    public LineasAdicionalesEntity(Integer id, String nombre, String tipo, int numLineas, String llamadas, String gb,
            String fibra, double precio) {
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

    public List<LineasPresupuestoEntity> getLineasPresupuesto() {
        return lineasPresupuesto;
    }

    public void setLineasPresupuesto(List<LineasPresupuestoEntity> lineasPresupuesto) {
        this.lineasPresupuesto = lineasPresupuesto;
    }
    
}
