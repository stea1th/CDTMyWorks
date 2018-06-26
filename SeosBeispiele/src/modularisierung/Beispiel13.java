/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularisierung;

/**
 *
 * @author vvlasov
 */
public class Beispiel13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "Privet medved";
        String s1 = "Привет медвед";
        byte[] buf = s.getBytes();
        byte[] buf1 = s1.getBytes();
        char[] x = s.toCharArray();
        System.out.println(new String(x));
        
        System.out.println(s.getBytes().length);
        System.out.println(s1.getBytes().length);
    }
    
}
