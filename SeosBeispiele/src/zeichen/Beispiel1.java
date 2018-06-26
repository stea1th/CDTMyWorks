/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeichen;

import java.util.Locale;

/**
 *
 * @author vvlasov
 */
public class Beispiel1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char z1, z2 = 'A' , z3 = '\u0041';
        
        z1 = 65;
        
        String s = "z";
        //s.codePoints()
               // .forEach(System.out::println);
               
               
        
        
        String b = Integer.toUnsignedString(s.codePointAt(0), 16);
        //System.out.println("Hex "+s+" ist "+a);
        
        char z4 =(char) (z1 + ' ');
        System.out.println(b);
        
        char prod = (char)('3'*'4');
        
        System.out.println("Prod "+prod);
        System.out.println("Prod2: "+ (int) prod);
        
        
        //String a = Integer.toHexString(s.codePointBefore(s.length()));
        
        System.out.println(Integer.toHexString((int)prod));
        
        char z6 = '7';
        
        int zahl = z6-'0';
        System.out.println(zahl);
        System.out.println('\u0a5c');
        
        /*System.out.println("Z1: "+z1);
        System.out.println("Z2: "+z2);
        System.out.println("Z3: "+z3);
        System.out.println(x);*/
        
    }
    
}
