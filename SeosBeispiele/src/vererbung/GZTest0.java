/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vererbung;

import benutzerdefdatentyp.Zeit;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author vvlasov
 */
public class GZTest0 {
    List smallFiles = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GenauereZeit gz = new GenauereZeit();
        System.out.println(gz);
        Zeit z = new GenauereZeit(1, 61, 3, 15);
        Zeit.setFormat(2);
        z.print();
        Zeit z2 = new Zeit();
        z2.println();
        
    }
    
    /*public void sort(){
        smallFiles.sort((File o1, File o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }*/
}
