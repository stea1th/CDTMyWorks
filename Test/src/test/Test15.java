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
public class Test15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int zähler = 0;
        int nenner = 0;
        while(true){
            System.out.println("zähler und nenner eingeben: ");
            zähler = new Scanner(System.in).nextInt();
            nenner = new Scanner(System.in).nextInt();
            if (nenner==0) return;
            System.out.println(zähler/nenner);
        }
    }
    
}
