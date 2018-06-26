/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author vvlasov
 */
public class MyClearAllButton extends MyButton {
    
    private MyTextField tField;
    
    public MyClearAllButton(String number, double x, double y, MyTextField tField) {
        super(number, x, y, tField);
        this.tField = tField;
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(number.equals("Clear")){
                    tField.setText(null);
                }else if(tField.getText().length()!=0)
                        tField.setText(tField.getText().substring(0, tField.getText().length()-1));
                else
                    return;
            }
        });
    }
    
    public void getButtonSize(){
        this.setPrefSize(100, USE_PREF_SIZE);
    }
    
}
