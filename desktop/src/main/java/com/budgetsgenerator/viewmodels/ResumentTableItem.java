package com.budgetsgenerator.viewmodels;

import javafx.scene.control.ListView;

public class ResumentTableItem {
    private int cantidad;
    private ListView<String> descripcion;
    private double importe;
    public ResumentTableItem() {
    }
    public ResumentTableItem(int cantidad, ListView<String> descripcion, double importe) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.importe = importe;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public ListView<String> getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(ListView<String> descripcion) {
        this.descripcion = descripcion;
    }
    public double getImporte() {
        return importe;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }

    
}
