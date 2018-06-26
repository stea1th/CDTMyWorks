/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author vvlasov
 */
public class JavaApplication4 {
    
    static FileInputStream input = null;
    static FileOutputStream output = null;
    
    public static void main(String[] args) {
        
        try{
        input = new FileInputStream(args[2]);
        output = new FileOutputStream(args[1],true);
        while(input.available()>0){
            int x = input.read();
            switch(args[0]){
                case "-d" : 
                    output.write(x+1);
                    break;
                case "-e" :
                    output.write(x-1);
                    break;
            }
        }
        input.close();
        output.close();
        
    } catch (FileNotFoundException e){
        
    } catch (IOException e){
        
    }
  }
}
