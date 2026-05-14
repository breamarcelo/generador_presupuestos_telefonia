package com.example.api.dto;

public class LineasPresupuestoDTO {
    private int id;
    private int cantidad;
    private LineasAdicionalesDTO lineaAdicional;
    private PresupuestosDTO presupuesto;
    public LineasPresupuestoDTO() {
    }
    public LineasPresupuestoDTO(int id, int cantidad, LineasAdicionalesDTO lineaAdicional,
            PresupuestosDTO presupuesto) {
        this.id = id;
        this.cantidad = cantidad;
        this.lineaAdicional = lineaAdicional;
        this.presupuesto = presupuesto;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public LineasAdicionalesDTO getLineaAdicional() {
        return lineaAdicional;
    }
    public void setLineaAdicional(LineasAdicionalesDTO lineaAdicional) {
        this.lineaAdicional = lineaAdicional;
    }
    public PresupuestosDTO getPresupuesto() {
        return presupuesto;
    }
    public void setPresupuesto(PresupuestosDTO presupuesto) {
        this.presupuesto = presupuesto;
    }
    
}
