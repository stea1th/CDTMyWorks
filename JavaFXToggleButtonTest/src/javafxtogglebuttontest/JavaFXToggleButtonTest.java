/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtogglebuttontest;


import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author vvlasov
 */
public class JavaFXToggleButtonTest extends Application {
    
    private boolean isTrue = true;
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        TextField txt3 = new TextField();
        txt1.setLayoutX(20);
        txt1.setLayoutY(60);
        txt1.setPrefSize(50, 25);
        txt1.setDisable(true);
        txt1.setOpacity(2);
        
        txt2.setLayoutX(20);
        txt2.setLayoutY(100);
        txt2.setPrefSize(50, 25);
        txt2.setDisable(true);
        txt2.setOpacity(2);
        
        txt3.setLayoutX(20);
        txt3.setLayoutY(140);
        txt3.setPrefSize(50, 25);
        txt3.setDisable(true);
        txt3.setOpacity(2);
        
        txt1.setPromptText("HH");
        txt2.setPromptText("MM");
        txt3.setPromptText("SS");
        
        
        ToggleButton tbtn2 = new ToggleButton("STOP");
        tbtn2.setLayoutX(90);
        tbtn2.setLayoutY(20);
       
        
        ToggleButton tbtn = new ToggleButton("START");
        tbtn.setLayoutX(20);
        tbtn.setLayoutY(20);
        tbtn.setCursor(Cursor.OPEN_HAND);
        Tooltip tool = new Tooltip("Click mich");
        tbtn.setTooltip(tool);
        tbtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(tbtn.isSelected()){
                    tbtn2.setSelected(false);
                    isTrue = true;
                    tbtn.setDisable(true);
                    
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //int i = 20;
                            while(isTrue){
                            for (int i = 20; i < 145; i++) {
                                tbtn2.setLayoutY(i);
                                if(!isTrue)
                                    break;
                                try{
                                TimeUnit.MILLISECONDS.sleep(50);
                                } catch(InterruptedException e){
                                    
                                }
                            }
                            
                            for (int i = 145; i > 20; i--) {
                                tbtn2.setLayoutY(i);
                                if(!isTrue)
                                    break;
                                try{
                                TimeUnit.MILLISECONDS.sleep(50);
                                } catch(InterruptedException e){
                                    
                                }
                            }
                            
                            if(!isTrue)
                                    break;
                            }
                            tbtn2.setLayoutY(20);
                        }
                    });
                    thread.setDaemon(true);
                    thread.start();
                    
                    
                    Thread thread2 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            
                        while(isTrue){
                            Calendar date = Calendar.getInstance();
                            txt1.setText(""+date.getTime().getHours());
                            txt1.setAlignment(Pos.CENTER);
                            txt1.setFont(Font.font(16));
                            
                            txt2.setText(""+date.getTime().getMinutes());
                            txt2.setAlignment(Pos.CENTER);
                            txt2.setFont(Font.font(16));
                            
                            int seconds = date.getTime().getSeconds();
                            if(seconds<= 9){
                                txt3.setText("0"+seconds);
                            }else
                                txt3.setText(""+seconds);
                            txt3.setAlignment(Pos.CENTER);
                            txt3.setFont(Font.font(16));
                            
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException ex) {
                                
                            }
                        }
                            
                        }
           
                    });
                    thread2.setDaemon(true);
                    thread2.start();
                    
                }
            }
        });
                
        
        tbtn2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(tbtn2.isSelected()){
                    tbtn.setSelected(false);
                    tbtn2.setLayoutX(80);
                    tbtn2.setLayoutY(20);
                    isTrue = false;
                    tbtn.setDisable(false);
                    tbtn2.setVisible(true);
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    
                    txt1.setPromptText("HH");
                    txt1.setAlignment(Pos.CENTER);
                    txt2.setPromptText("MM");
                    txt2.setAlignment(Pos.CENTER);
                    txt3.setPromptText("SS");
                    txt3.setAlignment(Pos.CENTER);
                    
                }
            }
        });
        
        
        Scene scene = new Scene(root, 430, 300, Color.GAINSBORO);
        primaryStage.setScene(scene);
        primaryStage.show();
        root.getChildren().addAll(tbtn, tbtn2, txt1, txt2, txt3);
        
        
        
        
        
        /*primaryStage.setTitle("ToggleButton Test");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        ToggleGroup tgroup = new ToggleGroup();
        ToggleButton btnOn = new ToggleButton("JavaFX");
        btnOn.setLayoutX(10);
        btnOn.setLayoutY(10);
        btnOn.setCursor(Cursor.CLOSED_HAND);
        btnOn.setPrefSize(200, 80);
        btnOn.setStyle("-fx-base: #9900ff;-fx-font: bold italic 30 pt Georgia; -fx-text-fill:white;");
        /*ImageView imv = new ImageView(new Image(this.getClass().getResource("wikia.png").toString()));
        btnOn.setGraphic(imv);*/
        
        //root.getChildren().addAll(btnOn);
        

            
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
                
