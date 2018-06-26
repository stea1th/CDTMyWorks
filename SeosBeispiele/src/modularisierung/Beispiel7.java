/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularisierung;

import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class Beispiel7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = getDate();
        System.out.printf("Jahr %d ist Schaltjahr? %b\n", x, getResult(x));
    }

    public static int getDate() {

        while (true) {
            System.out.print("Geben Sie Jahr ein: ");
            int jahr = new Scanner(System.in).nextInt();
            if (jahr >= 1600 && jahr <= 2500) {
                return jahr;
            }
            System.out.println("Falsche Eingabe!");
        }
    }

    public static boolean getResult(int jahr) {
        return jahr % 400 == 0 || jahr % 4 == 0 && jahr % 100 != 0;
    }

}
