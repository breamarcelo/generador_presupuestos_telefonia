package com.budgetsgenerator.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.LineasAdicionalesDTO;
import com.budgetsgenerator.services.impl.LineasAdicionalesService;
import com.budgetsgenerator.views.LineasAdicionalesView;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;

public class LineasAdicionalesController {
    private LineasAdicionalesView view;
    private List<LineasAdicionalesDTO> lineasAdcicionaleList;

    public LineasAdicionalesController(LineasAdicionalesView view) {
        this.view = view;
        load();
    } 

    public void load() {
        lineasAdcicionaleList = LineasAdicionalesService.getInstance().getAll();

        view.getButtonsHBox().getChildren().addAll(view.getLimpiarButton(), view.getGuardarButton());
        view.getButtonsHBox().getStyleClass().add("menu-bar");
        view.getButtonsHBox().setPrefWidth(Double.MAX_VALUE);
        for(Node node : view.getButtonsHBox().getChildren()){
            if(view.getButtonsHBox().getChildren().indexOf(node) < view.getButtonsHBox().getChildren().size()-1) {
                view.getButtonsHBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }

        view.getLimpiarButton().setOnAction(eh -> {
            limpiarFormulario();
        });

        view.getGuardarButton().setOnAction(eh -> {
            LineasAdicionalesService.getInstance().updateAll(lineasAdcicionaleList);

            limpiarFormulario();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("dialog");
            alert.setContentText("Líneas adicionales actualizadas correctamente.");
            alert.setHeaderText("");
            alert.setTitle("Confirmación");
            alert.setGraphic(null);
            alert.getDialogPane().lookupButton(ButtonType.CANCEL).setVisible(false);
            alert.showAndWait();
        });

        view.getListaButtonsBox().getChildren().addAll(view.getAgregarLineaButton(), view.getModificarLineaButton(), view.getEliminarLineaButton());
        view.getEliminarLineaButton().getStyleClass().add("cancel-btn");
        for(Node node : view.getListaButtonsBox().getChildren()) {
            view.getListaButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
        }

        view.getAgregarLineaButton().setOnAction(eh -> {
            LineasAdicionalesDTO nuevo = new LineasAdicionalesDTO();
            nuevo.setNombre(view.getFormularioNombreTextField().getText() != null ? view.getFormularioNombreTextField().getText() : null);
            nuevo.setTipo(view.getFormularioTipoTextField().getText() != null ? view.getFormularioTipoTextField().getText() : null);
            nuevo.setNumLineas(view.getFormularioNumLineasTextField().getText() != null ? Integer.parseInt(view.getFormularioNumLineasTextField().getText()) : 1);
            nuevo.setLlamadas(view.getFormularioLlamadasTextField().getText() != null ? view.getFormularioLlamadasTextField().getText() : null);
            nuevo.setGb(view.getFormularioGbTextField().getText() != null ? view.getFormularioGbTextField().getText() : null);
            nuevo.setFibra(view.getFormularioFibraTextField().getText() != null ? view.getFormularioFibraTextField().getText() : null);
            nuevo.setPrecio(view.getFormularioPrecioTextField().getText() != null ? Double.parseDouble(view.getFormularioPrecioTextField().getText()) : 0.00);
            
            lineasAdcicionaleList.add(nuevo);
            view.getListaView().getItems().clear();
            view.getListaView().getItems().addAll(lineasAdcicionaleList);
            limpiarFormulario();
        });
        
        view.getModificarLineaButton().setOnAction(eh -> {
            int index = lineasAdcicionaleList.indexOf(view.getListaView().getSelectionModel().getSelectedItem());
            LineasAdicionalesDTO selected = view.getListaView().getSelectionModel().getSelectedItem();
            selected.setNombre(view.getFormularioNombreTextField().getText() != null ? view.getFormularioNombreTextField().getText() : null);
            selected.setTipo(view.getFormularioTipoTextField().getText() != null ? view.getFormularioTipoTextField().getText() : null);
            selected.setNumLineas(view.getFormularioNumLineasTextField().getText() != null ? Integer.parseInt(view.getFormularioNumLineasTextField().getText()) : null);
            selected.setLlamadas(view.getFormularioLlamadasTextField().getText() != null ? view.getFormularioLlamadasTextField().getText() : null);
            selected.setGb(view.getFormularioGbTextField().getText() != null ? view.getFormularioGbTextField().getText() : null);
            selected.setFibra(view.getFormularioFibraTextField().getText() != null ? view.getFormularioFibraTextField().getText() : null);
            selected.setPrecio(view.getFormularioPrecioTextField().getText() != null ? Double.parseDouble(view.getFormularioPrecioTextField().getText()) : 0.00);
            lineasAdcicionaleList.set(index, selected);
            view.getListaView().getItems().clear();
            view.getListaView().getItems().addAll(lineasAdcicionaleList);
            limpiarFormulario();
        });

        view.getEliminarLineaButton().setOnAction(eh -> {
            lineasAdcicionaleList.remove(lineasAdcicionaleList.indexOf(view.getListaView().getSelectionModel().getSelectedItem()));
            view.getListaView().getItems().clear();
            view.getListaView().getItems().addAll(lineasAdcicionaleList);
            limpiarFormulario();
        });

        UIUtil.populateVBox(view.getFormularioVBox(), new ArrayList<>(Arrays.asList(view.getFormularioLabel(), view.getFormularioNombreLabel(), view.getFormularioNombreTextField(), view.getFormularioTipoLabel(), view.getFormularioTipoTextField(), view.getFormularioNumLineasLabel(), view.getFormularioNumLineasTextField(), view.getFormularioLlamadasLabel(), view.getFormularioLlamadasTextField(), view.getFormularioGbLabel(), view.getFormularioGbTextField(), view.getFormularioFibraLabel(), view.getFormularioFibraTextField(), view.getFormularioPrecioLabel(), view.getFormularioPrecioTextField(), view.getListaButtonsBox(), view.getListaView())));
    
        view.getListaView().getItems().addAll(lineasAdcicionaleList);

        view.getListaView().setCellFactory(param -> new ListCell<LineasAdicionalesDTO>() {
            @Override
            public void updateItem(LineasAdicionalesDTO item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNombre());
                }
            }
        });

        view.getListaView().setOnMouseClicked(eh -> {
            LineasAdicionalesDTO selected = view.getListaView().getSelectionModel().getSelectedItem();
            view.getFormularioNombreTextField().setText(selected.getNombre());
            view.getFormularioTipoTextField().setText(selected.getTipo());
            view.getFormularioNumLineasTextField().setText(Integer.toString(selected.getNumLineas()));
            view.getFormularioLlamadasTextField().setText(selected.getLlamadas());
            view.getFormularioGbTextField().setText(selected.getGb());
            view.getFormularioFibraTextField().setText(selected.getFibra());
            view.getFormularioPrecioTextField().setText(Double.toString(selected.getPrecio()));
        });
    }

    public void limpiarFormulario() {
        view.getFormularioNombreTextField().setText("");
        view.getFormularioTipoTextField().setText("");
        view.getFormularioNumLineasTextField().setText("");
        view.getFormularioLlamadasTextField().setText("");
        view.getFormularioGbTextField().setText("");
        view.getFormularioFibraTextField().setText("");
        view.getFormularioPrecioTextField().setText("");
        view.getListaView().getSelectionModel().clearSelection();
    }
}
