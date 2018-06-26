/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author vvlasov
 */
public class ArrayList_Bsp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //String[] arr = {"a", "b", "c", "d", "e", "f"};
        //List<String> list = Arrays.asList(arr);
        List<String> list = Stream.of("Vlasav", "Labidi", "Hahn", "Scaratti", "Bozhedomov", "Lynen")
                .collect(Collectors.toList());
        System.out.println("-------------------------------");

        list.stream()
                .iterator()
                .forEachRemaining(System.out::println);
        /*list.stream()
                .skip(1)
                .limit(1)
                .forEach(System.out::println);*/
        System.out.println("-------------------------------");
        list.add(new Scanner(System.in).nextLine());

        list.add(4, "Kirichenko");
        System.out.println("-------------------------------");

        System.out.println(list.contains("Vlasov") ? "Ja, er ist da" : "Nein, er ist nicht da");
        System.out.println("-------------------------------");

        list.stream()
                .iterator()
                .forEachRemaining(System.out::println);
        System.out.println("-------------------------------");
        list.set(0, "Vlasov");
        list.remove("Lynen");
        list.sort(Comparator.naturalOrder());

        list.stream()
                .iterator()
                .forEachRemaining(System.out::println);

        System.out.println("-------------------------------");

        list.sort(Comparator.reverseOrder());

        ListIterator<String> iter = list.listIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        ListIterator<String> iter2 = list.listIterator(list.size()-1);
        while(iter2.hasPrevious()){
            System.out.println(iter2.next());
        }

        System.out.println("-------------------------------");
        System.out.println(list.get(2));
        System.out.println("-------------------------------");

        System.out.println(list.stream()
                .filter(i -> i == "Labudi")
                .findFirst()
                .orElse("Nicht vorhanden"));
        System.out.println("-------------------------------");

        /*ListIterator<String> iter = list.listIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }*/
        System.out.println(list.stream()
                .collect(Collectors.joining(", ")));
    }

}
