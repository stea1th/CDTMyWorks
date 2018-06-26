package javafxtest;


import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vvlasov
 */
public class MyButton extends Button {

    public MyButton(String text) {
        super(text);
        setPrefSize(150, 30);
        setTextFill(Color.GREEN);
        setCursor(Cursor.OPEN_HAND);
        Image image = new Image(this.getClass().getResourceAsStream("Wikia.png"));
        ImageView imw = new ImageView(image);
        imw.setFitHeight(30);
        imw.setFitWidth(30);
        setGraphic(imw);
    }
    
    
    
}
