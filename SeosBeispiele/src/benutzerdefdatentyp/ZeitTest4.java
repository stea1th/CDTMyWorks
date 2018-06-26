/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benutzerdefdatentyp;

/**
 *
 * @author vvlasov
 */
public class ZeitTest4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zeit z = new Zeit(1, 23, 45);
        z.println();
        Zeit z1 = new Zeit(2, 12, 16);
        z1.println();
        z1.addiereZeit(z).println();
        
    }
    
}
