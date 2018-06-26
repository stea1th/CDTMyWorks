/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeichen;

import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class Beispiel2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int z = ' ';
        
        //System.out.printf("%c %04X %3d\n", z, z, z);
        
        IntStream.rangeClosed(z, 127)
                .forEach(i->{
                    System.out.printf("%c %04X %3d\n", i, i, i);
                });
    }
    
}
