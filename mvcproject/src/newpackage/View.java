/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Map;


public class View {
    
    private Map<Long, Service> map;

   
    public void setMap(Map<Long, Service> map) {
        this.map = map;
    }
    
    public void printMap(){
        map.entrySet().forEach(i->{
            System.out.println(i.getKey()+" = "+i.getValue().getName()+" "+i.getValue().getQuantity()+" "+i.getValue().getPrice());
        });
    }
    
    public void mainMenu(){
        Helper.print("------HauptMenü------");
        Helper.print("");
        Helper.print("1. Create");
        Helper.print("2. Update");
        Helper.print("3. Delete");
        Helper.print("4. Find");
        Helper.print("5. Refresh");
        Helper.print("6. Exit");
        
        Helper.print("");
        Helper.print("Bitte wählen:");
    }
    
    public void secondMenu(){
        Helper.print("------UpdateMenü------");
        Helper.print("");
        Helper.print("1. ID");
        Helper.print("2. Name");
        Helper.print("3. Quantity");
        Helper.print("4. Price");
        Helper.print("5. Exit");
        Helper.print("");
        Helper.print("Bitte wählen:");
    }
    
    public void good(){
        Helper.print("Erfolgreich erledigt!");
    }
    
    public void notGood(){
        Helper.print("Wurde nicht erledigt!");
    }
    
    public void inWork(){
        Helper.print("Noch in Arbeit");
    }
    
}
