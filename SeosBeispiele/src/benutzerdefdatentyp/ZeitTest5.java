/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benutzerdefdatentyp;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author vvlasov
 */
public class ZeitTest5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zeit[] za = {new Zeit(5, 30, 10), new Zeit(3, 33, 5), new Zeit(4, 44, 44), new Zeit(7, 1, 2), new Zeit()};
        System.out.println("Array vorher:");
        for (Zeit z : za) {
            z.println();
        }
        
        Zeit temp;
        for (int i = 1; i < za.length; i++) {
            if (za[i].compareTo(za[i - 1]) < 0) {
                temp = za[i];
                za[i] = za[i - 1];
                za[i - 1] = temp;
                if (i > 1) {
                    i -= 2;
                }
            }
        }
        
        System.out.println("Array nachher:");
        for (Zeit z : za) {
            z.println();
        }
    }

}
