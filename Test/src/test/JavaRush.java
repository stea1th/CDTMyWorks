/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/* 
Нити и байты
 */
public class JavaRush {

    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws InterruptedException {
       
        getResult();
        resultMap.entrySet()
                .forEach(i -> System.out.println(i.getKey() + " " + Character.getName(i.getValue())));

    }

    public static void getResult() throws InterruptedException {
         try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String fileName = scanner.nextLine();
                if (fileName.equalsIgnoreCase("exit")) {
                    break;
                }
                ReadThread readThread = new ReadThread(fileName);
                readThread.start();
                readThread.join();
            }
        }
    }

    public static class ReadThread extends Thread {

        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
            
        }

        @Override
        public void run() {
            try {
                String line = new String(Files.readAllBytes(Paths.get(fileName)));
                char[] arr = line.toCharArray();
                int max = 0;
                for (int i = 0; i < arr.length; i++) {
                    int result = Math.abs(line.replace(Character.toString(arr[i]), "").length() - line.length());
                    if (result > max) {
                        max = result;
                        resultMap.put(fileName, (int) arr[i]);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(JavaRush.class.getName()).log(Level.SEVERE, null, ex);
            }


            //Map<Integer, Integer> map; //= new HashMap<>();
            /*try {
                try (FileInputStream input = new FileInputStream(fileName)) {
                int x;
                while ((x = input.read()) > 0) {
                if (!map.containsKey(x)) {
                map.put(x, 1);
                } else {
                map.replace(x, map.get(x) + 1);
                }
                }
                }*/ //synchronized (resultMap) {
            /*resultMap.put(fileName, map.entrySet()
                        .stream()
                        .filter(i -> i.getValue() == map.values()
                        .stream()
                        .mapToInt(Integer::valueOf)
                        .max().getAsInt())
                        .findFirst().get().getKey());*/
            //}

            //} catch (IOException e) {
            //}
        }
    }
}
