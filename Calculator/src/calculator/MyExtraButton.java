/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author vvlasov
 */
public class MyExtraButton extends MyButton{
    
    private MyTextField tField;
    private List<String> list;
    
    public MyExtraButton(String number, double x, double y, MyTextField tField) {
        super(number, x, y, tField);
        this.tField = tField;
        list = tField.getList();
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tField.appendText(number); 
                String line = tField.getText();
                try{
                if(number.equals("=")){
                    //
                    new CalculatorBody(line, tField).getResult();
                    
                /*try{
                for(String sign : list){
                    String line = tField.getText();
                    if(line.substring(1).contains(sign)){
                        new CalculatorBody(line, tField).getResult();
                        System.out.println(sign);
                        tField.appendText(number);
                        break;
                    }else{
                        tField.appendText(number);
                        System.out.println(sign);
                        break;
                    }
                    
                }*/
                }
                
                }catch(Exception e){
                    tField.setText("Error in ExtraButton");
                }
            }
        });
    }
    
    
    
}
