package com.budgetsgenerator.models;

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
@Table(name="TPresupuestos")
public class PresupuestosEntity {
    @Id
    @Column(name="PK_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Nombre")
    private String nombre;

    @OneToOne
    @JoinColumn(name="FK_Tarifas_ID")
    private TarifasEntity tarifa;

    @OneToOne
    @JoinColumn(name="FK_Fibra_ID")
    private FibrasEntity fibra;

    @OneToOne
    @JoinColumn(name="FK_Streaming_ID")
    private StreamingEntity streaming;

    @OneToOne
    @JoinColumn(name="FK_Centralita_ID")
    private CentralitasEntity centralita;

    @OneToOne
    @JoinColumn(name="FK_PackFutbol_ID")
    private PacksFutbolEntity packFutbol;

    @OneToOne
    @JoinColumn(name="FK_Descuentos_ID")
    private DescuentosEntity descuento;

    @OneToMany(mappedBy="presupuesto", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LineasPresupuestoEntity> lineasPresupuesto;

    public PresupuestosEntity() {
    }

    public PresupuestosEntity(Integer id, String nombre, TarifasEntity tarifa, FibrasEntity fibra,
            StreamingEntity streaming, CentralitasEntity centralita, PacksFutbolEntity packFutbol,
            DescuentosEntity descuento) {
        this.id = id;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.fibra = fibra;
        this.streaming = streaming;
        this.centralita = centralita;
        this.packFutbol = packFutbol;
        this.descuento = descuento;
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

    public TarifasEntity getTarifa() {
        return tarifa;
    }

    public void setTarifa(TarifasEntity tarifa) {
        this.tarifa = tarifa;
    }

    public FibrasEntity getFibra() {
        return fibra;
    }

    public void setFibra(FibrasEntity fibra) {
        this.fibra = fibra;
    }

    public StreamingEntity getStreaming() {
        return streaming;
    }

    public void setStreaming(StreamingEntity streaming) {
        this.streaming = streaming;
    }

    public CentralitasEntity getCentralita() {
        return centralita;
    }

    public void setCentralita(CentralitasEntity centralita) {
        this.centralita = centralita;
    }

    public PacksFutbolEntity getPackFutbol() {
        return packFutbol;
    }

    public void setPackFutbol(PacksFutbolEntity packFutbol) {
        this.packFutbol = packFutbol;
    }

    public DescuentosEntity getDescuento() {
        return descuento;
    }

    public void setDescuento(DescuentosEntity descuento) {
        this.descuento = descuento;
    }

    public List<LineasPresupuestoEntity> getLineasPresupuesto() {
        return lineasPresupuesto;
    }

    public void setLineasPresupuesto(List<LineasPresupuestoEntity> lineasPresupuesto) {
        this.lineasPresupuesto = lineasPresupuesto;
    }

    
}
