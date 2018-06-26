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
public class Test7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        pruefeSerNr();
    }
    public static void pruefeSerNr() {
        
        System.out.println("Bitte geben Sie die Seriennummer ein.\n Sie befindet sich auf der Rückseite Ihrer gedownloadeten .rar-Datei ;)");
        Scanner eingabe = new Scanner(System.in);
        String serNr = eingabe.next();
        if (serNr.matches("[B-Y]{3}-\\d{8}")) {      // true

            System.out.println("Die Seriennummer ist gültig");
        } else {
            System.out.println("Die Seriennummer ist UNÜLTIG");
        }
    }

    
}
