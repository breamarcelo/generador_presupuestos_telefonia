package com.budgetsgenerator.views;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.LineasAdicionalesDTO;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LineasAdicionalesView extends GridPane {
    private final HBox buttonsHBox = new HBox();
    private final Button limpiarButton = new Button("Limpiar");
    private final Button guardarButton = new Button("Guardar");

    private final VBox formularioVBox = new VBox();
    private final Label formularioLabel = new Label("LÍNEAS ADICIONALES");
    private final Label formularioNombreLabel = new Label("Nombre");
    private final TextField formularioNombreTextField = new TextField();
    private final Label formularioTipoLabel = new Label("Tipo");
    private final TextField formularioTipoTextField = new TextField();
    private final Label formularioNumLineasLabel = new Label("Número de líneas");
    private final TextField formularioNumLineasTextField = new TextField();
    private final Label formularioLlamadasLabel = new Label("Llamadas");
    private final TextField formularioLlamadasTextField = new TextField();
    private final Label formularioGbLabel = new Label("Gb");
    private final TextField formularioGbTextField = new TextField();
    private final Label formularioFibraLabel = new Label("Fibra");
    private final TextField formularioFibraTextField = new TextField();
    private final Label formularioPrecioLabel = new Label("Precio");
    private final TextField formularioPrecioTextField = new TextField();
    private final HBox listaButtonsBox = new HBox();
    private final Button agregarLineaButton = new Button("Añadir");
    private final Button modificarLineaButton = new Button("Modificar");
    private final Button eliminarLineaButton = new Button("Eliminar");
    private final ListView<LineasAdicionalesDTO> listaView = new ListView<>();

    public LineasAdicionalesView() {
        this.getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
        this.getStylesheets().add(getClass().getResource("/css/lineas_adicionales.css").toExternalForm());
        this.getStyleClass().add("gridpane");
        
        this.getColumnConstraints().addAll(new ColumnConstraints(), new ColumnConstraints());
        this.getColumnConstraints().get(0).setPercentWidth(50);
        this.getColumnConstraints().get(1).setPercentWidth(50);
        
        this.add(buttonsHBox, 0, 0, 2, 1);
        this.add(formularioVBox, 0, 1, 2, 1);
    }

    public HBox getButtonsHBox() {
        return buttonsHBox;
    }

    public Button getLimpiarButton() {
        return limpiarButton;
    }

    public Button getGuardarButton() {
        return guardarButton;
    }

    public VBox getFormularioVBox() {
        return formularioVBox;
    }

    public Label getFormularioLabel() {
        return formularioLabel;
    }

    public Label getFormularioNombreLabel() {
        return formularioNombreLabel;
    }

    public TextField getFormularioNombreTextField() {
        return formularioNombreTextField;
    }

    public Label getFormularioTipoLabel() {
        return formularioTipoLabel;
    }

    public TextField getFormularioTipoTextField() {
        return formularioTipoTextField;
    }

    public Label getFormularioNumLineasLabel() {
        return formularioNumLineasLabel;
    }

    public TextField getFormularioNumLineasTextField() {
        return formularioNumLineasTextField;
    }

    public Label getFormularioLlamadasLabel() {
        return formularioLlamadasLabel;
    }

    public TextField getFormularioLlamadasTextField() {
        return formularioLlamadasTextField;
    }

    public Label getFormularioGbLabel() {
        return formularioGbLabel;
    }

    public TextField getFormularioGbTextField() {
        return formularioGbTextField;
    }

    public Label getFormularioFibraLabel() {
        return formularioFibraLabel;
    }

    public TextField getFormularioFibraTextField() {
        return formularioFibraTextField;
    }

    public Label getFormularioPrecioLabel() {
        return formularioPrecioLabel;
    }

    public TextField getFormularioPrecioTextField() {
        return formularioPrecioTextField;
    }

    public ListView<LineasAdicionalesDTO> getListaView() {
        return listaView;
    }

    public HBox getListaButtonsBox() {
        return listaButtonsBox;
    }

    public Button getAgregarLineaButton() {
        return agregarLineaButton;
    }

    public Button getModificarLineaButton() {
        return modificarLineaButton;
    }

    public Button getEliminarLineaButton() {
        return eliminarLineaButton;
    }

    
}
