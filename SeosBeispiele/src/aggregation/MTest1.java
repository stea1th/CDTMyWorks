/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aggregation;

import benutzerdefdatentyp.Zeit;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class MTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Marathon[] starterList = new Marathon[5];
        int startNr = 1001;
        starterList[0] = new Marathon(startNr++, "Huber");
        starterList[1] = new Marathon(startNr++, "Fritz");
        starterList[2] = new Marathon(startNr++, "Sebastian");
        starterList[3] = new Marathon(startNr++, "Sabine");
        starterList[4] = new Marathon(startNr++, "Eva");

        System.out.println("Starterliste:");
        Arrays.stream(starterList).forEach(System.out::println);

        Zeit[] zeiten = {new Zeit(6, 20, 12), new Zeit(4, 44, 4),
            new Zeit(5, 1, 33), new Zeit(2, 1, 55), new Zeit(3, 5, 2)};

        System.out.println("Starterliste mit Laufzeit:");
        IntStream.range(0, starterList.length)
                .map(i -> {
                    starterList[i].setZeit(zeiten[i]);
                    return i;
                })
                .forEach(i -> System.out.println(starterList[i]));
        System.out.printf("Sieger ist: %s\n", sieger(starterList));
    }
    
    private static Marathon sieger(Marathon[] m){
        
        return Arrays.stream(m)
                .min(Marathon::compareTo).get();
    }
}
