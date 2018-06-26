/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarush1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vvlasov
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Нам повторы не нужны
 */
public class Solution {

    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int x = 0;
            if (i % 2 == 0) {
                x = i / 2;
            }
            map.put("Vlasov" + i, "Vadim" + x);
        }
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        /*Map<String, Integer> count = map.values().stream()
                .collect(HashMap::new, (m, c) -> m.put(c, m.containsKey(c) ? (m.get(c) + 1) : 1), HashMap::putAll);
        
        count.entrySet().stream()
                .filter(i -> i.getValue() > 1)
                .forEach(i -> removeItemFromMapByValue(map, i.getKey()));*/
        //map.forEach((k, v)-> System.out.println(k+" -> "+v));
        List<String> list = map.values().stream().collect(Collectors.toList());
        for(String s : list){
            if(Collections.frequency(list, s)> 1){
                removeItemFromMapByValue(map, s);
            }
        }
        map.forEach((k, v)-> System.out.println(k+" -> "+v));
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        //HashMap<String, String> map = createMap();
        //map.forEach((k, v) -> System.out.println(k + " " + v));
        removeTheFirstNameDuplicates(createMap());
    }
}
