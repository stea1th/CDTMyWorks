/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author vvlasov
 */
public class MyButton extends Button {
    
    private String number;
    private MyTextField tField;
    

    public MyButton(String number, double x, double y, MyTextField tField) {
        this.number = number;
        this.setText(number);
        this.setPrefSize(50, 20);
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.tField = tField;
        this.setStyle("-fx-background-color: \n" +
"        #c3c4c4,\n" +
"        linear-gradient(#d6d6d6 50%, white 100%),\n" +
"        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
"    -fx-background-radius: 30;\n" +
"    -fx-background-insets: 0,1,1;\n" +
"    -fx-text-fill: black;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        
        this.setOpacity(0.8);
        
        MyButton myButton = this;
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               tField.appendText(number);
                //tField.printIt();
                /*if(t.equals(",")){
                    
                }*/
                    
            }
        });
        
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                myButton.setStyle("-fx-background-color: \n" +
"        #c3c4c4,\n" +
"        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
"        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
"    -fx-background-radius: 30;\n" +
"    -fx-background-insets: 0,1,1;\n" +
"    -fx-text-fill: black;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
            }
        });
        
        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                myButton.setStyle("-fx-background-color: \n" +
"        #c3c4c4,\n" +
"        linear-gradient(#d6d6d6 50%, white 100%),\n" +
"        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
"    -fx-background-radius: 30;\n" +
"    -fx-background-insets: 0,1,1;\n" +
"    -fx-text-fill: black;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
            }
        });
    }
    
}
