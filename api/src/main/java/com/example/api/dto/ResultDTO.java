package com.example.api.dto;

import java.util.List;

public class ResultDTO {
    private PresupuestosDTO presupuesto;
    private List<LineasPresupuestoDTO> lineas;
    private ServiciosAdicionalesDTO serviciosAdicionales;
    private double total;
    public ResultDTO() {
    }
    public ResultDTO(PresupuestosDTO presupuesto, List<LineasPresupuestoDTO> lineas, ServiciosAdicionalesDTO serviciosAdicionales) {
        this.presupuesto = presupuesto;
        this.lineas = lineas;
        this.serviciosAdicionales = serviciosAdicionales;
    }
    public PresupuestosDTO getPresupuesto() {
        return presupuesto;
    }
    public void setPresupuesto(PresupuestosDTO presupuesto) {
        this.presupuesto = presupuesto;
    }
    public List<LineasPresupuestoDTO> getLineas() {
        return lineas;
    }
    public void setLineas(List<LineasPresupuestoDTO> lineas) {
        this.lineas = lineas;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public ServiciosAdicionalesDTO getServiciosAdicionales() {
        return serviciosAdicionales;
    }
    public void setServiciosAdicionales(ServiciosAdicionalesDTO serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }
    
}
