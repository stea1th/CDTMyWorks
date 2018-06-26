/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author vvlasov
 */
public class JavaApplication5 {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static{
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args)throws IOException {
        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "C:\\Users\\vvlasov\\Desktop\\"+reader.readLine()+".txt";
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while(fileReader.ready()){
            list.add(fileReader.readLine());
        }
        fileReader.close();
        Pattern pattern= Pattern.compile("\\b[0-9]?[0-9]\\b");
        for (String line : list){
            Matcher matcher = pattern.matcher(line);
            while(matcher.find()){
                int x = Integer.parseInt(matcher.group());
                if (map.containsKey(x)){
                    line=line.replace(matcher.group(),map.get(x));
                }
            }
            System.out.println(line);
        }

    }
}

    


