package com.budgetsgenerator.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.services.impl.CentralitasService;
import com.budgetsgenerator.services.impl.DescuentosService;
import com.budgetsgenerator.services.impl.PacksFutbolService;
import com.budgetsgenerator.services.impl.StreamingService;
import com.budgetsgenerator.views.ProductosView;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;

public class ProductosController {
    private ProductosView view;
    private List<DescuentosDTO> descuentoDTOs;
    private List<StreamingDTO> streamingDTOs;
    private List<CentralitasDTO> centralitasDTOs;
    private List<PacksFutbolDTO> packsFutbolDTOs;

    public ProductosController(ProductosView view) {
        this.view = view;
        load();
    }

    public void load() {
        descuentoDTOs = DescuentosService.getInstance().getAll();
        streamingDTOs = StreamingService.getInstance().getAll();
        centralitasDTOs = CentralitasService.getInstance().getAll();
        packsFutbolDTOs = PacksFutbolService.getInstance().getAll();
        view.getDescuentosListView().getItems().addAll(descuentoDTOs);
        view.getStreamingListView().getItems().addAll(streamingDTOs);
        view.getCentralitasListView().getItems().addAll(centralitasDTOs);
        view.getPacksFutbolListView().getItems().addAll(packsFutbolDTOs);

        view.getLimpiarButton().setOnAction(eh -> {
            limpiarFormulario();
        });
        
        view.getGuardarButton().setOnAction(eh -> {
            DescuentosService.updateAll(descuentoDTOs);
            StreamingService.updateAll(streamingDTOs);
            CentralitasService.updateAll(centralitasDTOs);
            PacksFutbolService.updateAll(packsFutbolDTOs);
            limpiarFormulario();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("dialog");
            alert.setContentText("Productos actualizados correctamente.");
            alert.setHeaderText("");
            alert.setTitle("Confirmación");
            alert.setGraphic(null);
            alert.getDialogPane().lookupButton(ButtonType.CANCEL).setVisible(false);
            alert.showAndWait();
        });

        view.getDescuentosListView().setCellFactory(param -> new ListCell<DescuentosDTO>() {
            @Override
            public void updateItem(DescuentosDTO item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(Integer.toString(item.getPorciento()) + "%");
                }
            }
        });

        view.getDescuentosListView().setOnMouseClicked(eh -> {
            DescuentosDTO selected = view.getDescuentosListView().getSelectionModel().getSelectedItem();
            view.getDescuentosPorcientoTextField().setText(Integer.toString(selected.getPorciento()));
        });

        view.getDescuentosAgregarButton().setOnAction(eh -> {
            if(!view.getDescuentosPorcientoTextField().getText().isEmpty()) {
                DescuentosDTO nuevo = new DescuentosDTO();
                nuevo.setPorciento(Integer.parseInt(view.getDescuentosPorcientoTextField().getText()));
                descuentoDTOs.add(nuevo);
                view.getDescuentosListView().getItems().clear();
                view.getDescuentosListView().getItems().addAll(descuentoDTOs);
                view.getDescuentosPorcientoTextField().setText("");
            }
        });

        view.getDescuentosModificarButton().setOnAction(eh -> {
            int index = view.getDescuentosListView().getSelectionModel().getSelectedIndex();
            DescuentosDTO selected = view.getDescuentosListView().getSelectionModel().getSelectedItem();
            if(!view.getDescuentosPorcientoTextField().getText().isEmpty()) {
                selected.setPorciento(Integer.parseInt(view.getDescuentosPorcientoTextField().getText()));
            }
            descuentoDTOs.set(index, selected);
            view.getDescuentosListView().getItems().clear();
            view.getDescuentosListView().getItems().addAll(descuentoDTOs);
            view.getDescuentosPorcientoTextField().setText("");
        });

        view.getDescuentosEliminarButton().setOnAction(eh-> {
            int index = view.getDescuentosListView().getSelectionModel().getSelectedIndex();
            descuentoDTOs.remove(index);
            view.getDescuentosListView().getItems().clear();
            view.getDescuentosListView().getItems().addAll(descuentoDTOs);
            view.getDescuentosPorcientoTextField().setText("");
        });

        view.getStreamingListView().setCellFactory(param -> new ListCell<StreamingDTO>() {
            @Override
            public void updateItem(StreamingDTO item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNombre());
                }
            }
        });

        view.getStreamingListView().setOnMouseClicked(eh -> {
            StreamingDTO selected = view.getStreamingListView().getSelectionModel().getSelectedItem();
            view.getStreamingNombreTextField().setText(selected.getNombre());
        });

        view.getStreamingAgregarButton().setOnAction(eh -> {
            if(!view.getStreamingNombreTextField().getText().isEmpty()) {
                StreamingDTO nuevo = new StreamingDTO();
                nuevo.setNombre(view.getStreamingNombreTextField().getText());
                streamingDTOs.add(nuevo);
                view.getStreamingListView().getItems().clear();
                view.getStreamingListView().getItems().addAll(streamingDTOs);
                view.getStreamingNombreTextField().setText("");
            }
        });

        view.getStreamingModificarButton().setOnAction(eh -> {
            int index = view.getStreamingListView().getSelectionModel().getSelectedIndex();
            StreamingDTO selected = view.getStreamingListView().getSelectionModel().getSelectedItem();
            if(!view.getStreamingNombreTextField().getText().isEmpty()) {
                selected.setNombre(view.getStreamingNombreTextField().getText());
            }
            streamingDTOs.set(index, selected);
            view.getStreamingListView().getItems().clear();
            view.getStreamingListView().getItems().addAll(streamingDTOs);
            view.getStreamingNombreTextField().setText("");
        });

        view.getStreamingEliminarButton().setOnAction(eh-> {
            int index = view.getStreamingListView().getSelectionModel().getSelectedIndex();
            streamingDTOs.remove(index);
            view.getStreamingListView().getItems().clear();
            view.getStreamingListView().getItems().addAll(streamingDTOs);
            view.getStreamingNombreTextField().setText("");
        });
        
        view.getPacksFutbolListView().setCellFactory(param -> new ListCell<PacksFutbolDTO>() {
            @Override
            public void updateItem(PacksFutbolDTO item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNombre());
                }
            }
        });

        view.getPacksFutbolListView().setOnMouseClicked(eh -> {
            PacksFutbolDTO selected = view.getPacksFutbolListView().getSelectionModel().getSelectedItem();
            view.getPacksFutbolNombreTextField().setText(selected.getNombre());
            view.getPacksFutbolPrecioTextField().setText(Double.toString(selected.getPrecio()));
        });

        view.getPacksFutbolAgregarButton().setOnAction(eh -> {
            if(!view.getPacksFutbolNombreTextField().getText().isEmpty()) {
                PacksFutbolDTO nuevo = new PacksFutbolDTO();
                nuevo.setNombre(view.getPacksFutbolNombreTextField().getText());
                nuevo.setPrecio(Double.parseDouble(view.getPacksFutbolPrecioTextField().getText()));
                packsFutbolDTOs.add(nuevo);
                view.getPacksFutbolListView().getItems().clear();
                view.getPacksFutbolListView().getItems().addAll(packsFutbolDTOs);
                view.getPacksFutbolNombreTextField().setText("");
                view.getPacksFutbolPrecioTextField().setText("");
            }
        });
        
        view.getPacksFutbolModificarButton().setOnAction(eh -> {
            int index = view.getPacksFutbolListView().getSelectionModel().getSelectedIndex();
            PacksFutbolDTO selected = view.getPacksFutbolListView().getSelectionModel().getSelectedItem();
            if(!view.getPacksFutbolNombreTextField().getText().isEmpty() && !view.getPacksFutbolPrecioTextField().getText().isEmpty()) {
                selected.setNombre(view.getPacksFutbolNombreTextField().getText());
                selected.setPrecio(Double.parseDouble(view.getPacksFutbolPrecioTextField().getText()));
            }
            packsFutbolDTOs.set(index, selected);
            view.getPacksFutbolListView().getItems().clear();
            view.getPacksFutbolListView().getItems().addAll(packsFutbolDTOs);
            view.getPacksFutbolNombreTextField().setText("");
            view.getPacksFutbolPrecioTextField().setText("");
        });

        view.getPacksFutbolEliminarButton().setOnAction(eh-> {
            int index = view.getPacksFutbolListView().getSelectionModel().getSelectedIndex();
            packsFutbolDTOs.remove(index);
            view.getPacksFutbolListView().getItems().clear();
            view.getPacksFutbolListView().getItems().addAll(packsFutbolDTOs);
            view.getPacksFutbolNombreTextField().setText("");
            view.getPacksFutbolPrecioTextField().setText("");
        });
        
        view.getCentralitasListView().setCellFactory(param -> new ListCell<CentralitasDTO>() {
            @Override
            public void updateItem(CentralitasDTO item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNombre());
                }
            }
        });

        view.getCentralitasListView().setOnMouseClicked(eh -> {
            CentralitasDTO selected = view.getCentralitasListView().getSelectionModel().getSelectedItem();
            view.getCentralitasNombreTextField().setText(selected.getNombre());
            view.getCentralitasPrecioTextField().setText(Double.toString(selected.getPrecio()));
        });

        view.getCentralitasAgregarButton().setOnAction(eh -> {
            if(!view.getCentralitasNombreTextField().getText().isEmpty()) {
                CentralitasDTO nuevo = new CentralitasDTO();
                nuevo.setNombre(view.getCentralitasNombreTextField().getText());
                nuevo.setPrecio(Double.parseDouble(view.getCentralitasPrecioTextField().getText()));
                centralitasDTOs.add(nuevo);
                view.getCentralitasListView().getItems().clear();
                view.getCentralitasListView().getItems().addAll(centralitasDTOs);
                view.getCentralitasNombreTextField().setText("");
                view.getCentralitasPrecioTextField().setText("");
            }
        });
        
        view.getCentralitasModificarButton().setOnAction(eh -> {
            int index = view.getCentralitasListView().getSelectionModel().getSelectedIndex();
            CentralitasDTO selected = view.getCentralitasListView().getSelectionModel().getSelectedItem();
            if(!view.getCentralitasNombreTextField().getText().isEmpty() && !view.getCentralitasPrecioTextField().getText().isEmpty()) {
                selected.setNombre(view.getCentralitasNombreTextField().getText());
                selected.setPrecio(Double.parseDouble(view.getCentralitasPrecioTextField().getText()));
            }
            centralitasDTOs.set(index, selected);
            view.getCentralitasListView().getItems().clear();
            view.getCentralitasListView().getItems().addAll(centralitasDTOs);
            view.getCentralitasNombreTextField().setText("");
            view.getCentralitasPrecioTextField().setText("");
        });

        view.getCentralitasEliminarButton().setOnAction(eh-> {
            int index = view.getCentralitasListView().getSelectionModel().getSelectedIndex();
            centralitasDTOs.remove(index);
            view.getCentralitasListView().getItems().clear();
            view.getCentralitasListView().getItems().addAll(centralitasDTOs);
            view.getCentralitasNombreTextField().setText("");
            view.getCentralitasPrecioTextField().setText("");
        });

        view.getButtonsHBox().getChildren().addAll(view.getLimpiarButton(), view.getGuardarButton());
        view.getButtonsHBox().getStyleClass().add("menu-bar");
        view.getButtonsHBox().setPrefWidth(Double.MAX_VALUE);
        for(Node node : view.getButtonsHBox().getChildren()){
            if(view.getButtonsHBox().getChildren().indexOf(node) < view.getButtonsHBox().getChildren().size()-1) {
                view.getButtonsHBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }

        view.getDescuentosButtonsBox().getChildren().addAll(view.getDescuentosAgregarButton(), view.getDescuentosModificarButton(), view.getDescuentosEliminarButton());
        view.getDescuentosEliminarButton().getStyleClass().add("cancel-btn");
        for(Node node : view.getDescuentosButtonsBox().getChildren()) {
            view.getDescuentosButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
        }

        view.getCentralitasButtonsBox().getChildren().addAll(view.getCentralitasAgregarButton(), view.getCentralitasModificarButton(), view.getCentralitasEliminarButton());
        view.getCentralitasEliminarButton().getStyleClass().add("cancel-btn");
        for(Node node : view.getCentralitasButtonsBox().getChildren()) {
            view.getCentralitasButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
        }

        view.getStreamingButtonsBox().getChildren().addAll(view.getStreamingAgregarButton(), view.getStreamingModificarButton(), view.getStreamingEliminarButton());
        view.getStreamingEliminarButton().getStyleClass().add("cancel-btn");
        for(Node node : view.getStreamingButtonsBox().getChildren()) {
            view.getStreamingButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
        }

        view.getPacksFutbolButtonsBox().getChildren().addAll(view.getPacksFutbolAgregarButton(), view.getPacksFutbolModificarButton(), view.getPacksFutbolEliminarButton());
        view.getPacksFutbolEliminarButton().getStyleClass().add("cancel-btn");
        for(Node node : view.getPacksFutbolButtonsBox().getChildren()) {
            view.getPacksFutbolButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
        }

        UIUtil.populateVBox(view.getDescuentosVBox(), new ArrayList<>(Arrays.asList(view.getDescuentosVBoxLabel(), view.getDescuentosPorcientoLabel(), view.getDescuentosPorcientoTextField(), view.getDescuentosButtonsBox(), view.getDescuentosListView())));   
        UIUtil.populateVBox(view.getStreamingVBox(), new ArrayList<>(Arrays.asList(view.getStreamingVBoxLabel(), view.getStreamingNombreLabel(), view.getStreamingNombreTextField(), view.getStreamingButtonsBox(), view.getStreamingListView())));
        UIUtil.populateVBox(view.getCentralitasVBox(), new ArrayList<>(Arrays.asList(view.getCentralitasVBoxLabel(), view.getCentralitasNombreLabel(), view.getCentralitasNombreTextField(), view.getCentralitasPrecioLabel(), view.getCentralitasPrecioTextField(), view.getCentralitasButtonsBox(), view.getCentralitasListView())));
        UIUtil.populateVBox(view.getPacksFutbolVBox(), new ArrayList<>(Arrays.asList(view.getPacksFutbolVBoxLabel(), view.getPacksFutbolNombreLabel(), view.getPacksFutbolNombreTextField(), view.getPacksFutbolPrecioLabel(), view.getPacksFutbolPrecioTextField(), view.getPacksFutbolButtonsBox(), view.getPacksFutbolListView())));
    }

    public void limpiarFormulario() {
        view.getDescuentosPorcientoTextField().setText("");
        view.getStreamingNombreTextField().setText("");
        view.getCentralitasNombreTextField().setText("");
        view.getCentralitasPrecioTextField().setText("");
        view.getPacksFutbolNombreTextField().setText("");
        view.getPacksFutbolPrecioTextField().setText("");
    }
}
