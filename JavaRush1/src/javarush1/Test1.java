/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarush1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vvlasov
 */
public class Test1 {
    
    private static List<String> list = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListeFuellen.listeFuellen(list);
        ListeFuellen.elementLoeschen(list, "x5");
    }
    
}
