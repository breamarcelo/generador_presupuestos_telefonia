package com.budgetsgenerator.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TLineas_adicionales_presupuesto")
public class LineasPresupuestoEntity {
    @Id
    @Column(name="PK_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name="FK_LineaAdicional_ID")
    private LineasAdicionalesEntity lineaAdicional;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="FK_Presupuesto_ID", nullable=false)
    private PresupuestosEntity presupuesto;

    public LineasPresupuestoEntity() {
    }

    public LineasPresupuestoEntity(int id, int cantidad, LineasAdicionalesEntity lineaAdicional,
            PresupuestosEntity presupuesto) {
        this.id = id;
        this.cantidad = cantidad;
        this.lineaAdicional = lineaAdicional;
        this.presupuesto = presupuesto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LineasAdicionalesEntity getLineaAdicional() {
        return lineaAdicional;
    }

    public void setLineaAdicional(LineasAdicionalesEntity lineaAdicional) {
        this.lineaAdicional = lineaAdicional;
    }

    public PresupuestosEntity getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(PresupuestosEntity presupuesto) {
        this.presupuesto = presupuesto;
    }

    
}
