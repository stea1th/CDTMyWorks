/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarush1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class ListeFuellen {

    public static void listeFuellen(List list) {
        System.out.println("Ich lege x0 bis x9 an: ");
        IntStream.rangeClosed(0, 9)
                .forEach(i -> list.add("x" + i));
        //list.forEach(System.out::println);
        listAusgeben(list);

    }

    public static void elementLoeschen(List list, String s) {
        System.out.printf("Ich versuche Element %s zu löschen\n", s);
        if (list.contains(s)) {
            list.remove(s);
            System.out.printf("Element %s wurde gelöscht\n", s);
        } else {
            System.out.printf("Element %s ist nicht vorhanden\n", s);
        }
        listAusgeben(list);
    }

    public static void listAusgeben(List list) {
        System.out.println(list.stream()
                .collect(Collectors.joining(", ")));
    }
}
