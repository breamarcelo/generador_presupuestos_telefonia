package com.budgetsgenerator.controllers;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.dto.LineasAdicionalesDTO;
import com.budgetsgenerator.dto.LineasPresupuestoDTO;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.dto.PresupuestosDTO;
import com.budgetsgenerator.dto.ServiciosAdicionalesDTO;
import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.services.impl.CentralitasService;
import com.budgetsgenerator.services.impl.DescuentosService;
import com.budgetsgenerator.services.impl.LineasAdicionalesService;
import com.budgetsgenerator.services.impl.PacksFutbolService;
import com.budgetsgenerator.services.impl.PresupuestosService;
import com.budgetsgenerator.services.impl.StreamingService;
import com.budgetsgenerator.services.impl.TarifasService;
import com.budgetsgenerator.viewmodels.ResumentTableItem;
import com.budgetsgenerator.views.PresupuestosView;
import com.budgetsgenerator.xml.XmlService;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class PresupuestosController {
    private PresupuestosView view;
    private List<LineasPresupuestoDTO> lineasPresupuestoList;
    private double total;
    private PresupuestosDTO presupuesto;
    private List<LineasAdicionalesDTO> lineasAdicionalesList;
    private List<TarifasDTO> tarifasList;
    private List<DescuentosDTO> descuentosList;
    private List<CentralitasDTO> centralitasList;
    private List<PacksFutbolDTO> packsFutbolList;
    private List<StreamingDTO> streamingList;
    private List<PresupuestosDTO> presupuestosList;

    public PresupuestosController(PresupuestosView view) {
        this.view = view;
        loadData();
    }
    
    public void loadData(){
        lineasPresupuestoList  = new ArrayList<>();
        presupuesto = new PresupuestosDTO();
        Region espacio = new Region();

        view.getButtonsHBox().getChildren().addAll(view.getNuevoButton(), view.getLoadButton(), view.getActualizarButton(), view.getSaveButton(), espacio, view.getPresupuestoField(), view.getGenerarPdfButton());
        view.getGenerarPdfButton().getStyleClass().add("action-btn");
        view.getButtonsHBox().setHgrow(espacio, Priority.ALWAYS);
        view.getButtonsHBox().getStyleClass().add("menu-bar");
        view.getButtonsHBox().setPrefWidth(Double.MAX_VALUE);
        view.getPresupuestoField().setEditable(false);
        for(Node node : view.getButtonsHBox().getChildren()){
            if(view.getButtonsHBox().getChildren().indexOf(node) < view.getButtonsHBox().getChildren().size()-1) {
                view.getButtonsHBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }

        lineasAdicionalesList = LineasAdicionalesService.getInstance().getAll();
        tarifasList = TarifasService.getInstance().getAll();
        descuentosList = DescuentosService.getInstance().getAll();
        centralitasList = CentralitasService.getInstance().getAll();
        packsFutbolList = PacksFutbolService.getInstance().getAll();
        streamingList = StreamingService.getInstance().getAll();
        presupuestosList = PresupuestosService.getInstance().getAll();

        view.getTarifasCombo().getItems().setAll(tarifasList);
        view.getDescuentoCombo().getItems().setAll(descuentosList);
        view.getDescuentoCombo().setDisable(true);
        view.getCentralitaCombo().getItems().setAll(centralitasList);
        view.getPacksFutbolCombo().getItems().setAll(packsFutbolList);
        view.getStreamingCombo().setDisable(true);
        view.getStreamingCombo().getItems().setAll(streamingList);
        
        view.getTarifasCombo().setConverter(UIUtil.createConverter(dto -> dto.getNombre()));
        view.getDescuentoCombo().setConverter(UIUtil.createConverter(dto -> dto.getPorciento() + "%"));
        view.getCentralitaCombo().setConverter(UIUtil.createConverter(dto -> dto.getNombre()));
        view.getFibraCombo().setConverter(UIUtil.createConverter(dto -> dto.getNombre()));
        view.getPacksFutbolCombo().setConverter(UIUtil.createConverter(dto -> dto.getNombre()));
        view.getStreamingCombo().setConverter(UIUtil.createConverter(dto -> dto.getNombre()));
        
        view.getTarifasCombo().setOnAction(e -> {
            presupuesto.setTarifa(view.getTarifasCombo().getValue());
            view.getFibraCombo().getItems().clear();
            view.getFibraCombo().getItems().setAll(view.getTarifasCombo().getValue().getFibras());
            view.getStreamingCombo().setDisable(!view.getTarifasCombo().getValue().isStreaming());
            view.getStreamingCombo().valueProperty().set(null);
            view.getDescuentoCombo().setDisable(view.getTarifasCombo().getValue() == null);
            view.getDescuentoCombo().valueProperty().set(null);
            updateResumenTable();
        });

        view.getFibraCombo().setOnAction(e -> {
            presupuesto.setFibra(view.getFibraCombo().getValue());
            updateResumenTable();

        });
        view.getStreamingCombo().setOnAction(e -> {
            presupuesto.setStreaming(view.getStreamingCombo().getValue());
            updateResumenTable();
        });
        view.getCentralitaCombo().setOnAction(e -> {
            presupuesto.setCentralita(view.getCentralitaCombo().getValue());
            updateResumenTable();
        });
        view.getPacksFutbolCombo().setOnAction(e -> {
            presupuesto.setPackFutbol(view.getPacksFutbolCombo().getValue());
            updateResumenTable();
        });
        view.getDescuentoCombo().setOnAction(e -> {
            presupuesto.setDescuento(view.getDescuentoCombo().getValue());
            updateResumenTable();
        });
        
        view.getTotalHBox().getChildren().addAll(view.getTotalLabel(), view.getTotalField());
        view.getTotalHBox().setAlignment(Pos.CENTER_RIGHT);
        view.getTotalHBox().setMargin(view.getTotalLabel(), new Insets(0, 10, 0, 0));
        view.getTotalField().setEditable(false);

        UIUtil.populateVBox(view.getTarifasVBox(), new ArrayList<>(Arrays.asList(view.getTarifasVBoxLabel(), view.getTarifaLabel(), view.getTarifasCombo(), view.getFibraLabel(), view.getFibraCombo(), view.getStreamingLabel(), view.getStreamingCombo())));
        UIUtil.populateVBox(view.getProductosAdicionalesVBox(), new ArrayList<>(Arrays.asList(view.getProductosAdicioanelesVBoxLabel(), view.getCentralitaLabel(), view.getCentralitaCombo(), view.getPackFutbolLabel(), view.getPacksFutbolCombo())));
        UIUtil.populateVBox(view.getLineasAdicionalesVBox(), new ArrayList<>(Arrays.asList(view.getLineasAdicionalesVBoxLabel(), view.getLineasAdicionalesView())));
        UIUtil.populateVBox(view.getDescuentosVBox(), new ArrayList<>(Arrays.asList(view.getDescuentoLabel(), view.getDescuentoCombo())));
        UIUtil.populateVBox(view.getResumenVBox(), new ArrayList<>(Arrays.asList(view.getResumenVBoxLabel(), view.getResumenView(), view.getTotalHBox())));

        TableColumn<ResumentTableItem, Integer> cantidadTableColumn = new TableColumn<>("Cantidad");
        TableColumn<ResumentTableItem, ListView<String>> descripcionTableColumn = new TableColumn<>("Descripción");
        TableColumn<ResumentTableItem, Double> precioTableColumn = new TableColumn<>("Importe");

        cantidadTableColumn.setCellValueFactory(new PropertyValueFactory<ResumentTableItem, Integer>("cantidad"));
        descripcionTableColumn.setCellValueFactory(new PropertyValueFactory<ResumentTableItem, ListView<String>>("descripcion"));
        precioTableColumn.setCellValueFactory(new PropertyValueFactory<ResumentTableItem, Double>("importe"));

        cantidadTableColumn.setMinWidth(60);
        cantidadTableColumn.setMaxWidth(60);
        
        precioTableColumn.setMinWidth(80);
        precioTableColumn.setMaxWidth(80);

        descripcionTableColumn.setMaxWidth(Double.MAX_VALUE);
        descripcionTableColumn.resizableProperty().set(true);
        
        view.getResumenView().getColumns().clear();
        view.getResumenView().getColumns().addAll(cantidadTableColumn, descripcionTableColumn, precioTableColumn); 
        view.getResumenVBox().setVgrow(view.getResumenView(), Priority.ALWAYS);
        view.getResumenView().setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        view.getActualizarButton().setDisable(view.getPresupuestoField().getText().isEmpty());
        view.getSaveButton().setDisable(!view.getPresupuestoField().getText().isEmpty());

        view.getGenerarPdfButton().setOnAction(e -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File directory = directoryChooser.showDialog(new Stage());
            if(!directory.toString().isEmpty()) {
                String filePath = directory.toString() + "/" +view.getPresupuestoField().getText() + "_" + LocalDate.now() + ".pdf";
                XmlService.getInstance().createPdf(view.getResumenView().getItems(), view.getTotalFieldText(), filePath);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
                alert.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
                alert.getDialogPane().getStyleClass().add("dialog");
                alert.setContentText("PDF generado correctamente.");
                alert.setHeaderText("");
                alert.setTitle("Confirmación");
                alert.setGraphic(null);
                alert.getDialogPane().lookupButton(ButtonType.CANCEL).setVisible(false);
                alert.showAndWait();
            }
        });

        view.getNuevoButton().setOnAction(e -> {            
            presupuesto = new PresupuestosDTO();
            limpiarFormulario();
        });

        view.getLoadButton().setOnAction(e -> {
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

            ListView<PresupuestosDTO> presupuestoListView = new ListView<>();
            presupuestoListView.getItems().setAll(presupuestosList);
            
            presupuestoListView.setCellFactory(param -> new ListCell<PresupuestosDTO>() {
                @Override
                protected void updateItem(PresupuestosDTO item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNombre());
                    }
                }
            });

            dialog.getDialogPane().setContent(presupuestoListView);

            okButton.addEventFilter(ActionEvent.ACTION, eh -> {
                PresupuestosDTO selected = presupuestoListView.getSelectionModel().getSelectedItem();
                if(selected != null) {  
                    loadPresupuestoDTO(selected);
                    dialog.close();
                }
                eh.consume();
            });

            dialog.showAndWait();
        });

        view.getActualizarButton().setOnAction(e -> {
            PresupuestosDTO actualizado = new PresupuestosDTO();
            actualizado = PresupuestosService.getInstance().updatePresupuesto(presupuesto, lineasPresupuestoList);
            limpiarFormulario();
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("dialog");
            alert.setContentText("Presupuesto actualizado correctamente.");
            alert.setHeaderText("");
            alert.setTitle("Confirmación");
            alert.setGraphic(null);
            alert.getDialogPane().lookupButton(ButtonType.CANCEL).setVisible(false);
            alert.showAndWait();
            
            loadPresupuestoDTO(actualizado);
        });

        view.getSaveButton().setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();

            dialog.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
            dialog.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
            dialog.getDialogPane().getStyleClass().add("dialog");
            dialog.setTitle("Guardar presupuesto");
            dialog.setGraphic(null);
            dialog.setHeaderText("Nombre del presupuesto:");
            
            Button cancelButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setText("Cancelar");
            cancelButton.getStyleClass().add("cancel-btn");

            Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setText("Guardar");
            okButton.addEventFilter(ActionEvent.ACTION, eh -> {
                if(!dialog.getEditor().getText().isEmpty()) {
                    PresupuestosDTO nuevoPresupuesto = new PresupuestosDTO();
                    List<LineasPresupuestoDTO> nuevaListaLineas = new ArrayList<>();
                    nuevaListaLineas.addAll(lineasPresupuestoList);
                    nuevoPresupuesto.setId(null);
                    nuevoPresupuesto.setNombre(dialog.getEditor().getText());
                    nuevoPresupuesto.setTarifa(view.getTarifasCombo().getValue());
                    nuevoPresupuesto.setFibra(view.getFibraCombo().getValue());
                    nuevoPresupuesto.setStreaming(view.getStreamingCombo().getValue());
                    nuevoPresupuesto.setCentralita(view.getCentralitaCombo().getValue());
                    nuevoPresupuesto.setPackFutbol(view.getPacksFutbolCombo().getValue());
                    nuevoPresupuesto.setDescuento(view.getDescuentoCombo().getValue());
                    nuevoPresupuesto.setLineasAdicionales(nuevaListaLineas);
                    
                    PresupuestosDTO savedPresupuesto = PresupuestosService.getInstance().savePresupuesto(nuevoPresupuesto, nuevaListaLineas);
                    
                    dialog.close();
                    limpiarFormulario();
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
                    alert.getDialogPane().getStyleClass().add("dialog");
                    alert.setContentText("Presupuesto guardado correctamente.");
                    alert.setHeaderText("");
                    alert.setTitle("Confirmación");
                    alert.setGraphic(null);
                    alert.getDialogPane().lookupButton(ButtonType.CANCEL).setVisible(false);
                    alert.showAndWait();
                    
                    presupuestosList = PresupuestosService.getInstance().getAll();
                    for(PresupuestosDTO dto : presupuestosList) {
                        if(dto.getId() == savedPresupuesto.getId()){
                            lineasPresupuestoList = dto.getLineasAdicionales();
                            loadPresupuestoDTO(dto);
                        }
                    }
                }
                dialog.getEditor().getStyleClass().add("empty-field");
                dialog.getEditor().setPromptText("* Este campo no puede estar vacío");
                eh.consume();
            });
            dialog.showAndWait();
        });

        loadLineasAdicionalesView();
        view.getLineasAdicionalesView().setPadding(Insets.EMPTY);
    }

    private void updateResumenTable() {
        total = 0.0;
        view.getResumenView().getItems().clear();
        
        if(view.getTarifasCombo().getValue() != null) {
            updateTarifaRow();
        }

        if(view.getDescuentoCombo().getValue() != null) {
            updateDescuentoRow();
        }

        if(view.getCentralitaCombo().getValue() != null){
            updateCentralitaRow();
        }

        if(view.getPacksFutbolCombo().getValue() != null) {
            updatePackFutbolRow();
        }

        if(lineasPresupuestoList != null) {
            for(LineasPresupuestoDTO linea : lineasPresupuestoList) {    
                ResumentTableItem row = new ResumentTableItem();
                ListView<String> descripcion = new ListView<>();
                descripcion.setPrefHeight(10);
                descripcion.getItems().add(linea.getLineasAdicional().getNombre());
                
                double importe = (double) linea.getLineasAdicional().getPrecio() * linea.getCantidad();
                row.setCantidad(linea.getCantidad());
                row.setDescripcion(descripcion);
                row.setImporte(importe);
                total += importe;
                view.getResumenView().getItems().add(row);
            }
        }

        if(view.getTarifasCombo().getValue() != null) {
            updateServiciosAdicionalesRow();
        }
        
        view.getResumenView().refresh();
        view.getTotalField().setText(String.valueOf(total));
    }

    private void updateTarifaRow(){
        ResumentTableItem row = new ResumentTableItem();
        TarifasDTO tarifasDTO = view.getTarifasCombo().getValue();
        FibrasDTO fibrasDTO = view.getFibraCombo().getValue();
        StreamingDTO streamingDTO = view.getStreamingCombo().getValue();

        double importe = tarifasDTO.getPrecio();
        ListView<String> descripcionList = new ListView<>();
        descripcionList.setPrefHeight(87);
        
        descripcionList.getItems().add("Tarifa " + tarifasDTO.getNombre());
        descripcionList.getItems().add(tarifasDTO.getLineasMoviles() + (tarifasDTO.getLineasMoviles() > 1 ? " líneas móviles " : " línea móvil ") + 
        " con " + (tarifasDTO.getLlamadasMovil().toLowerCase().contains("ilimitadas") ? "llamadas ilimitadas " : tarifasDTO.getLlamadasMovil()) + 
        "y " + (tarifasDTO.getGbMovil().toLowerCase().contains("ilimitados") ? "Gb ilimitados" : tarifasDTO.getGbMovil()));
        
        if(tarifasDTO.isTv()) {
                descripcionList.getItems().add("Pack " + tarifasDTO.getNombre());
        } 
        
        if(fibrasDTO != null) {
            descripcionList.getItems().add("Fibra " + fibrasDTO.getNombre());
            importe += fibrasDTO.getSobrecargo();
        }
        
        if(streamingDTO != null) {
            descripcionList.getItems().add(tarifasDTO.isStreaming() ? "Con " + streamingDTO.getNombre() : "");
        }

        row.setCantidad(1);
        row.setDescripcion(descripcionList);
        row.setImporte(importe);
        total += importe;
        view.getResumenView().getItems().add(row);
    }

    private void updateCentralitaRow() {
        ResumentTableItem row = new ResumentTableItem();
        CentralitasDTO centralitasDTO = view.getCentralitaCombo().getValue();
        ListView<String> descripcion = new ListView<>();
        descripcion.setPrefHeight(10);
        descripcion.getItems().add("Centralita " + centralitasDTO.getNombre());
        
        double importe = centralitasDTO.getPrecio();
        row.setCantidad(1);
        row.setDescripcion(descripcion);
        row.setImporte(importe);
        total += importe;
        view.getResumenView().getItems().add(row);
    }
    
    public void updatePackFutbolRow() {
        ResumentTableItem row = new ResumentTableItem();
        PacksFutbolDTO dto = view.getPacksFutbolCombo().getValue();
        ListView<String> descripcion = new ListView<>();
        descripcion.setPrefHeight(10);
        
        if(dto != null) {
            descripcion.getItems().add("Pack " + dto.getNombre());
        }
        
        double importe = dto.getPrecio();
        row.setCantidad(1);
        row.setDescripcion(descripcion);
        row.setImporte(importe);
        view.getResumenView().getItems().add(row);
        total += importe;
    }

    private void updateDescuentoRow() {
        ResumentTableItem row = new ResumentTableItem();
        DescuentosDTO dto = view.getDescuentoCombo().getValue();
        ListView<String> descripcion = new ListView<>();
        descripcion.setPrefHeight(10);
        
        if(dto != null) {
            descripcion.getItems().add("Descuento " + dto.getPorciento() + "%");
        }
        
        double importe = (double) (view.getResumenView().getItems().get(0).getImporte() * dto.getPorciento())/-100;
        row.setCantidad(1);
        row.setDescripcion(descripcion);
        row.setImporte(importe);
        total += importe;
        view.getResumenView().getItems().add(row);
    }
    
    private void addLineasAdicionales(LineasAdicionalesDTO dto, int quantity) {
        Integer index = 0;
        boolean exist = false;
        for(LineasPresupuestoDTO linea : lineasPresupuestoList) {
            if(linea.getLineasAdicional().getId() == dto.getId()){
                index = lineasPresupuestoList.indexOf(linea);
                exist = true;
            }
        }
        if(exist){
            lineasPresupuestoList.set(index, new LineasPresupuestoDTO(index, quantity, dto));
        } else {
            lineasPresupuestoList.add(new LineasPresupuestoDTO(index, quantity, dto));
        }
    }

    public void removeLineasAdicionales(LineasAdicionalesDTO dto, int quantity) {
        if(lineasPresupuestoList.size() > 0){
            int index = 0;
            for(LineasPresupuestoDTO linea : lineasPresupuestoList) {
                if(linea.getLineasAdicional().getId() == dto.getId()){
                    index = lineasPresupuestoList.indexOf(linea);
                }
            }
            
            if(quantity > 0) {
                lineasPresupuestoList.set(index, new LineasPresupuestoDTO(index, quantity, dto));
            } else {
                lineasPresupuestoList.remove(index);
            }
        }
    }

    private void updateServiciosAdicionalesRow() {
        ServiciosAdicionalesDTO dto = view.getTarifasCombo().getValue().getServiciosAdicionales();
        ResumentTableItem row = new ResumentTableItem();
        ListView<String> descripcion = new ListView<>();
        descripcion.setPrefHeight(138);
        descripcion.getItems().add("Roaming: llamadas y " + dto.getRoaming() + " en Zona Roaming UE.");
        if(dto.getInternacional() != null){
            descripcion.getItems().add("Llamadas internacionales: " + dto.getInternacional() + ".");
        }
        if(dto.isLegalitas()) {descripcion.getItems().add("Legálitas Protección Jurídica Negocios Orange.");}
        if(dto.isCloud()) {descripcion.getItems().add("Cloud y Protección Dispositivos.");}
        if(dto.isCiberProteccion()) {descripcion.getItems().add("Ciber Protección Red Móvil.");}
        if(dto.isAtencionPersonalizada()) {descripcion.getItems().add("Atención personalizada.");}
        if(dto.getCentralita() != null){
            descripcion.getItems().add("Centralita Negocio: " + dto.getInternacional() + ".");
        }
        if(dto.getNumBeneficios() > 0) {
            descripcion.getItems().add(dto.getNumBeneficios() + " beneficios a elegir para tu negocio" + 
            (dto.getDescuentoBeneficios() != null ? " con " + dto.getDescuentoBeneficios() : "") + ".");
        }

        row.setCantidad(1);
        row.setDescripcion(descripcion);
        row.setImporte(0.0);
        view.getResumenView().getItems().add(row);
    }

    public void limpiarFormulario(){
        view.getTarifasCombo().valueProperty().set(null);
        view.getFibraCombo().valueProperty().set(null);
        view.getStreamingCombo().valueProperty().set(null);
        view.getCentralitaCombo().valueProperty().set(null);
        view.getPacksFutbolCombo().valueProperty().set(null);
        view.getDescuentoCombo().valueProperty().set(null);
        for(Node node : view.getLineasAdicionalesView().getItems()) {
            Node quantity = ((HBox) node).getChildren().get(3);
            ((Label) quantity).setText("0");
        }
        lineasPresupuestoList.clear();
        view.getTotalField().setText("");
        view.getPresupuestoField().setText("");
        presupuesto = new PresupuestosDTO();
        updateResumenTable();
        view.getActualizarButton().setDisable(view.getPresupuestoField().getText().isEmpty());
        view.getSaveButton().setDisable(!view.getPresupuestoField().getText().isEmpty());
    }

    public void loadLineasAdicionalesView() {
        view.getLineasAdicionalesView().getItems().clear();
        for(LineasAdicionalesDTO dto : lineasAdicionalesList) {
            HBox listViewItem = new HBox();
            Label itemId = new Label(Integer.toString(dto.getId()));
            itemId.setVisible(false);
            itemId.getStyleClass().add("view_id");
            Label itemName = new Label(dto.getNombre());
            itemName.setMaxWidth(Double.MAX_VALUE);
            itemName.getStyleClass().add("view_label");
            Button addItemButton = new Button("+");
            addItemButton.getStyleClass().add("view_btn");
            Label itemQuantityLabel = new Label("0");
            itemQuantityLabel.getStyleClass().add("view_qt");
            Button deleteItemButton = new Button("-");
            deleteItemButton.getStyleClass().add("view_btn");

            addItemButton.setOnAction(e -> {
                int quantity = Integer.decode(itemQuantityLabel.getText());
                quantity += 1;
                itemQuantityLabel.setText(Integer.toString(quantity));
                addLineasAdicionales(dto, quantity);
                updateResumenTable();
            });
            
            deleteItemButton.setOnAction(e -> {
                int quantity = Integer.decode(itemQuantityLabel.getText());
                quantity -= 1;
                itemQuantityLabel.setText(Integer.toString(quantity >= 1 ? quantity : 0));
                removeLineasAdicionales(dto, quantity);
                updateResumenTable();
            });

            listViewItem.setHgrow(itemName, Priority.ALWAYS);
            listViewItem.setAlignment(Pos.CENTER_RIGHT);
            if(lineasPresupuestoList != null) {
                for(LineasPresupuestoDTO lineaPresupuesto : lineasPresupuestoList) {
                    if(lineaPresupuesto.getLineasAdicional().getId() == dto.getId()) {
                        itemQuantityLabel.setText(Integer.toString(lineaPresupuesto.getCantidad()));
                    }
                }
            }

            listViewItem.getChildren().addAll(itemId, itemName, addItemButton, itemQuantityLabel, deleteItemButton);

            view.getLineasAdicionalesView().getItems().add(listViewItem);
        }
    }

    public void loadPresupuestoDTO(PresupuestosDTO loaded) {
        presupuesto = loaded;
        view.getTarifasCombo().setValue(loaded.getTarifa());
        view.getFibraCombo().getItems().clear();
        view.getFibraCombo().getItems().addAll(loaded.getTarifa().getFibras());
        view.getFibraCombo().setValue(loaded.getFibra());
        view.getStreamingCombo().setDisable(!loaded.getTarifa().isStreaming());
        view.getStreamingCombo().setValue(loaded.getStreaming());
        view.getCentralitaCombo().setValue(loaded.getCentralita());
        view.getPacksFutbolCombo().setValue(loaded.getPackFutbol());
        view.getDescuentoCombo().setValue(loaded.getDescuento());
        view.getPresupuestoField().setText(loaded.getNombre());
        lineasPresupuestoList = loaded.getLineasAdicionales();
        loadLineasAdicionalesView();
        updateResumenTable();
        view.getActualizarButton().setDisable(view.getPresupuestoField().getText().isEmpty());
        view.getSaveButton().setDisable(!view.getPresupuestoField().getText().isEmpty());
    }
}
