/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vvlasov
 */
class DecideBody implements Runnable {
    
    private BufferedReader reader;
    private double resultDigit;
    private final List<String> list;

    public DecideBody() {
        list = new ArrayList();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        list.add("/d");
        list.add("/w");
       }
    
    @Override
    public void run() {
        resultDigit = 0;
        while(true){
            if(resultDigit==0){
                double first=setDigit();
                getResult(first);
            }else{
                getResult(resultDigit);
            }
        }
    }
    
    public double setDigit(){
        double x = 0;
         reader = new BufferedReader(new InputStreamReader(System.in));
            try{
                String firstDigit = reader.readLine();
                if (firstDigit.contains(",")){
                    firstDigit = firstDigit.replace(",", ".");
                }
                try{
                    x = Double.valueOf(firstDigit);
                } catch(NumberFormatException e){
                    System.out.println("Format is false");
                }
            
            } catch(IOException e){
                
            }
            return x;
    }
    
    public void getResult(double first){
        reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String sign = reader.readLine();
            switch(sign){
                case "+" :
                    addition(first);
                    break;
                case "-" :
                    substraction(first);
                    break;
                case "*" :
                    multiplication(first);
                    break;
                case "/" :
                    division(first);
                    break;
                case "/d" :
                    setDigitToNull();
                    break;
                case "/w" :
                    square(first);
                    break;
                default :
                    System.out.println("Format is false");
                    //System.exit(0);
                    break;
            }
        }catch (IOException e){
            
        }
    }
    
    public void square(double first){
        printIt(Math.sqrt(first));
    }
    
    public void setDigitToNull(){
        resultDigit = 0;
        }
    
    public void addition(double first){
        printIt(first+setDigit());
        }
    
    public void substraction(double first){
        printIt(first-setDigit());
    }
    
    public void multiplication(double first){
        printIt(first*setDigit());
    }
    
    public void division(double first){
        printIt(first/setDigit());
    }
    
    public void printIt(double res){
        int x = (int) res;
        if(x == res){
            System.out.println("=\n"+ String.valueOf(x));
            resultDigit=x;
        }else{
            System.out.println("=\n"+ String.valueOf(res).replace(".", ","));
            resultDigit=res;
        }
        
    }
}
