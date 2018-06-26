/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.control.TextField;

/**
 *
 * @author vvlasov
 */
public class CalculatorBody {
    
    private String string;
    //private static final List<String> list = new ArrayList();
    private MyTextField tField;
    private List<String> list;

    public CalculatorBody(String string, MyTextField tField) {
        this.string = string;
        this.tField = tField;
        /*list = new ArrayList();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");*/
    }

    /*public static List<String> getList() {
        return Collections.unmodifiableList(list);
    }*/
    
    public void getResult(){
        String[] numbers = new String[2];
        String sign = "";
        list = tField.getList();
        for(String x : list ){
            if(string.substring(1, string.length()-1).contains(x)){
                sign = x;
                if(string.startsWith("-")&&sign.equals("-")){
                    numbers = string.substring(0, string.length()-1).replace(x, " ").replace(",", ".").trim().split(" ");
                    numbers[0] = sign+numbers[0];
                }else{
                    numbers = string.substring(0, string.length()-1).replace(x, " ").replace(",", ".").trim().split(" ");
                }
                //numbers = string.substring(0, string.length()-1).replace(string.substring(1, replaced.length()), replaced).replace(",", ".").trim().split(" ");
            }
        }
        switch(sign){
                case "+" :
                    addition(numbers);
                    break;
                case "-" :
                    substraction(numbers);
                    break;
                case "*" :
                    multiplication(numbers);
                    break;
                case "/" :
                    division(numbers);
                    break;
                case "√" :
                    square(numbers);
                    break;
                case "%" :
                    prozent(numbers);
                    break;
                default :
                    tField.setText("Error in body");
        }
    }
    
    private void addition(String[] numbers){
        double result = Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
        printIt(result);
        }
    
    private void substraction(String[] numbers){
        double result = Double.parseDouble(numbers[0])-Double.parseDouble(numbers[1]);
        printIt(result);
        }
    
    
    private void multiplication(String[] numbers){
        double result = Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
        printIt(result);
        }
    
    private void division(String[] numbers){
        double result = Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
        printIt(result);
        }
    
    private void prozent(String[] numbers){
        double result = Double.parseDouble(numbers[0])*(Double.parseDouble(numbers[1])/100);
        printIt(result);
    }
    
    private void square(String[] numbers){
        double result = Math.pow(Double.parseDouble(numbers[0]),1.0/Double.parseDouble(numbers[1]));
        printIt(result);
    }
    
    
    private void printIt(double res){
        int x = (int) res;
        String result = "";
        if(x == res){
           result = String.valueOf(x);
        }else{
           result = String.valueOf(res);
        }
        tField.setText(result.replace(".", ","));
        
    }
}
