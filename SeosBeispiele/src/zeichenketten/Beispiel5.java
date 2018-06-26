/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeichenketten;

import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class Beispiel5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        System.out.printf("%s ist %sein Palindrom\n", s, palin(s)? "" : "k");
    }
    
    public static boolean palin(String s){
        char[] x = s.toLowerCase().toCharArray();
        int count = 0;
        for (int i = 0; i < x.length/2; i++) {
            if(x[i]==x[x.length-1-i]){
                count++;
            }
        }
        return count==x.length/2;
    }
    
}
