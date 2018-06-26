/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benutzerdefdatentyp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author vvlasov
 */
public class ZeitTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IllegalAccessException, NoSuchMethodException {
       //Zeit z1 = new Zeit();
       //Zeit z2 = new Zeit();
       Zeit z3 = new Zeit(12, 4, 15);
       
       
       
       
       
       
        /*System.out.printf("Zeitangabe in z1: %d:%02d:%02d\n",z1.getHour() , z1.getMinute(), z1.getSecond());
        
        Field[] x= z1.getClass().getDeclaredFields();
        
        for(Field f : x){
            f.setAccessible(true);
            //f.setInt(z1, f.getInt(z1)+12);
            f.set(z1, 20);
        }*/
        
        /*z1.setHour(12);
        z1.setMinute(34);
        z1.setSecond(48);*/
        
        //System.out.printf("Zeitangabe in z1: %d:%02d:%02d\n", z1.getHour(), z1.getMinute(), z1.getSecond());
        
        System.out.printf("Zeitangabe in z1: %s", z3.toString());
        //z1.println();
        
        
        
        
    }
    
}
