/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmenubuttontest;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import static javax.management.Query.value;

/**
 *
 * @author vvlasov
 */
public class JavaFXMenuButtonTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.AQUA);
        
        primaryStage.setTitle("Тест Меню Кнопки");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        TextField tfld = new TextField();
        tfld.setLayoutX(20);
        tfld.setLayoutY(150);
        tfld.setPrefColumnCount(20);
        tfld.setCursor(Cursor.TEXT);
        tfld.setPromptText("Здесь будут команды");
       
        
        MenuButton mbtn = new MenuButton("Менюшка");
        mbtn.setTextFill(Color.BLACK);
        mbtn.setLayoutX(20);
        mbtn.setLayoutX(20);
        mbtn.setScaleShape(true);
        mbtn.setScaleX(1.2);
        mbtn.setScaleY(1);
        //mbtn.setStyle("-fx-font: bold italic 18 pt Georgia");
        //mbtn.setBlendMode(BlendMode.BLUE);
        mbtn.setCursor(Cursor.HAND);
        mbtn.setOnMouseEntered((MouseEvent event)-> {
            if(mbtn.isFocused())
                mbtn.setTextFill(Color.RED);
            
        });
        mbtn.setOnMouseExited((MouseEvent event)-> {
            if(mbtn.isFocused())
                mbtn.setTextFill(Color.BLACK);
            
        });
        
        mbtn.setWrapText(true);
        mbtn.setPrefSize(150, 50);
        /*ImageView imw = new ImageView(new Image(this.getClass().getResourceAsStream("Wikia.png").toString()));
        imw.setFitHeight(30);
        imw.setFitWidth(30);
        mbtn.setGraphic(imw);*/
        mbtn.setAlignment(Pos.CENTER);
        mbtn.setContentDisplay(ContentDisplay.LEFT);
        mbtn.setPopupSide(Side.BOTTOM);
        MenuItem mitm = new MenuItem("Вырезать");
        //mitm.setStyle("-fx-font:bold italic 14 pt Times;");
        mitm.setAccelerator(KeyCombination.keyCombination("Ctrl+q"));
        mitm.setOnAction((ActionEvent event) -> {
            tfld.setText("Вырезаю");
        });
        
        MenuItem mitm2 = new MenuItem("Копировать");
        //mitm2.setStyle("-fx-font:bold italic 14 pt Times;");
        mitm2.setAccelerator(KeyCombination.keyCombination("Ctrl+w"));
        mitm2.setOnAction((ActionEvent event) -> {
            tfld.setText("Копирую");
        });
        
        MenuItem mitm3 = new MenuItem("Вставить");
        //mitm3.setStyle("-fx-font:bold italic 14 pt Times;");
        mitm3.setAccelerator(KeyCombination.keyCombination("Ctrl+e"));
        mitm3.setOnAction((ActionEvent event) -> {
            tfld.setText("Вставляю");
        });
        
        mbtn.getItems().addAll(mitm, mitm2, mitm3);
        root.getChildren().addAll(mbtn, tfld);
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
