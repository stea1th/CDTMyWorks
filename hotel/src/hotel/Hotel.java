/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vvlasov
 */
public class Hotel {

    private final static LinkedList<Etagen> LIST = new LinkedList<>();
    private static int wahl;
    private static Etagen etage;

    static {
        LIST.add(new Etagen(-2, "Sauna- und Swimmingpool"));
        LIST.add(new Etagen(-1, "Fitnesskeller"));
        LIST.add(new Etagen(0, "Empfang"));
        LIST.add(new Etagen(1, "Futtermeile"));
    }

    public static void main(String[] args) throws IOException {
        /*try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            wahl = Integer.parseInt(reader.readLine());
        }
        etage = LIST.stream()
                .filter(i -> i.getStockwerk() == wahl)
                .findAny()
                .orElse(null);
        System.out.println(etage != null? etage : "Nicht vorhanden");*/
        
        LIST.addFirst(new Etagen(-3, "Geheime Räume"));
        
        LIST.forEach(System.out::println);
        System.out.println("Anzahl Etagen: "+LIST.size());
    }
}
