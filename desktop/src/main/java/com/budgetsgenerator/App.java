package com.budgetsgenerator;

import java.io.IOException;

import com.budgetsgenerator.controllers.MainController;
import com.budgetsgenerator.views.MainView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        MainView mainView = new MainView();
        MainController mainController = MainController.getInstance(mainView);
        
        Scene scene = new Scene(mainView.getRoot());
        stage.setTitle("Generador de presupuestos - Orange Empresas");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
