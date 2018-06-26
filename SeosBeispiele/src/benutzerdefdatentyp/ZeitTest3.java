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
public class ZeitTest3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Zeit z = new Zeit(20, 10, 5);
        z.addSec(4000);
        z.println();
    }
    
}
