/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontotest;

/**
 *
 * @author vvlasov
 */
public class KontoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Konto.setSollZins(12.5);
        Konto.setHabenZins(5.1);
        Konto konto = new Konto(1234234, "Vadim", 123456.56);
        //System.out.printf("Zinsen: \t%10.2f\n", konto.getZinsen());
        konto.setDispo(5000);
        konto.abheben(28000);
        //System.out.printf("Zinsen: \t%10.2f\n", konto.getZinsen());
        konto.einzahlen(2500);
        konto.einzahlen(5000);
        
        
        
    }
    
}
