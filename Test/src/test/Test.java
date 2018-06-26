/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.Thread.State;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javafx.scene.control.TextArea;

/**
 *
 * @author vvlasov
 */
public class Test {

    public static final String ANSI_GREEN = "\u001B[32m";
    int y = 1;

    public static void main(String[] args) throws IOException {
        /*StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();

        int x = 49;
        int y = (x - 1) / 2;
        int y1 = 3;
        int z = 1;
        int a = 3;
        String stamm = "";

        while (y1 < y / 2) {
            for (int i = 0; i < y1; i++) {
                for (int j = 0; j < y; j++) {
                    builder.append(" ");
                }
                for (int j = 0; j < z; j++) {
                    builder.append("x");
                    if (z == 3) {
                        stamm = builder.toString();
                    }
                }
                z += 2;

                String line = builder.toString();
                builder.delete(0, builder.length());
                //System.out.println(line);
                //list.add(line);
                list.add(line);
                y--;

            }

            if (y1 == 3) {
                list.stream()
                        //.skip()
                        .forEach((s) -> System.out.println(ANSI_GREEN + s));
            } else {
                list.stream()
                        .skip(1)
                        .limit(a)
                        .forEach((s) -> System.out.println(ANSI_GREEN + s));
            }
            a++;
            y1++;
        }*/

 /*Collections.reverse(list);
        list.stream()
                .skip(1)
                .limit(list.size() - 2)
                .forEach(System.out::println);*/
 /*for (int i = 0; i < 3; i++) {
            System.out.println(stamm);

        }*/

 /*int x = 3;
        for (int i = 0; i < 4; i++) {
            int y = 5;
            x+=y;
            
        }
        System.out.println(x);*/
 /*try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Geben Sie die Name ein: ");
            String name = scanner.nextLine();
            name = name.replace(name.charAt(0), Character.toUpperCase(name.charAt(0)));
            System.out.println("Geben Sie m, w oder f ein: ");
            String sex = scanner.nextLine();
            String anrede = "Sehr geehrte";

            switch (sex) {
                case "w":
                    System.out.printf("%s Frau %s\n", anrede, name);
                    break;
                case "m":
                    System.out.printf("%sr Herr %s\n", anrede, name);
                    break;
                case "f":
                    System.out.printf("%s Damen und Herren aus Firma %s\n", anrede, name);
                    break;
                default:
                    System.out.println("Briefanrede unbekannt");
            }
        }*/
 /*List<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                list.add(scanner.nextInt());
                if (list.get(list.size() - 1) == 0) {
                    list.remove(list.size() - 1);
                    break;
                }
            }
            int sum = list.stream()
                    .map(String::valueOf)
                    .mapToInt((s) -> Integer.parseInt(s))
                    .sum();
            Optional<Integer> max = list.stream()
                    .max((s1, s2) -> s1 - s2);
            Optional<Integer> min = list.stream()
                    .min((s1, s2) -> s1 - s2);
            System.out.println(list.stream()
                    .map(String::valueOf)
                    .reduce((s1, s2) -> s1 + " " + s2));
            long gerade = list.stream()
                    .filter((i) -> i % 2 == 0)
                    .count();
            long ungerade = list.stream()
                    .filter((i) -> i % 2 != 0)
                    .count();
            int total = list.size();

            System.out.printf("Summe - %d, Max - %d, Min - %d\n", sum, max.get(), min.get());
            System.out.println(String.format("Gerade Zahlen - %d, Ungerade Zahlen - %d, Totaleingaben - %d", gerade, ungerade, total));

        }
        /* try (Scanner scanner = new Scanner(System.in)) {
            int zahl = scanner.nextInt();
            int sum = 0;

            while (true) {
                while (zahl > 0) {
                    sum += zahl % 10;
                    zahl /= 10;
                }

                if (sum > 9) {
                    zahl = sum;
                    sum = 0;
                } else {
                    break;
                }
            }
            System.out.printf("Quersumme - %d\n", sum);
        }*/
 /*int i = new Scanner(System.in).nextInt();

        int zahl = 1;
        for (; i > 0; i--) {
            zahl *= i;

        }
        System.out.println(ANSI_GREEN + zahl);
        System.out.println(Integer.MAX_VALUE);*/
 /*int a = 7;
        int b = 12;
        int c = -34;
        int d = 19;
        int f;
        f=++d%--a +3*d++/(++c+37)*++b;
        System.out.println(a+" "+b+" "+c+" "+d);
        System.out.println(f);
        
        for(;true;){
            System.out.println("x");
        }
        
        //System.out.println("Kruk "+ ((17%5)*(15/4)));*/
 /*int a = 1;
        int b = 3;
        int c = 0;
        while (c < 10) {
            a = a+ ++b + ++c;
            ++b;
            c++;
            System.out.println(a + " " + b + " " + c);
        }
        System.out.println(a + " " + b + " " + c);*/
 /*String t;
        String w = "";
        String s;
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        t = scanner.next();
        for (int i = 0; i < 5; i++) {
            w=w+t;
            
        }
        System.out.printf("\nw= "+w);
        System.out.println("");*/
        int[] x; //= new int[5];
        Test test = new Test();
        Scanner scanner = new Scanner(System.in);
        x = IntStream.iterate(5, (i) -> i+5)
                .limit(4)
                .toArray();
        Arrays.stream(x)
                .forEach((i)-> {
                    System.out.println("i: " +i);
                });
        
        
        //int y = 1;
        /*IntStream.range(0, x.length)
                .forEach((i) -> {
                    x[i] = scanner.nextInt(); //test.getY();   //(int) (Math.random()*5+1);
                    
                });*/
        
        
        /*IntStream.range(0, x.length)
                .map((i)-> i+5)
                .forEach(System.out::println);*/
        /*System.out.println("--------------------------------------");
        Arrays.stream(x).forEach(System.out::print);*/
        

    }

    public int getY() {
        return y++;
    }

}
