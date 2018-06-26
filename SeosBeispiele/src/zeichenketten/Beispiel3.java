/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeichenketten;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class Beispiel3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String x = new Scanner(System.in).nextLine();
        int anz;
        for(char c = 'a'; c<='e'; c++){
            anz = 0;
            for (int i = 0; i < x.length(); i++) {
                if(c==x.charAt(i)){
                    anz++;
                }
                
            }
            System.out.printf("%c ist %d mal vorhanden\n", c, anz);
        }
    }
    
}
