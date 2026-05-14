package com.budgetsgenerator.dto;

public class LineasPresupuestoDTO {
    private Integer id;
    private int cantidad;
    private LineasAdicionalesDTO lineasAdicional;
    private PresupuestosDTO presupuesto;
    
    public LineasPresupuestoDTO() {
    }
    public LineasPresupuestoDTO(Integer id, int cantidad, LineasAdicionalesDTO lineasAdicional) {
        this.id = id;
        this.cantidad = cantidad;
        this.lineasAdicional = lineasAdicional;
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
    public LineasAdicionalesDTO getLineasAdicional() {
        return lineasAdicional;
    }
    public void setLineasAdicional(LineasAdicionalesDTO lineasAdicional) {
        this.lineasAdicional = lineasAdicional;
    }

    public PresupuestosDTO getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(PresupuestosDTO presupuesto) {
        this.presupuesto = presupuesto;
    }
}
