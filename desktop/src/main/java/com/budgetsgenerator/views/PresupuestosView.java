package com.budgetsgenerator.views;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.viewmodels.ResumentTableItem;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PresupuestosView extends GridPane{
    private final VBox tarifasVBox = new VBox();
    private final Label tarifasVBoxLabel = new Label("TARIFAS");
    private final VBox lineasAdicionalesVBox = new VBox();
    private final Label lineasAdicionalesVBoxLabel = new Label("LÍNEAS ADICIONALES");
    private final VBox productosAdicionalesVBox = new VBox();
    private final Label productosAdicioanelesVBoxLabel = new Label("SERVICIOS ADICIONALES");
    private final VBox descuentosVBox = new VBox();

    private final Label descuentoLabel = new Label("Descuento:");
    private final VBox resumenVBox = new VBox();
    private final Label resumenVBoxLabel = new Label("RESUMEN");
    private final HBox totalHBox = new HBox();
    private final Label totalLabel = new Label("TOTAL:");
    private final TextField totalField = new TextField();
    private final TextField presupuestoField = new TextField();
    private final HBox buttonsHBox = new HBox();

    private final ComboBox<TarifasDTO> tarifasCombo = new ComboBox<>();
    private final ComboBox<FibrasDTO> fibraCombo = new ComboBox<>();
    private final ComboBox<StreamingDTO> streamingCombo = new ComboBox<>();
    private final ComboBox<DescuentosDTO> descuentoCombo = new ComboBox<>();
    private final ComboBox<CentralitasDTO> centralitaCombo = new ComboBox<>();
    private final ComboBox<PacksFutbolDTO> packsFutbolCombo = new ComboBox<>();
    private final ListView<HBox> lineasAdicionalesView = new ListView<>();
    private final TableView<ResumentTableItem> resumenView = new TableView<>();
    private final Button saveButton = new Button("Guardar");
    private final Button loadButton = new Button("Abrir");
    private final Button actualizarButton = new Button("Actualizar");
    private final Button eliminarButton = new Button("Eliminar");
    private final Button nuevoButton = new Button("Nuevo");
    private final Button generarPdfButton = new Button("Generar PDF");
    private final Label presupuestoLabel = new Label("Presupuestos");
    private final Label tarifaLabel = new Label("Tarifa:");
    private final Label fibraLabel = new Label("Fibra:");
    private final Label streamingLabel = new Label("Streaming:");
    private final Label lineasAdicionalesLabel = new Label("Líneas Adicionales:");
    private final Label centralitaLabel = new Label("Centralita:");
    private final Label packFutbolLabel = new Label("Pack Fútbol:");

    public PresupuestosView() {
        this.getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
        this.getStylesheets().add(getClass().getResource("/css/presupuestos.css").toExternalForm());
        this.getStyleClass().add("gridpane");

        presupuestoLabel.setId("presupuestos_title");
        totalLabel.setId("total_label");
        
        this.getColumnConstraints().addAll(new ColumnConstraints(), new ColumnConstraints());
        this.getColumnConstraints().get(0).setPercentWidth(50);
        this.getColumnConstraints().get(1).setPercentWidth(50);
        
        this.add(buttonsHBox, 0, 0, 2, 1);
        this.add(tarifasVBox, 0, 1, 1, 2);
        this.add(productosAdicionalesVBox, 0, 3, 1, 1);
        this.add(lineasAdicionalesVBox, 0, 4, 1, 2);
        this.add(descuentosVBox, 1, 1, 1, 1);
        this.add(resumenVBox, 1, 3, 1, 3);
    }

    public ComboBox<TarifasDTO> getTarifasCombo() {
        return tarifasCombo;
    }

    public ComboBox<FibrasDTO> getFibraCombo() {
        return fibraCombo;
    }

    public ComboBox<StreamingDTO> getStreamingCombo() {
        return streamingCombo;
    }

    public ComboBox<DescuentosDTO> getDescuentoCombo() {
        return descuentoCombo;
    }

    public ComboBox<CentralitasDTO> getCentralitaCombo() {
        return centralitaCombo;
    }

    public ComboBox<PacksFutbolDTO> getPacksFutbolCombo() {
        return packsFutbolCombo;
    }

    public ListView<HBox> getLineasAdicionalesView() {
        return lineasAdicionalesView;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getLoadButton() {
        return loadButton;
    }

    public TableView<ResumentTableItem> getResumenView() {
        return resumenView;
    }

    public String getTotalFieldText() {
        return totalField.getText();
    }

    public Button getNuevoButton() {
        return nuevoButton;
    }

    public Button getGenerarPdfButton() {
        return generarPdfButton;
    }

    public VBox getTarifasVBox() {
        return tarifasVBox;
    }

    public VBox getLineasAdicionalesVBox() {
        return lineasAdicionalesVBox;
    }

    public VBox getProductosAdicionalesVBox() {
        return productosAdicionalesVBox;
    }

    public Label getPresupuestoLabel() {
        return presupuestoLabel;
    }

    public Label getTarifaLabel() {
        return tarifaLabel;
    }

    public Label getFibraLabel() {
        return fibraLabel;
    }

    public Label getStreamingLabel() {
        return streamingLabel;
    }

    public Label getLineasAdicionalesLabel() {
        return lineasAdicionalesLabel;
    }

    public Label getDescuentoLabel() {
        return descuentoLabel;
    }

    public Label getCentralitaLabel() {
        return centralitaLabel;
    }

    public Label getPackFutbolLabel() {
        return packFutbolLabel;
    }

    public Label getTotalLabel() {
        return totalLabel;
    }

    public TextField getTotalField() {
        return totalField;
    }

    public Label getTarifasVBoxLabel() {
        return tarifasVBoxLabel;
    }

    public Label getLineasAdicionalesVBoxLabel() {
        return lineasAdicionalesVBoxLabel;
    }

    public Label getProductosAdicioanelesVBoxLabel() {
        return productosAdicioanelesVBoxLabel;
    }

    public VBox getResumenVBox() {
        return resumenVBox;
    }

    public Label getResumenVBoxLabel() {
        return resumenVBoxLabel;
    }

    public HBox getTotalHBox() {
        return totalHBox;
    }

    public Button getActualizarButton() {
        return actualizarButton;
    }

    public Button getEliminarButton() {
        return eliminarButton;
    }

    public TextField getPresupuestoField() {
        return presupuestoField;
    }

    public HBox getButtonsHBox() {
        return buttonsHBox;
    }

    public VBox getDescuentosVBox() {
        return descuentosVBox;
    }
}
