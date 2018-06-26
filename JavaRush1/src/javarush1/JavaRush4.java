/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarush1;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;



/**
 *
 * @author vvlasov
 */
public class JavaRush4 {

    
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        for (int i = 0; i < 8; i++) {
            map.put("Vadia" + i, new Date("MARCH 15 1982"));
        }
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        /*List<String> list = map.entrySet().stream()
                .filter(i -> (i.getValue().getMonth() > 4)&&(i.getValue().getMonth() < 8))
                .map(i-> i.getKey())
                .collect(Collectors.toList());
        list.forEach(map::remove);*/
        map.entrySet().removeIf(i->(i.getValue().getMonth() > 4)&&(i.getValue().getMonth() < 8));
        
        /*for(Map.Entry<String, Date> entry : map.entrySet()){
            if(entry.getValue().getMonth()> 4 && entry.getValue().getMonth()< 8){
                map.remove(entry.getKey());
            }
        }*/

    }

    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        map.forEach((k, v)-> System.out.println(k+" "+v));
        

    }
}
