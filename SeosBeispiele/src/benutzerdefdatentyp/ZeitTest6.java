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
public class ZeitTest6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Start der main-Methode ...");
        Zeit z;
        System.out.println("Aktueller Wert "+ Zeit.getFormat());
        System.out.println("Vor dem Erzeugen von Zeit-Objekten ...");
        Zeit[]arr = {new Zeit(), new Zeit(1,2,3), new Zeit(16, 15, 0)};
        System.out.println("Nach dem Erzeugen von Zeit-Objekten...");
        
        for(Zeit x : arr){
            x.println();
        }
        Zeit.setFormat(2);
        for(Zeit x : arr){
            x.println();
        }
        
        arr = null; //Wirkung: die Adressen der Zeit-Objekte
                    //sind nicht mehr zugreifbar
               
        
    }
    
}
