package com.budgetsgenerator.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.dto.ServiciosAdicionalesDTO;
import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.services.impl.TarifasService;
import com.budgetsgenerator.views.TarifasView;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class TarifasController {
    public TarifasView view;
    public int counter = 0;
    public TarifasDTO tarifas;
    public List<FibrasDTO> fibrasList;
    public ServiciosAdicionalesDTO serviciosAdicionales;

    public TarifasController(TarifasView view) {
        this.view = view;
        load();
    }
    
    public void load() {
        tarifas = new TarifasDTO();
        fibrasList = new ArrayList<>();
        serviciosAdicionales = new ServiciosAdicionalesDTO();

        view.getButtonsBox().getChildren().addAll(view.getNuevoButton(), view.getAbrirButton(), view.getActualizarButton(), view.getGuardarButton());
        view.getButtonsBox().getStyleClass().add("menu-bar");
        view.getButtonsBox().setPrefWidth(Double.MAX_VALUE);
        for(Node node : view.getButtonsBox().getChildren()){
            if(view.getButtonsBox().getChildren().indexOf(node) < view.getButtonsBox().getChildren().size()-1) {
                view.getButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }

        view.getNuevoButton().setOnAction(eh -> {
            tarifas = new TarifasDTO();
            limpiarFormulario();
        });

        view.getAbrirButton().setOnAction(eh -> {
            TextInputDialog dialog = new TextInputDialog();
            
            dialog.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
            dialog.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
            dialog.getDialogPane().getStyleClass().add("dialog");
            dialog.setTitle("Abrir presupuesto");
            dialog.setGraphic(null);
            dialog.setHeaderText("Seleccione un presupuesto:");

            Button cancelButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setText("Cancelar");
            cancelButton.getStyleClass().add("cancel-btn");

            Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setText("Abrir");
            
            TextField node = (TextField) dialog.getDialogPane().lookup("TextField");
            node.setVisible(false);

            ListView<TarifasDTO> tarifasListView = new ListView<>();
            tarifasListView.getItems().setAll(TarifasService.getInstance().getAll());
            
            tarifasListView.setCellFactory(param -> new ListCell<TarifasDTO>() {
                @Override
                protected void updateItem(TarifasDTO item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNombre());
                    }
                }
            });

            dialog.getDialogPane().setContent(tarifasListView);

            okButton.addEventFilter(ActionEvent.ACTION, e -> {
                TarifasDTO selected = tarifasListView.getSelectionModel().getSelectedItem();
                if(selected != null) {  
                    loadTarifaDTO(selected);
                    dialog.close();
                }
                eh.consume();
            });

            dialog.showAndWait();
        });

        view.getActualizarButton().setOnAction(eh -> {
            tarifas.setNombre(view.getTarifaNombreTextField().getText() != "" ? view.getTarifaNombreTextField().getText() : null);
            tarifas.setTipo(view.getTarifaTipoTextField().getText() != "" ? view.getTarifaTipoTextField().getText() : null);
            tarifas.setPrecio(view.getTarifaPrecioTextField().getText() != "" ? Double.parseDouble(view.getTarifaPrecioTextField().getText()) : 0.00);
            tarifas.setTv(view.getTarifaTvCheckBox().isSelected());
            tarifas.setStreaming(view.getTarifaStreamingCheckBox().isSelected());
            tarifas.setFibras(fibrasList);
            tarifas.setLineasMoviles(view.getLineasNumField().getText() != "" ? Integer.parseInt(view.getLineasNumField().getText()) : 0);
            tarifas.setLlamadasMovil(view.getLineasLlamadasField().getText() != "" ? view.getLineasLlamadasField().getText() : null);
            tarifas.setGbMovil(view.getLineasGbField().getText() != "" ? view.getLineasGbField().getText() : null);
            tarifas.setPrecio(view.getTarifaPrecioTextField().getText() != "" ? Double.parseDouble(view.getTarifaPrecioTextField().getText()) : 0.00);

            serviciosAdicionales.setRoaming(view.getServiciosRoamingTextField().getText() != null ? view.getServiciosRoamingTextField().getText() : null);
            serviciosAdicionales.setInternacional(view.getServiciosInternacionalTextField().getText() != null ? view.getServiciosInternacionalTextField().getText() : null);
            serviciosAdicionales.setLegalitas(view.getServiciosLegalitasBox().isSelected());
            serviciosAdicionales.setCloud(view.getServiciosCloudBox().isSelected());
            serviciosAdicionales.setCiberProteccion(view.getServiciosCiberProteccionBox().isSelected());
            serviciosAdicionales.setAtencionPersonalizada(view.getServiciosAtencionPersonalizadaBox().isSelected());
            serviciosAdicionales.setCentralita(view.getServiciosCentralitaTextField().getText() != null ? view.getServiciosCentralitaTextField().getText() : null);
            serviciosAdicionales.setNumBeneficios(view.getServiciosNumBeneficiosTextField().getText() != "" ? Integer.parseInt(view.getServiciosNumBeneficiosTextField().getText()) : 0);
            serviciosAdicionales.setDescuentoBeneficios(view.getServiciosDescuentoBeneficiosTextField().getText() != "" ? view.getServiciosDescuentoBeneficiosTextField().getText() : null);
            tarifas.setServiciosAdicionales(serviciosAdicionales);
            TarifasService.getInstance().updateTarifa(tarifas, fibrasList);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("dialog");
            alert.setContentText("Tarifa actualizada correctamente.");
            alert.setHeaderText("");
            alert.setTitle("Confirmación");
            alert.setGraphic(null);
            alert.getDialogPane().lookupButton(ButtonType.CANCEL).setVisible(false);
            alert.showAndWait();
        });

        view.getGuardarButton().setOnAction(eh -> {
            serviciosAdicionales.setRoaming(view.getServiciosRoamingTextField().getText() != "" ? view.getServiciosRoamingTextField().getText() : null);
            serviciosAdicionales.setInternacional(view.getServiciosInternacionalTextField().getText() != "" ? view.getServiciosInternacionalTextField().getText() : null);
            serviciosAdicionales.setLegalitas(view.getServiciosLegalitasBox().isSelected());
            serviciosAdicionales.setCloud(view.getServiciosCloudBox().isSelected());
            serviciosAdicionales.setCiberProteccion(view.getServiciosCiberProteccionBox().isSelected());
            serviciosAdicionales.setAtencionPersonalizada(view.getServiciosAtencionPersonalizadaBox().isSelected());
            serviciosAdicionales.setCentralita(view.getServiciosCentralitaTextField().getText() != "" ? view.getServiciosCentralitaTextField().getText() : null);
            serviciosAdicionales.setNumBeneficios(view.getServiciosNumBeneficiosTextField().getText() != "" ? Integer.parseInt(view.getServiciosNumBeneficiosTextField().getText()) : 0);
            serviciosAdicionales.setDescuentoBeneficios(view.getServiciosDescuentoBeneficiosTextField().getText() != "" ? view.getServiciosDescuentoBeneficiosTextField().getText() : null);

            tarifas.setNombre(view.getTarifaNombreTextField().getText() != "" ? view.getTarifaNombreTextField().getText() : null);
            tarifas.setTipo(view.getTarifaTipoTextField().getText() != "" ? view.getTarifaTipoTextField().getText() : null);
            tarifas.setPrecio(view.getTarifaPrecioTextField().getText() != "" ? Double.parseDouble(view.getTarifaPrecioTextField().getText()) :  0.00);
            tarifas.setTv(view.getTarifaTvCheckBox().isSelected());
            tarifas.setStreaming(view.getTarifaStreamingCheckBox().isSelected());
            tarifas.setFibras(fibrasList);
            tarifas.setLineasMoviles(view.getLineasNumField().getText() != "" ? Integer.parseInt(view.getLineasNumField().getText()) : 0);
            tarifas.setLlamadasMovil(view.getLineasLlamadasField().getText() != "" ? view.getLineasLlamadasField().getText(): null);
            tarifas.setGbMovil(view.getLineasGbField().getText() != "" ? view.getLineasGbField().getText() : null);
            tarifas.setServiciosAdicionales(serviciosAdicionales);
            TarifasService.getInstance().saveTarifa(serviciosAdicionales, tarifas, fibrasList, null);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("dialog");
            alert.setContentText("Tarifa guardada correctamente.");
            alert.setHeaderText("");
            alert.setTitle("Confirmación");
            alert.setGraphic(null);
            alert.getDialogPane().lookupButton(ButtonType.CANCEL).setVisible(false);
            alert.showAndWait();

            limpiarFormulario();
        });

        view.getCheckboxesBox().getChildren().addAll(view.getTarifaTvLabel(), view.getTarifaTvCheckBox(), view.getTarifaStreamingLabel(), view.getTarifaStreamingCheckBox());
        for(Node node : view.getCheckboxesBox().getChildren()) {
            if(node instanceof Label) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 10, 0, 0));
            }
            if(node instanceof CheckBox) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }
        
        view.getServiciosCheckboxes1Box().getChildren().addAll(view.getServiciosLegalitasLabel(), view.getServiciosLegalitasBox(), view.getServiciosCloudLabel(), view.getServiciosCloudBox());
        view.getServiciosCheckboxes2Box().getChildren().addAll(view.getServiciosCiberProteccionLabel(), view.getServiciosCiberProteccionBox(), view.getServiciosAtencionPersonalizadaLabel(), view.getServiciosAtencionPersonalizadaBox());
        
        for(Node node : view.getServiciosCheckboxes1Box().getChildren()) {
            if(node instanceof Label) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 10, 0, 0));
            }
            if(node instanceof CheckBox) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }
        
        for(Node node : view.getServiciosCheckboxes2Box().getChildren()) {
            if(node instanceof Label) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 10, 0, 0));
            }
            if(node instanceof CheckBox) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }

        view.getFibrasListView().setCellFactory(param -> new ListCell<FibrasDTO>() {
            @Override
            public void updateItem(FibrasDTO item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNombre() + (item.getSobrecargo() > 0.00 ? " (+" + item.getSobrecargo() + "€)" : ""));
                }
            }
        });

        view.getFibrasListView().setOnMouseClicked(eh-> {
            FibrasDTO selected = view.getFibrasListView().getSelectionModel().getSelectedItem();
            view.getFibraNombreTextField().setText(selected.getNombre()); 
            view.getFibraSobrecargoTextField().setText(Double.toString(selected.getSobrecargo()));
        });

        view.getBotonesFibrasHBox().getChildren().addAll(view.getAgregarFibraButton(), view.getModificarFibraButton(), view.getEliminarFibraButton());
        view.getEliminarFibraButton().getStyleClass().add("cancel-btn");
        for(Node node : view.getBotonesFibrasHBox().getChildren()) {
            view.getBotonesFibrasHBox().setMargin(node, new Insets(0, 20, 0, 0));
        }

        view.getAgregarFibraButton().setOnAction(eh -> {
            FibrasDTO nuevoFibra = new FibrasDTO();
            nuevoFibra.setNombre(view.getFibraNombreTextField().getText()); 
            nuevoFibra.setSobrecargo(Double.parseDouble(view.getFibraSobrecargoTextField().getText()));
            fibrasList.add(nuevoFibra); 
            view.getFibrasListView().getItems().clear();
            view.getFibrasListView().getItems().addAll(fibrasList);
            view.getFibraNombreTextField().setText("");
            view.getFibraSobrecargoTextField().setText("");
        });

        view.getModificarFibraButton().setOnAction(eh -> {
            int index = fibrasList.indexOf(view.getFibrasListView().getSelectionModel().getSelectedItem());
            FibrasDTO selection = view.getFibrasListView().getSelectionModel().getSelectedItem();
            selection.setNombre(view.getFibraNombreTextField().getText());
            selection.setSobrecargo(Double.parseDouble(view.getFibraSobrecargoTextField().getText()));
            fibrasList.set(index, selection);
            view.getFibrasListView().getItems().clear();
            view.getFibrasListView().getItems().addAll(fibrasList);
        });

        view.getEliminarFibraButton().setOnAction(eh -> {
            fibrasList.remove(fibrasList.indexOf(view.getFibrasListView().getSelectionModel().getSelectedItem()));
            view.getFibrasListView().getItems().clear();
            view.getFibrasListView().getItems().addAll(fibrasList);
        });
        
        UIUtil.populateVBox(view.getTarifasBox(), new ArrayList<>(Arrays.asList(view.getTarifasBoxLabel(), view.getTarifaNombreLabel(), view.getTarifaNombreTextField(), view.getTarifaTipoLabel(), view.getTarifaTipoTextField(), view.getTarifaPrecioLabel(), view.getTarifaPrecioTextField(), view.getCheckboxesBox())));
        UIUtil.populateVBox(view.getFibrasBox(), new ArrayList<>(Arrays.asList(view.getFibrasBoxLabel(), view.getFibraNombreLabel(), view.getFibraNombreTextField(), view.getFibraSobrecargoLabel(), view.getFibraSobrecargoTextField(), view.getBotonesFibrasHBox(), view.getFibrasListView())));
        UIUtil.populateVBox(view.getLineasBox(), new ArrayList<>(Arrays.asList(view.getLineasBoxLabel(), view.getLineasNumLabel(), view.getLineasNumField(), view.getLineasLlamadasabel(), view.getLineasLlamadasField(), view.getLineasGbLabel(), view.getLineasGbField())));
        UIUtil.populateVBox(view.getServiciosBox(), new ArrayList<>(Arrays.asList(view.getServiciosBoxLabel(), view.getServiciosRoamingLabel(), view.getServiciosRoamingTextField(), view.getServiciosInternacionalLabel(), view.getServiciosInternacionalTextField(), view.getServiciosCheckboxes1Box(), view.getServiciosCheckboxes2Box(), view.getServiciosCentralitaLabel(), view.getServiciosCentralitaTextField(), view.getServiciosNumBeneficiosLabel(), view.getServiciosNumBeneficiosTextField(), view.getServiciosDescuentoBeneficiosLabel(), view.getServiciosDescuentoBeneficiosTextField())));
    }

    public void limpiarFormulario() {
        view.getTarifaNombreTextField().setText("");
        view.getTarifaTipoTextField().setText("");
        view.getTarifaPrecioTextField().setText("");
        view.getTarifaTvCheckBox().setSelected(false);
        view.getTarifaStreamingCheckBox().setSelected(false);
        view.getFibraNombreTextField().setText("");
        view.getFibraSobrecargoTextField().setText("");
        fibrasList.clear();
        view.getFibrasListView().getItems().clear();
        view.getLineasNumField().setText("");
        view.getLineasLlamadasField().setText("");
        view.getLineasGbField().setText("");
        view.getServiciosRoamingTextField().setText(""); 
        view.getServiciosInternacionalTextField().setText("");
        view.getServiciosCentralitaTextField().setText(""); 
        view.getServiciosNumBeneficiosTextField().setText(""); 
        view.getServiciosDescuentoBeneficiosTextField().setText("");
        view.getServiciosLegalitasBox().setSelected(false); 
        view.getServiciosCloudBox().setSelected(false);
        view.getServiciosCiberProteccionBox().setSelected(false); 
        view.getServiciosAtencionPersonalizadaBox().setSelected(false);
    }

    public void loadTarifaDTO(TarifasDTO selected) {
        tarifas = selected;
        serviciosAdicionales = selected.getServiciosAdicionales();
        view.getTarifaNombreTextField().setText(selected.getNombre());
        view.getTarifaTipoTextField().setText(selected.getTipo());
        view.getTarifaPrecioTextField().setText(Double.toString(selected.getPrecio()));
        view.getTarifaTvCheckBox().setSelected(selected.isTv());
        view.getTarifaStreamingCheckBox().setSelected(selected.isStreaming());
        view.getFibraNombreTextField().setText("");
        view.getFibraSobrecargoTextField().setText("");
        fibrasList.clear();
        fibrasList.addAll(selected.getFibras());
        view.getFibrasListView().getItems().clear();
        view.getFibrasListView().getItems().addAll(fibrasList);
        view.getLineasNumField().setText(Integer.toString(selected.getLineasMoviles()));
        view.getLineasLlamadasField().setText(selected.getLlamadasMovil());
        view.getLineasGbField().setText(selected.getGbMovil());
        view.getServiciosRoamingTextField().setText(selected.getServiciosAdicionales().getRoaming()); 
        view.getServiciosInternacionalTextField().setText(selected.getServiciosAdicionales().getInternacional());
        view.getServiciosCentralitaTextField().setText(selected.getServiciosAdicionales().getCentralita()); 
        view.getServiciosNumBeneficiosTextField().setText(Integer.toString(selected.getServiciosAdicionales().getNumBeneficios())); 
        view.getServiciosDescuentoBeneficiosTextField().setText(selected.getServiciosAdicionales().getDescuentoBeneficios());
        view.getServiciosLegalitasBox().setSelected(selected.getServiciosAdicionales().isLegalitas()); 
        view.getServiciosCloudBox().setSelected(selected.getServiciosAdicionales().isCloud());
        view.getServiciosCiberProteccionBox().setSelected(selected.getServiciosAdicionales().isCiberProteccion()); 
        view.getServiciosAtencionPersonalizadaBox().setSelected(selected.getServiciosAdicionales().isAtencionPersonalizada());
    }
}
