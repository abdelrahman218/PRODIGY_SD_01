package app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TempConvApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Declaring All Nodes
        Label title=new Label("Temperature Converter");
        TextField tfUserInput=new TextField();
        ObservableList<String> units= FXCollections.observableArrayList("Celsius","Kelvin","Fahrenheit");
        ComboBox<String> tempUnit=new ComboBox<>(units);
        TextArea taResults=new TextArea("this is a trial\n\nthis is a trial");
        Button btnConv=new Button("Convert"),btnClr=new Button("Clear");

        //Setting Nodes Properties
        tfUserInput.setPromptText("Enter a Value");
        tempUnit.getSelectionModel().select(0);
        taResults.setEditable(false);

        //Setting Classes to Nodes for CSS
        title.getStyleClass().add("title");
        tfUserInput.getStyleClass().addAll("textField","input");
        taResults.getStyleClass().addAll("textField","output");
        tempUnit.getStyleClass().addAll("box","combo");
        btnConv.getStyleClass().addAll("box","button");
        btnClr.getStyleClass().addAll("box","button");

        //Declaring Panes
        HBox buttons=new HBox(btnClr,btnConv);
        GridPane root=new GridPane();

        //Adding Nodes to Root
        root.add(title,0,0,3,1);
        root.add(tfUserInput,0,1);
        root.add(tempUnit,1,1);
        root.add(taResults,0,2,3,1);
        root.add(buttons,2,3);
        root.setHgap(5);
        root.setVgap(10);

        //Setting Panes Properties
        buttons.setSpacing(5);
        buttons.setAlignment(Pos.CENTER_RIGHT);

        //Event-Handlers
        btnClr.addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            tfUserInput.clear();
            taResults.clear();
        });
        btnConv.addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            int selected=tempUnit.getSelectionModel().getSelectedIndex();
            String temperature=tfUserInput.getText().trim();
            if(temperature.isEmpty()){
                taResults.setText("Please Enter a Value!");
                return;
            }
            try{
                double value=Double.parseDouble(temperature);
                switch (selected){
                    case 0:
                        ArrayList<Double> res1=TempConv.ConvCelsius(value);
                        taResults.setText("Kelvin: "+res1.get(0)+" K\n\n"+"Fahrenheit: "+res1.get(1)+" °F");
                        break;
                    case 1:
                        ArrayList<Double> res2=TempConv.ConvKelvin(value);
                        taResults.setText("Celsius: "+res2.get(0)+" °C\n\n"+"Fahrenheit: "+res2.get(1)+" °F");
                        break;
                    case 2:
                        ArrayList<Double> res3=TempConv.ConvFahrenheit(value);
                        taResults.setText("Celsius: "+res3.get(0)+" °C\n\n"+"Kelvin: "+res3.get(1)+" K");
                        break;
                }}
            catch (NumberFormatException excep){
                taResults.setText("Invalid Input!");
            }
        });
        //Declaring and Setting Scene
        Scene scene = new Scene(root, 1250, 700);
        scene.getStylesheets().add(TempConvApplication.class.getResource("style.css").toExternalForm());
        stage.getIcons().add(new Image(TempConvApplication.class.getResource("app icon.png").toExternalForm()));
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}