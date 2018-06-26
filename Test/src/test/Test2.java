/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author vvlasov
 */
public class Test2 {

    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Pupkin", "Vasia");
        map.put("Pupkin", "Petia");
        map.put("Green", "Lionia");
        map.put("Bozhe", "Boria");
        map.put("Kirich", "Genna");
        map.put("Gosia", "Vasia");
        map.put("Vlasov", "Andrey");
        map.put("Hulio", "Vasia");
        map.put("Wenk", "Vasia");
        map.put("Göring", "Gabi");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        /*return (int) map.values().stream()
                .filter(s -> s.equals(name))
                .count();*/
        int x = 0;
        for(String s : map.values()){
            if(s.equals(name))
                x++;
        }
        return x;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        /*return (int) map.keySet().stream()
                .filter(s -> s.equals(lastName))
                .count();*/
        int x = 0;
        for(String s : map.keySet()){
            if(s.equals(lastName))
                x++;
        }
        return x;

    }

    public static void main(String[] args) {

    }
}
