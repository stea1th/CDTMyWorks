/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class Test8 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    private static List<String> list; //= new ArrayList<>();

    public static void main(String[] args) throws IOException {

        try (LineNumberReader reader = new LineNumberReader(new FileReader("C:\\Users\\vvlasov\\Desktop\\DieMade.txt"))) {
            list = reader.lines().collect(Collectors.toList());
        }
        //list.forEach(System.out::println);
        try (BufferedReader reader = new BufferedReader(new FileReader(("C:\\Users\\vvlasov\\Desktop\\DieMade.txt")))) {
            int i = 0;
            while (reader.ready()) {
                list.add(i++ + ": " + reader.readLine());
            }
        }
        menu();
    }

    public static void menu() {
        System.out.println("1. Alles ausgeben");
        System.out.println("2. Ab x Zeile ausgeben");
        System.out.println("3. Eine bestimmte Zeile ausgeben");
        System.out.println("6. Exit");
        while (true) {
            switchMenu();
        }
    }

    private static void switchMenu() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                printAll();
                break;
            case 2:
                printAllSelectedLines(scanner.nextInt() - 1);
                break;
            case 3:
                printLine(scanner.nextInt() - 1);
                break;
            case 6:
                System.exit(0);
                break;
        }
    }

    private static void printAll() {
        list.forEach(System.out::println);
    }

    private static void printLine(int line) {
        try {
            System.out.println(list.get(line));
        } catch (Exception e) {
            System.out.println("Nummer existiert nicht");
        }
    }

    private static void printAllSelectedLines(int line) {
        try {
            list.stream().skip(line)
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Nummer existiert nicht");
        }
    }

}
