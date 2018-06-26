/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author vvlasov
 */
public class Welcome implements Runnable {

    MyTextField tField;

    public Welcome(MyTextField tField) {
        this.tField = tField;
    }

    @Override
    public void run() {
        String line = "Welcome to MyCalculator                                      ";
        char[] x = line.toCharArray();
        StringBuilder builder;
        while (true) {
            try {
                int time = 200;
                builder = new StringBuilder();
                for (Character letter : x) {
                    builder.append(letter);
                    //tField.appendText(letter.toString());
                    tField.setPromptText(builder.toString());
                    TimeUnit.MILLISECONDS.sleep(time);
                    //builder.delete(0,1);
                    //time=time<50? time+10 : time-10;

                }
                //builder.delete(0, x.length);
            } catch (InterruptedException e) {
                tField.setText("Error");
            }
        }
    }

}
