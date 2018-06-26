/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class Aufg3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int jahr = new Scanner(System.in).nextInt();
        if (jahr >= 1580 && jahr <= 2100) {
            System.out.println(jahr % 4 == 0 && jahr % 100 != 0 || jahr % 400 == 0 ? "Schaltjahr " + jahr : "Normaljahr " + jahr);
        }

    }

}
