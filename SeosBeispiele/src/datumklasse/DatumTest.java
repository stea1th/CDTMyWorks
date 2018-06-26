/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datumklasse;

/**
 *
 * @author vvlasov
 */
public class DatumTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Datum d = new Datum();
        Datum d1 = new Datum(d);
        d.addierenTage(3, true);
        d.bekommenTagDerWoche();
        d.println();
        System.out.println("Tagesdifferenz: "+ d.differenz(d1));*/
        
        /*Datum d1 = new Datum(18, 3, 1920);
        d1.bekommenTagDerWoche();
        d1.println();
        d1.addierenTage(2);
        d1.bekommenTagDerWoche();
        d1.println();
        Datum d2 = d1.addierenTage(4);
        d2.println();*/
        /*Datum d = new Datum(12, 12, 1900);
        d.println();
        d.setMonat(13);
        d.println();*/
        /*Datum d = new Datum(29, 2, 2016);
        d.datumInsTage();
        d.addierenTage(366, true);*/
        //d.setJahr(2017);
        //d.println();
        /*Datum d1 = d.addierenTage(365, false);
        d.addierenTage(5, true);
        d.println();
        d1.println();
        //System.out.println(d.datumInsTage());
        //System.out.println(d1.datumInsTage());
        System.out.println(d1.differenz(d));*/
        
        Datum d = new Datum(21,2,1979);
        d.bekommenTagDerWoche();
        d.println();
        System.out.println(new Datum().differenz(new Datum(3,3,1982)));
        
        
        
        
    }
    
}
