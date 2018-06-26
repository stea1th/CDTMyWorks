/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aggregation;

import benutzerdefdatentyp.Zeit;

/**
 *
 * @author vvlasov
 */
public class MTest0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Marathon m1;
        Marathon m2 = new Marathon();
        Zeit z = new Zeit();
        m2.setZeit(z);
        
        m1 = new Marathon(1111, "Huber", new Zeit());
    }
    
}
