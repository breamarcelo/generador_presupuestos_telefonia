package com.budgetsgenerator.xml.models;

import jakarta.xml.bind.annotation.XmlElement;

public class LineasPresupuestoXml {
    private String cantidad;
    private String descripcion;
    private String importe;
    
    public LineasPresupuestoXml() {
    }

    @XmlElement(name="Cantidad")
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @XmlElement(name="Descripcion")
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlElement(name="Importe")
    public String getImporte() {
        return importe;
    }
    public void setImporte(String importe) {
        this.importe = importe;
    }
}
