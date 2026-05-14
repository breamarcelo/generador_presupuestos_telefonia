package com.budgetsgenerator.views;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SidebarView extends VBox{
    private Button presupuestosButton = new Button("PRESUPUESTOS");
    private Button tarifasButton = new Button("TARIFAS");
    private Button lineasAdicionalesButton = new Button("LÍNEAS ADICIONALES");
    private Button productosButton = new Button("PRODUCTOS");
    private Button ajustesButton = new Button("AJUSTES");

    public SidebarView() {
        
    }

    public Button getPresupuestosButton() {
        return presupuestosButton;
    }

    public void setPresupuestosButton(Button presupuestosButton) {
        this.presupuestosButton = presupuestosButton;
    }

    public Button getTarifasButton() {
        return tarifasButton;
    }

    public void setTarifasButton(Button tarifasButton) {
        this.tarifasButton = tarifasButton;
    }

    public Button getProductosButton() {
        return productosButton;
    }

    public void setProductosButton(Button productosButton) {
        this.productosButton = productosButton;
    }

    public Button getAjustesButton() {
        return ajustesButton;
    }

    public void setAjustesButton(Button ajustesButton) {
        this.ajustesButton = ajustesButton;
    }

    public Button getLineasAdicionalesButton() {
        return lineasAdicionalesButton;
    }

}
