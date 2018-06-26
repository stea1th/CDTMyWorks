/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notenverwaltung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author vvlasov
 */
public class MenuManager {

    private final static List<String> LIST = new ArrayList<>();
    private static Map<User, Fach> userMap = new HashMap<>();

    static {
        LIST.add("Bitte User einlegen: ");
        LIST.add("Usern auflisten: ");
        LIST.add("Noten eingeben: ");
        //LIST.add("Noten korrigieren: ");
        LIST.add("User löschen: ");
        LIST.add("Programm beenden: ");
    }

    private static void printMenu() {
        ConsoleHelper.println("*********** MENÜ ***********");
        for (int i = 0; i < LIST.size(); i++) {
            ConsoleHelper.println(String.format("%d.  %s", i + 1, LIST.get(i)));
        }
    }

    public static void menu() {
        printMenu();
        switch (ConsoleHelper.readInt()) {
            case 1:
                addUser();
                break;
            case 2:
                showAllUsers();
                break;
            case 3:
                setAssessments();
                break;
            case 4:
                deleteUser();
                break;
            case 5:
                ConsoleHelper.println("Programme wird beendet...");
                System.exit(0);
                break;
        }
    }

    private static void addUser() {
        User user = new User();
        ConsoleHelper.print("Id eingeben: ");
        user.setId(ConsoleHelper.readInt());
        ConsoleHelper.print("Vorname eingeben: ");
        user.setvName(ConsoleHelper.read());
        ConsoleHelper.print("Nachname eingeben: ");
        user.setnName(ConsoleHelper.read());
        Fach fach = null;
        while (fach == null) {
            ConsoleHelper.print("Fach eingeben: ");
            fach = fachFabrik(ConsoleHelper.read());
            user.setFach(fach);
        }

        userMap.put(user, user.getFach());
        user.getFach().getAverageAssessment();

        //ConsoleHelper.println(user.toString());
    }

    private static void deleteUser() {
        ConsoleHelper.print("Id eingeben: ");
        User user = findUser();
        if (user != null) {
            userMap.remove(user);
            ConsoleHelper.println(String.format("User %d %s wurde erfolgreich gelöscht", user.getId(), user.getnName()));
        } else {
            ConsoleHelper.println("User existiert sowieso nicht");
        }
    }

    private static void setAssessments() {
        ConsoleHelper.print("Id eingeben: ");
        User user = findUser();
        System.out.println(user);
        if (user != null) {
            Map<String, Integer> map = user.getFach().getAssessment();
            getUserLessons(map);
            ConsoleHelper.println("Geben Sie Fach und Note ein: ");
            while (true) {
                String key = ConsoleHelper.read();
                if (key.equalsIgnoreCase("exit")) {
                    break;
                }
                if (map.containsKey(key)) {
                    map.put(key, ConsoleHelper.readInt());
                }
            }
            user.getFach().getAverageAssessment();
        } else {
            ConsoleHelper.println("User existiert nicht!");
        }

    }

    private static User findUser() {
        if (!userMap.isEmpty()) {
            int id = ConsoleHelper.readInt();
            return userMap.keySet().stream()
                    .filter(i -> i.getId() == id)
                    .findAny()
                    .orElse(null);
            
            /*for(Map.Entry<User, Fach> entry : userMap.entrySet()){
                
                if(entry.getKey().getId()== id){
                    return entry.getKey();
                }
            }*/
            
        }
        return null;
    }

    private static void getUserLessons(Map<String, Integer> map) {
        map.keySet().forEach(ConsoleHelper::println);
    }

    private static void showAllUsers() {
        if (!userMap.isEmpty()) {
            userMap.entrySet()
                    .forEach(i -> {
                        ConsoleHelper.println(i.getKey().toString());
                        i.getValue().getAssessment().entrySet().forEach((entry) -> {
                            ConsoleHelper.println(entry.getKey() + " - " + entry.getValue());
                        });
                        i.getKey().getFach().getAverageAssessment();
                        ConsoleHelper.println("--------------------------");
                    });
        } else {
            ConsoleHelper.println("Es gibt noch keine User");
        }

    }

    private static Fach fachFabrik(String s) {
        Fach fach = null;
        switch (s.toUpperCase()) {
            case "FISI":
                fach = new FISI();
                break;
            case "FIAE":
                fach = new FIAE();
                break;
        }
        return fach;
    }

}
