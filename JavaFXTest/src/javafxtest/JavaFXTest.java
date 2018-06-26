/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;

import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author vvlasov
 */
public class JavaFXTest extends Application {
    private static Text text = new Text();
    private static ScrollPane scp;
    private CheckBox cBox1;
    private CheckBox cBox2;
    
    @Override
    public void start(Stage primaryStage) {
        
        Group root = new Group();
        Scene scene = new Scene(root, 500, 250,Color.AQUA);
        scp = new ScrollPane();
        scp.setLayoutX(20);
        scp.setLayoutY(150);
        scp.setPrefSize(150, 60);
        
        
        
        
        cBox1 = new CheckBox("За");
        cBox1.setLayoutX(20);
        cBox1.setLayoutY(20);
        cBox1.setOnAction(new EventHandler<ActionEvent> (){
            @Override
            public void handle(ActionEvent event) {
                if(cBox1.isSelected()){
                    text.setText("За!");
                    scp.setContent(text);
                    cBox2.setBlendMode(BlendMode.DARKEN);
                    cBox2.setOpacity(0.5);
                    cBox2.setMouseTransparent(true);
                }else if(!cBox1.isSelected()){
                    cBox2.setOpacity(1);
                    cBox2.setMouseTransparent(false);
                    cBox2.setBlendMode(BlendMode.SRC_OVER);
                }
                
            }
        });
    
    
        cBox2 = new CheckBox("Против!");
        cBox2.setLayoutX(20);
        cBox2.setLayoutY(40);
        cBox2.setOnAction(new EventHandler<ActionEvent> (){
            @Override
            public void handle(ActionEvent event) {
                if(cBox2.isSelected()){
                    text.setText("против");
                    scp.setContent(text);
                    cBox1.setBlendMode(BlendMode.DARKEN);
                    cBox1.setOpacity(0.5);
                    cBox1.setMouseTransparent(true);
                //text.setPromptText("Против!!!");
                
                }
            }
        });
        
    Button btn1 = new MyButton("Подтвердить");
    btn1.setLayoutX(20);
    btn1.setLayoutY(80);
    btn1.setOnAction(new EventHandler<ActionEvent> () {
          
            @Override
            public void handle(ActionEvent event) {
                cBox1.setBlendMode(BlendMode.DARKEN);
                cBox1.setOpacity(0.5);
                cBox2.setBlendMode(BlendMode.DARKEN);
                cBox2.setOpacity(0.5);
                cBox1.setMouseTransparent(true);
                cBox2.setMouseTransparent(true);
                
                
            }
        });
    
    Button btn2 = new MyButton("Отменить");
    btn2.setLayoutX(20);
    btn2.setLayoutY(115);
    btn2.setOnAction(new EventHandler<ActionEvent> () {
          
            @Override
            public void handle(ActionEvent event) {
                cBox1.setBlendMode(BlendMode.SRC_OVER);
                cBox2.setBlendMode(BlendMode.SRC_OVER);
                cBox1.setMouseTransparent(false);
                cBox2.setMouseTransparent(false);
                cBox1.setOpacity(1);
                cBox2.setOpacity(1);
                cBox1.selectedProperty().setValue(false);
                cBox2.selectedProperty().setValue(false);
                text.setText("");
                scp.contentProperty().set(text);
            }
        });
    
    Hyperlink hlk = new Hyperlink();
        hlk.setLayoutX(130);
        hlk.setLayoutY(20);
        hlk.setMinSize(100, 30);
        hlk.setText("Поменять цвет");
        hlk.setTextAlignment(TextAlignment.RIGHT);
        hlk.setBorder(Border.EMPTY);
        hlk.setTextFill(Color.BLACK);
        hlk.setOnAction(new EventHandler<ActionEvent> (){
            @Override
            public void handle(ActionEvent event) {
                scene.setFill(Color.LIGHTGREEN);
                hlk.setTextFill(Color.RED);
                hlk.setOnAction(new EventHandler<ActionEvent> () {
                    @Override
                    public void handle(ActionEvent event) {
                        scene.fillProperty().set(Color.AQUA);
                        hlk.setTextFill(Color.BLACK);
                        }
                });
            }
            
        });
        root.getChildren().add(cBox1);
        root.getChildren().add(cBox2);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(scp);
        root.getChildren().add(hlk);
        
        primaryStage.setTitle("Голосование");
        primaryStage.setScene(scene);
        primaryStage.show();
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
