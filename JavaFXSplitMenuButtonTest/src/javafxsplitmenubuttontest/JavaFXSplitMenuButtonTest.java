/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsplitmenubuttontest;

import static java.lang.Thread.State.RUNNABLE;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author vvlasov
 */
public class JavaFXSplitMenuButtonTest extends Application {
    
    private Thread threadTime;
    private boolean isTimeTrue;
    private boolean isTrue = true;
    private int count = 0;
    private int countClicks = 0;
    
    @Override
    public void start(Stage primaryStage) {
        
        Group root = new Group();
        TextField tfld = new TextField();
        tfld.setLayoutX(20);
        tfld.setLayoutY(150);
        tfld.setPrefColumnCount(20);
        tfld.setCursor(Cursor.TEXT);
        tfld.setPromptText("Platz für Zeitanzeige");
        tfld.setEditable(false);
        tfld.setDisable(true);
        tfld.setOpacity(2);
        tfld.setFont(Font.font(18));
        
        TextField tfld2 = new TextField();
        tfld2.setLayoutX(20);
        tfld2.setLayoutY(150);
        tfld2.setPrefColumnCount(20);
        tfld2.setCursor(Cursor.TEXT);
        tfld2.setPromptText("Platz für Stoppuhranzeige");
        tfld2.setEditable(false);
        tfld2.setDisable(true);
        tfld2.setOpacity(2);
        tfld2.setFont(Font.font(18));
        
        
        SplitMenuButton btn = new SplitMenuButton();
        btn.setText("ZEIT/STOPPUHR");
        btn.setLayoutX(20);
        btn.setLayoutY(20);
        btn.setCursor(Cursor.OPEN_HAND);
        btn.setPrefSize(200, 80);
        /*Image im = new Image(this.getClass().getResource("wikia.png").toString());
        ImageView imw = new ImageView(im);
        imw.setFitHeight(50);
        imw.setFitWidth(50);
        
        btn.setGraphicTextGap(16);*/
        btn.setAlignment(Pos.CENTER);
        btn.setPopupSide(Side.RIGHT);
        RadioMenuItem rmi = new RadioMenuItem("Zeit erfahren");
        rmi.setAccelerator(KeyCombination.keyCombination("Alt+q"));
        
        
        MenuItem mi = new MenuItem("Cancel");
        mi.setAccelerator(KeyCombination.keyCombination("Shift+Q"));
                    mi.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            btn.setText("STOPPUHR");
                            tfld2.setVisible(false);
                            tfld.setVisible(true);
                            isTimeTrue=false;
                            rmi.setSelected(false);
                            rmi.setDisable(false);
                            tfld.setText("");
                            isTrue = false;
                    }
                });
        
        
        SeparatorMenuItem smi = new SeparatorMenuItem();
        
        Scene scene = new Scene(root, 400, 200, Color.ANTIQUEWHITE);
        
        primaryStage.setTitle("SplitMenuButton");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        root.getChildren().addAll(btn, tfld, tfld2);
        btn.getItems().addAll(mi, smi, rmi);
        
        
        
        rmi.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                if(rmi.isSelected()){
                    isTimeTrue = true;
                    tfld2.setVisible(false);
                    tfld.setVisible(true);
                    btn.setText("ZEIT");
                    
                    threadTime = new Thread(new Runnable() {
                        @Override
                        public void run() {
                           while(isTimeTrue){
                            Calendar date = Calendar.getInstance();
                            //tfld.setText(date.getTime().getHours()+":"+date.getTime().getMinutes()+":"+date.getTime().getSeconds());
                            
                            tfld.setText(date.getTime().toString());
                            try{
                                TimeUnit.SECONDS.sleep(1);
                            }catch(InterruptedException e){
                    
                            }
                        }
                    }
                });
                    threadTime.setDaemon(true);
                    threadTime.start();
                    
                    //System.out.println(date.getTime().getHours()+":"+date.getTime().getMinutes()+":"+date.getTime().getSeconds());
                    rmi.setDisable(true);
                    }
            }
            
        });
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                countClicks++;
                tfld.setVisible(false);
                tfld2.setVisible(true);
                Thread thread2  = new Thread(new Runnable() {
                        @Override
                        public void run() {
                           while(isTrue){
                            tfld2.setText(""+(count++));
                            try{
                                TimeUnit.MILLISECONDS.sleep(100);
                            }catch(InterruptedException e){
                    
                            }
                        }
                    }
                });
                if(countClicks%2==1){
                    btn.setText("STOP");
                    isTrue = true;
                    thread2.setDaemon(true);
                    thread2.start();
                    
                }else if(countClicks%2==0) {
                    btn.setText("START");
                    isTrue = false;
                    count = 0;
                    if((double)(Integer.valueOf(tfld2.getText()))/600< 1){
                        tfld2.setText(((double)(Integer.valueOf(tfld2.getText()))/10+" Sekunden").replace(".", ","));
                    }else
                        tfld2.setText(((double)(Integer.valueOf(tfld2.getText()))/600+" Minuten").replace(".", ","));
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
