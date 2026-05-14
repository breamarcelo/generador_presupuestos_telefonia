package com.budgetsgenerator.views;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.FibrasDTO;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TarifasView extends GridPane{
    private final HBox buttonsBox = new HBox();
    private final Button nuevoButton = new Button("Nuevo");
    private final Button abrirButton = new Button("Abrir");
    private final Button actualizarButton = new Button("Actualizar");
    private final Button guardarButton = new Button("Guardar");

    private final VBox tarifasBox = new VBox();
    private final Label tarifasBoxLabel = new Label("TARIFA");
    private final Label tarifaNombreLabel = new Label("Nombre: ");
    private final TextField tarifaNombreTextField = new TextField();
    private final Label tarifaTipoLabel = new Label("Tipo: ");
    private final TextField tarifaTipoTextField = new TextField();
    private final Label tarifaPrecioLabel = new Label("Precio: ");
    private final TextField tarifaPrecioTextField = new TextField();
    private final HBox checkboxesBox = new HBox();
    private final Label tarifaTvLabel = new Label("Orange TV: ");
    private final CheckBox tarifaTvCheckBox = new CheckBox();
    private final Label tarifaStreamingLabel = new Label("Servicio streaming: ");
    private final CheckBox tarifaStreamingCheckBox = new CheckBox();
    
    private final VBox fibrasBox = new VBox();
    private final Label fibrasBoxLabel = new Label("FIBRAS");
    private final Label fibraNombreLabel = new Label("Nombre: ");
    private final TextField fibraNombreTextField = new TextField();
    private final Label fibraSobrecargoLabel = new Label("Sobrecargo: ");
    private final TextField fibraSobrecargoTextField = new TextField();
    private final ListView<FibrasDTO> fibrasListView = new ListView<>();
    private final HBox botonesFibrasHBox = new HBox();
    private final Button agregarFibraButton = new Button("Añadir");
    private final Button modificarFibraButton = new Button("Modificar");
    private final Button eliminarFibraButton = new Button("Eliminar");

    private final VBox lineasBox = new VBox();
    private final Label lineasBoxLabel = new Label("LÍNEAS MÓVILES");
    private final Label lineasNumLabel = new Label("Número de líneas:");
    private final TextField lineasNumField = new TextField();
    private final Label lineasLlamadasabel = new Label("Llamadas móvil:");
    private final TextField lineasLlamadasField = new TextField();
    private final Label lineasGbLabel = new Label("Gb móvil:");
    private final TextField lineasGbField = new TextField();

    private final VBox serviciosBox = new VBox();
    private final Label serviciosBoxLabel = new Label("SERVICIOS ADICIONALES");
    private final Label serviciosRoamingLabel = new Label("Roaming:");
    private final TextField serviciosRoamingTextField = new TextField();
    private final Label serviciosInternacionalLabel = new Label("Internacional:");
    private final TextField serviciosInternacionalTextField = new TextField();
    private final HBox serviciosCheckboxes1Box = new HBox();
    private final Label serviciosLegalitasLabel = new Label("Legálitas: ");
    private final CheckBox serviciosLegalitasBox = new CheckBox();
    private final Label serviciosCloudLabel = new Label("Cloud: ");
    private final CheckBox serviciosCloudBox = new CheckBox();
    private final HBox serviciosCheckboxes2Box = new HBox();
    private final Label serviciosCiberProteccionLabel = new Label("Ciber protección: ");
    private final CheckBox serviciosCiberProteccionBox = new CheckBox();
    private final Label serviciosAtencionPersonalizadaLabel = new Label("Atencion personalizada: ");
    private final CheckBox serviciosAtencionPersonalizadaBox = new CheckBox();
    private final Label serviciosCentralitaLabel = new Label("Centralita:");
    private final TextField serviciosCentralitaTextField = new TextField();
    private final Label serviciosNumBeneficiosLabel = new Label("Número de beneficios:");
    private final TextField serviciosNumBeneficiosTextField = new TextField();
    private final Label serviciosDescuentoBeneficiosLabel = new Label("Descuento beneficios:");
    private final TextField serviciosDescuentoBeneficiosTextField = new TextField();
    
    public TarifasView() {
        this.getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
        this.getStylesheets().add(getClass().getResource("/css/tarifas.css").toExternalForm());
        this.getStyleClass().add("gridpane");

        this.getColumnConstraints().addAll(new ColumnConstraints(), new ColumnConstraints());
        this.getColumnConstraints().get(0).setPercentWidth(50);
        this.getColumnConstraints().get(1).setPercentWidth(50);

        this.add(buttonsBox, 0, 0, 2, 1);
        this.add(tarifasBox, 0, 1, 1, 1);
        this.add(fibrasBox, 0, 2, 1, 2);
        this.add(lineasBox, 1, 1, 1, 1);
        this.add(serviciosBox, 1, 2, 1, 2);
    }

    public HBox getButtonsBox() {
        return buttonsBox;
    }

    public Button getNuevoButton() {
        return nuevoButton;
    }

    public Button getAbrirButton() {
        return abrirButton;
    }

    public Button getActualizarButton() {
        return actualizarButton;
    }

    public Button getGuardarButton() {
        return guardarButton;
    }

    public VBox getTarifasBox() {
        return tarifasBox;
    }

    public Label getTarifasBoxLabel() {
        return tarifasBoxLabel;
    }

    public Label getTarifaNombreLabel() {
        return tarifaNombreLabel;
    }

    public TextField getTarifaNombreTextField() {
        return tarifaNombreTextField;
    }

    public Label getTarifaTipoLabel() {
        return tarifaTipoLabel;
    }

    public TextField getTarifaTipoTextField() {
        return tarifaTipoTextField;
    }

    public Label getTarifaTvLabel() {
        return tarifaTvLabel;
    }

    public CheckBox getTarifaTvCheckBox() {
        return tarifaTvCheckBox;
    }

    public Label getTarifaStreamingLabel() {
        return tarifaStreamingLabel;
    }

    public CheckBox getTarifaStreamingCheckBox() {
        return tarifaStreamingCheckBox;
    }

    public Label getTarifaPrecioLabel() {
        return tarifaPrecioLabel;
    }

    public TextField getTarifaPrecioTextField() {
        return tarifaPrecioTextField;
    }

    public HBox getCheckboxesBox() {
        return checkboxesBox;
    }

    public VBox getFibrasBox() {
        return fibrasBox;
    }

    public Label getFibrasBoxLabel() {
        return fibrasBoxLabel;
    }

    public Label getFibraNombreLabel() {
        return fibraNombreLabel;
    }

    public TextField getFibraNombreTextField() {
        return fibraNombreTextField;
    }

    public Label getFibraSobrecargoLabel() {
        return fibraSobrecargoLabel;
    }

    public TextField getFibraSobrecargoTextField() {
        return fibraSobrecargoTextField;
    }

    public VBox getServiciosBox() {
        return serviciosBox;
    }

    public Label getServiciosBoxLabel() {
        return serviciosBoxLabel;
    }

    public Label getServiciosRoamingLabel() {
        return serviciosRoamingLabel;
    }

    public TextField getServiciosRoamingTextField() {
        return serviciosRoamingTextField;
    }

    public Label getServiciosInternacionalLabel() {
        return serviciosInternacionalLabel;
    }

    public TextField getServiciosInternacionalTextField() {
        return serviciosInternacionalTextField;
    }

    public HBox getServiciosCheckboxes1Box() {
        return serviciosCheckboxes1Box;
    }

    public Label getServiciosLegalitasLabel() {
        return serviciosLegalitasLabel;
    }

    public CheckBox getServiciosLegalitasBox() {
        return serviciosLegalitasBox;
    }

    public Label getServiciosCloudLabel() {
        return serviciosCloudLabel;
    }

    public CheckBox getServiciosCloudBox() {
        return serviciosCloudBox;
    }

    public HBox getServiciosCheckboxes2Box() {
        return serviciosCheckboxes2Box;
    }

    public Label getServiciosCiberProteccionLabel() {
        return serviciosCiberProteccionLabel;
    }

    public CheckBox getServiciosCiberProteccionBox() {
        return serviciosCiberProteccionBox;
    }

    public Label getServiciosAtencionPersonalizadaLabel() {
        return serviciosAtencionPersonalizadaLabel;
    }

    public CheckBox getServiciosAtencionPersonalizadaBox() {
        return serviciosAtencionPersonalizadaBox;
    }

    public Label getServiciosCentralitaLabel() {
        return serviciosCentralitaLabel;
    }

    public TextField getServiciosCentralitaTextField() {
        return serviciosCentralitaTextField;
    }

    public Label getServiciosNumBeneficiosLabel() {
        return serviciosNumBeneficiosLabel;
    }

    public TextField getServiciosNumBeneficiosTextField() {
        return serviciosNumBeneficiosTextField;
    }

    public Label getServiciosDescuentoBeneficiosLabel() {
        return serviciosDescuentoBeneficiosLabel;
    }

    public TextField getServiciosDescuentoBeneficiosTextField() {
        return serviciosDescuentoBeneficiosTextField;
    }

    public ListView<FibrasDTO> getFibrasListView() {
        return fibrasListView;
    }

    public VBox getLineasBox() {
        return lineasBox;
    }

    public Label getLineasBoxLabel() {
        return lineasBoxLabel;
    }

    public Label getLineasNumLabel() {
        return lineasNumLabel;
    }

    public TextField getLineasNumField() {
        return lineasNumField;
    }

    public Label getLineasLlamadasabel() {
        return lineasLlamadasabel;
    }

    public TextField getLineasLlamadasField() {
        return lineasLlamadasField;
    }

    public Label getLineasGbLabel() {
        return lineasGbLabel;
    }

    public TextField getLineasGbField() {
        return lineasGbField;
    }

    public HBox getBotonesFibrasHBox() {
        return botonesFibrasHBox;
    }

    public Button getAgregarFibraButton() {
        return agregarFibraButton;
    }

    public Button getModificarFibraButton() {
        return modificarFibraButton;
    }

    public Button getEliminarFibraButton() {
        return eliminarFibraButton;
    }
    
    
}
