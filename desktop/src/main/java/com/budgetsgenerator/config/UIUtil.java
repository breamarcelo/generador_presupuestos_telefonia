package com.budgetsgenerator.config;

import java.util.List;
import java.util.function.Function;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;


public class UIUtil {
    private static boolean darkMode = true;

    public static <T> StringConverter<T> createConverter(Function<T, String> nameExtractor) {
        return new StringConverter<T>() {
            @Override
            public String toString(T object) {
                return (object == null) ? "" : nameExtractor.apply(object);
            }
            @Override
            public T fromString(String string) {
                return null; 
            }
        };
    }

    public static void populateVBox(VBox box, List<Node> controls) {
        box.getChildren().addAll(controls);
        controls.get(0).getStyleClass().add("VBox-Label");
        box.setMargin(controls.get(0), new Insets(0, 0, 20, 0));
        for(Node node : controls) {
            if(node instanceof ComboBox || node instanceof TextField) {
                ((Control) node).setPrefWidth(Double.MAX_VALUE);
                box.setMargin(node, new Insets(5,0,10,0));
            }
            if(node instanceof HBox) {
                box.setMargin(node, new Insets(5,0,10,0));
            }
            
        }
    }

    public static String getPalette(){
        if(darkMode) {
            return "/css/dark-palette.css";
        }
        return "/css/light-palette.css";
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public static void setDarkMode(boolean value) {
        darkMode = value;
        // SidebarController.getInstance(new SidebarView());
        // MainController.getInstance(new MainView()).load();
    }
}
