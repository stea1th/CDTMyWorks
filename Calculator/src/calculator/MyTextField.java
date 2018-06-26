/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.text.Font;

/**
 *
 * @author vvlasov
 */
public class MyTextField extends TextField {
    
    private final List<String> list = new ArrayList();
    
    
    public MyTextField() {
        this.setPrefSize(290, 50);
        this.setBorder(Border.EMPTY);
        this.setLayoutX(10);
        this.setLayoutY(20);
        this.setDisable(true);
        this.setEditable(false);
        this.setOpacity(2);
        this.setAlignment(Pos.BASELINE_RIGHT);
        this.setFont(Font.font(24));
        
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        list.add("√");
        list.add("%");
    }
    
    public void printIt(){
        System.out.println(this.getText());
    }
    
    public MyTextField getMyTextField(){
        return this;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }

    
    
    
    
    

    
    
}
