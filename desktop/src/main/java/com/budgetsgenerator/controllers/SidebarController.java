package com.budgetsgenerator.controllers;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.views.SidebarView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class SidebarController {
    private static SidebarView view;
    private static SidebarController instance;

    private SidebarController(SidebarView view){
        this.view = view;
        load();
    }

    public static SidebarController getInstance(SidebarView view) {
        if(instance == null) {
            instance = new SidebarController(view);
        }
        return instance;
    }

    public void load() {
        view.getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
        view.getStylesheets().add(getClass().getResource("/css/sidebar.css").toExternalForm());
        view.getStyleClass().add("sidebar");

        Region start = new Region();
        Region end = new Region();

        ImageView img = new ImageView(new Image(getClass().getResource("/img/masorange-logo.png").toExternalForm()));
        img.setFitWidth(80);
        img.setPreserveRatio(true);
        ToggleButton custom = new ToggleButton();
        custom.getStyleClass().add("custom-button");
        custom.setOnAction(eh -> {
            UIUtil.setDarkMode(!custom.isSelected());
        });
        
        view.getChildren().addAll(img, start, view.getPresupuestosButton(), view.getTarifasButton(), view.getLineasAdicionalesButton(),view.getProductosButton(), end);
        for(Node node : view.getChildren()){
            view.setMargin(node, new Insets(0, 0, 10, 0));
            // if(node instanceof Button) {
            // }
        }
        view.setAlignment(Pos.CENTER);
        view.setVgrow(start, Priority.ALWAYS);
        view.setVgrow(end, Priority.ALWAYS);

        Region invoiceIcon = new Region();
        invoiceIcon.getStyleClass().addAll("icon", "invoice-icon");
        view.getPresupuestosButton().setGraphic(invoiceIcon);

        Region homeIcon = new Region();
        homeIcon.getStyleClass().addAll("icon", "home-icon");
        view.getTarifasButton().setGraphic(homeIcon);

        Region phoneIcon = new Region();
        phoneIcon.getStyleClass().addAll("icon", "phone-icon");
        view.getLineasAdicionalesButton().setGraphic(phoneIcon);

        Region shoppingIcon = new Region();
        shoppingIcon.getStyleClass().addAll("icon", "shopping-icon");
        view.getProductosButton().setGraphic(shoppingIcon);
        
        Region gearIcon = new Region();
        gearIcon.getStyleClass().addAll("icon", "gear-icon");
        view.getAjustesButton().setGraphic(gearIcon);
    }
}
