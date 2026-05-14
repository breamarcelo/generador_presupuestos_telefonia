package com.budgetsgenerator.views;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.controllers.SidebarController;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class MainView {
    private BorderPane root;
    private SidebarView sidebar;
    private ImageView img;

    public MainView() {
        this.root = new BorderPane();
        load();
    }

    public void load() {
        this.setSidebar(new SidebarView());
        SidebarController sidebarController = SidebarController.getInstance(sidebar);
        FlowPane emptyPane = new FlowPane();
        emptyPane.getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
        emptyPane.getStylesheets().add(getClass().getResource("/css/emptypane.css").toExternalForm());
        emptyPane.getStyleClass().add("empty-pane");
        img = new ImageView(new Image(getClass().getResource("/img/masorange-logo.png").toExternalForm()));
        img.setFitWidth(300);
        img.setPreserveRatio(true);
        emptyPane.getChildren().add(img);
        emptyPane.setAlignment(Pos.CENTER);
        root.setLeft(sidebar);
        root.setCenter(emptyPane);
    }

    public void setCenterContent(Node node) {
        root.setCenter(node);
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public SidebarView getSidebar() {
        return sidebar;
    }

    public void setSidebar(SidebarView sidebar) {
        this.sidebar = sidebar;
    }

    
}
