package com.example.api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TTarifas")
public class TarifasEntity {
    @Id
    @Column(name="PK_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="Nombre")
    private String nombre;

    @Column(name="Tipo")
    private String tipo;

    @Column(name="Lineas_moviles")
    private int lineasMoviles;

    @Column(name="Llamadas_movil")
    private String llamadasMovil;

    @Column(name="Gb_movil")
    private String gbMovil;

    @OneToMany(mappedBy="tarifa", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<FibrasEntity> fibras = new ArrayList<>();

    @Column(name="Precio")
    private double precio;

    @OneToOne
    @JoinColumn(name="FK_Servicios_ID")
    private ServiciosAdicionalesEntity serviciosAdicionales;

    @OneToOne(mappedBy="tarifa")
    private PresupuestosEntity presupuesto;

    @Column(name="Tv")
    private boolean tv;

    @Column(name="Servicio_streaming")
    private boolean streaming;

    public TarifasEntity() {
    }

    public TarifasEntity(int id, String nombre, String tipo, int lineasMoviles, String llamadasMovil, String gbMovil,
            List<FibrasEntity> fibras, double precio,
            ServiciosAdicionalesEntity serviciosAdicionales, boolean tv, boolean streaming) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.lineasMoviles = lineasMoviles;
        this.llamadasMovil = llamadasMovil;
        this.gbMovil = gbMovil;
        this.fibras = fibras;
        this.precio = precio;
        this.serviciosAdicionales = serviciosAdicionales;
        this.tv = tv;
        this.streaming = streaming;
    }

    public void addFibra(FibrasEntity fibra) {
        fibras.add(fibra);
        fibra.setTarifa(this);
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

    public ServiciosAdicionalesEntity getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public void setServiciosAdicionales(ServiciosAdicionalesEntity serviciosAdicionales) {
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

    public List<FibrasEntity> getFibras() {
        return fibras;
    }

    public void setFibras(List<FibrasEntity> fibras) {
        this.fibras = fibras;
    }

}
