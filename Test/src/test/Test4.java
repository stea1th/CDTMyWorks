/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;

/**
 *
 * @author vvlasov
 */
public class Test4 {

    static HashMap<String, String> sprache;
    public static void main(String[] args) {
        HashMap<String, String> deutsch = new HashMap<>();
        HashMap<String, String> englisch = new HashMap<>();
        //System.out.println(System.getProperty("user.language"));
        deutsch.put("hmenu", "Menü");
        deutsch.put("eeingabe", "Eingabe");
        deutsch.put("aausgabe", "Ausgabe");
        
        englisch.put("hmenu", "Main menu");
        englisch.put("eeingabe", "Input");
        englisch.put("aausgabe", "Output");
        
        /*if(System.getProperty("user.language").equals("en")){
            sprache = englisch;
        }else if(System.getProperty("user.language").equals("de")){
            sprache = deutsch;
        }*/
        
        switch(System.getProperty("user.language")){
            case "de" :
                sprache = deutsch;
                break;
            case "en" :
                sprache = englisch;
                break;
        }
        sprache.entrySet()
                .stream()
                .forEach(i-> System.out.println(i.getKey()+" = "+i.getValue()));
    }
    
}
