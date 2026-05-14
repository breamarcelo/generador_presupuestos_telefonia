package com.budgetsgenerator.views;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.dto.StreamingDTO;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProductosView extends GridPane{
    private final HBox buttonsHBox = new HBox();
    private final Button limpiarButton = new Button("Limpiar");
    private final Button guardarButton = new Button("Guardar");

    private final VBox descuentosVBox = new VBox();
    private final Label descuentosVBoxLabel = new Label("DESCUENTOS");
    private final Label descuentosPorcientoLabel = new Label("Porciento");
    private final TextField descuentosPorcientoTextField = new TextField();
    private final HBox descuentosButtonsBox = new HBox();
    private final Button descuentosAgregarButton = new Button("Añadir");
    private final Button descuentosModificarButton = new Button("Modificar");
    private final Button descuentosEliminarButton = new Button("Eliminar");
    private final ListView<DescuentosDTO> descuentosListView = new ListView<>();

    private final VBox streamingVBox = new VBox();
    private final Label streamingVBoxLabel = new Label("STREAMING");
    private final Label streamingNombreLabel = new Label("Nombre");
    private final TextField streamingNombreTextField = new TextField();
    private final HBox streamingButtonsBox = new HBox();
    private final Button streamingAgregarButton = new Button("Añadir");
    private final Button streamingModificarButton = new Button("Modificar");
    private final Button streamingEliminarButton = new Button("Eliminar");
    private final ListView<StreamingDTO> streamingListView = new ListView<>();

    private final VBox centralitasVBox = new VBox();
    private final Label centralitasVBoxLabel = new Label("CENTRALITAS");
    private final Label centralitasNombreLabel = new Label("Nombre");
    private final TextField centralitasNombreTextField = new TextField();
    private final Label centralitasPrecioLabel = new Label("Precio");
    private final TextField centralitasPrecioTextField = new TextField();
    private final HBox centralitasButtonsBox = new HBox();
    private final Button centralitasAgregarButton = new Button("Añadir");
    private final Button centralitasModificarButton = new Button("Modificar");
    private final Button centralitasEliminarButton = new Button("Eliminar");
    private final ListView<CentralitasDTO> centralitasListView = new ListView<>();
    
    private final VBox packsFutbolVBox = new VBox();
    private final Label packsFutbolVBoxLabel = new Label("PACKS FÚTBOL");
    private final Label packsFutbolNombreLabel = new Label("Nombre");
    private final TextField packsFutbolNombreTextField = new TextField();
    private final Label packsFutbolPrecioLabel = new Label("Precio");
    private final TextField packsFutbolPrecioTextField = new TextField();
    private final HBox packsFutbolButtonsBox = new HBox();
    private final Button packsFutbolAgregarButton = new Button("Añadir");
    private final Button packsFutbolModificarButton = new Button("Modificar");
    private final Button packsFutbolEliminarButton = new Button("Eliminar");
    private final ListView<PacksFutbolDTO> packsFutbolListView = new ListView<>();

    public ProductosView() {
        this.getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
        this.getStylesheets().add(getClass().getResource("/css/productos.css").toExternalForm());
        this.getStyleClass().add("gridpane");
        
        this.getColumnConstraints().addAll(new ColumnConstraints(), new ColumnConstraints());
        this.getColumnConstraints().get(0).setPercentWidth(50);
        this.getColumnConstraints().get(1).setPercentWidth(50);
        
        this.add(buttonsHBox, 0, 0, 2, 1);
        this.add(descuentosVBox, 0,1, 1,1);
        this.add(streamingVBox, 1, 1, 1, 1);
        this.add(centralitasVBox, 0, 2, 1, 1);
        this.add(packsFutbolVBox, 1, 2, 1, 1);
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

    public VBox getDescuentosVBox() {
        return descuentosVBox;
    }

    public Label getDescuentosVBoxLabel() {
        return descuentosVBoxLabel;
    }

    public Label getDescuentosPorcientoLabel() {
        return descuentosPorcientoLabel;
    }

    public TextField getDescuentosPorcientoTextField() {
        return descuentosPorcientoTextField;
    }

    public HBox getDescuentosButtonsBox() {
        return descuentosButtonsBox;
    }

    public Button getDescuentosAgregarButton() {
        return descuentosAgregarButton;
    }

    public Button getDescuentosModificarButton() {
        return descuentosModificarButton;
    }

    public Button getDescuentosEliminarButton() {
        return descuentosEliminarButton;
    }

    public ListView<DescuentosDTO> getDescuentosListView() {
        return descuentosListView;
    }

    public VBox getStreamingVBox() {
        return streamingVBox;
    }

    public Label getStreamingVBoxLabel() {
        return streamingVBoxLabel;
    }

    public Label getStreamingNombreLabel() {
        return streamingNombreLabel;
    }

    public TextField getStreamingNombreTextField() {
        return streamingNombreTextField;
    }

    public HBox getStreamingButtonsBox() {
        return streamingButtonsBox;
    }

    public Button getStreamingAgregarButton() {
        return streamingAgregarButton;
    }

    public Button getStreamingModificarButton() {
        return streamingModificarButton;
    }

    public Button getStreamingEliminarButton() {
        return streamingEliminarButton;
    }

    public ListView<StreamingDTO> getStreamingListView() {
        return streamingListView;
    }

    public VBox getCentralitasVBox() {
        return centralitasVBox;
    }

    public Label getCentralitasVBoxLabel() {
        return centralitasVBoxLabel;
    }

    public Label getCentralitasNombreLabel() {
        return centralitasNombreLabel;
    }

    public TextField getCentralitasNombreTextField() {
        return centralitasNombreTextField;
    }

    public Label getCentralitasPrecioLabel() {
        return centralitasPrecioLabel;
    }

    public TextField getCentralitasPrecioTextField() {
        return centralitasPrecioTextField;
    }

    public HBox getCentralitasButtonsBox() {
        return centralitasButtonsBox;
    }

    public Button getCentralitasAgregarButton() {
        return centralitasAgregarButton;
    }

    public Button getCentralitasModificarButton() {
        return centralitasModificarButton;
    }

    public Button getCentralitasEliminarButton() {
        return centralitasEliminarButton;
    }

    public ListView<CentralitasDTO> getCentralitasListView() {
        return centralitasListView;
    }

    public VBox getPacksFutbolVBox() {
        return packsFutbolVBox;
    }

    public Label getPacksFutbolVBoxLabel() {
        return packsFutbolVBoxLabel;
    }

    public Label getPacksFutbolNombreLabel() {
        return packsFutbolNombreLabel;
    }

    public TextField getPacksFutbolNombreTextField() {
        return packsFutbolNombreTextField;
    }

    public Label getPacksFutbolPrecioLabel() {
        return packsFutbolPrecioLabel;
    }

    public TextField getPacksFutbolPrecioTextField() {
        return packsFutbolPrecioTextField;
    }

    public HBox getPacksFutbolButtonsBox() {
        return packsFutbolButtonsBox;
    }

    public Button getPacksFutbolAgregarButton() {
        return packsFutbolAgregarButton;
    }

    public Button getPacksFutbolModificarButton() {
        return packsFutbolModificarButton;
    }

    public Button getPacksFutbolEliminarButton() {
        return packsFutbolEliminarButton;
    }

    public ListView<PacksFutbolDTO> getPacksFutbolListView() {
        return packsFutbolListView;
    }

    
}
