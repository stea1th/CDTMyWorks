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
public class Beispiel4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int a : array) {
            a = 0;
        }
        while (true) {
            System.out.print("Geben Sie was ein: ");
            String x = new Scanner(System.in).nextLine();
            if (x.length() == 0) {
                break;
            }
            char c = '0';
            for (int j = 0; j < array.length; j++) {
                int anz = 0;
                for (int i = 0; i < x.length(); i++) {
                    if (c == x.charAt(i)) {
                        anz++;
                    }
                }
                array[j] += anz;
                c++;
            }
        }
        char c = '0';
        boolean isVorhanden = false;
        for (int a : array) {
            if (a > 0) {
                System.out.println(String.format("%c ist %d mal vorhanden", c, a));
                isVorhanden = true;
            } 
            c++;
        }
        if (!isVorhanden) {
            System.out.println("Keine Ziffer vorhanden");
        }

    }

}
