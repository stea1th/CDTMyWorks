/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vererbung;

import benutzerdefdatentyp.Zeit;

/**
 *
 * @author vvlasov
 */
public class GZTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GenauereZeit gz1 = new GenauereZeit(1, 12, 23, 456);
        GenauereZeit gz2 = new GenauereZeit(2, 51, 41, 700);
        System.out.println(gz1.addiereGenauereZeit(gz2));
        
        Zeit z = new Zeit(1,2,3);
        
        System.out.println("gz1 gleich z?"+gz1.equals(z));
    }

}
