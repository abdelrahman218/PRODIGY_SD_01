package app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TempConvApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TextField tfUserInput=new TextField();
        ObservableList<String> units= FXCollections.observableArrayList("Celsius","Kelvin","Fahrenheit");
        ComboBox<String> tempUnit=new ComboBox<>(units);
        TextArea taResults=new TextArea();
        Button btnConv=new Button("Convert"),btnClr=new Button("Clear");
        tfUserInput.setPromptText("Enter a Value");
        tempUnit.getSelectionModel().select(0);
        taResults.setEditable(false);
        HBox buttons=new HBox(btnClr,btnConv);
        GridPane root=new GridPane();
        root.add(new Label("Temperature Converter"),0,0,3,1);
        root.add(tfUserInput,0,1);
        root.add(tempUnit,1,1);
        root.add(taResults,0,2,3,1);
        root.add(buttons,2,3);
        Scene scene = new Scene(root, 320, 240);
        scene.getStylesheets().add((new File("").getAbsolutePath()).concat("\\src\\main\\resources\\app\\style.css"));
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}