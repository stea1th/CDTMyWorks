/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benutzerdefdatentyp;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author vvlasov
 */
public class ZeitTest0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zeit[] zarr = new Zeit[3];
        Zeit z1 = new Zeit();
        System.out.println(z1);
        zarr[0] = new Zeit();
        zarr[1] = z1;
        zarr[2] = zarr[0];
        Stream.of(zarr)
                .forEach(System.out::println);
        z1.setHour(24);
                
        z1.setMinute(62);
        
        
        //System.out.println("Stunden in "+zarr[0].hour);
        
        
    }
    
}
