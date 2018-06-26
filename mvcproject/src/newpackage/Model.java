/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vvlasov
 */
public class Model {

    private Map<Long, Service> map;
    private final String DBFILE;
   

    public Model() {
        map = new TreeMap();
        DBFILE = "C:\\Users\\vvlasov\\Desktop\\DatenBank\\1.txt";
//        Service x1 = new Service(12, "HP Notebook", 45, 1200.99);
//        Service x2 = new Service(34, "Dell Notebook", 2, 1499.99);
//        map.put(x1.getId(), x1);
//        map.put(x2.getId(), x2);
        
    }

    public void serialize() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DBFILE))) {
            oos.writeObject(map);
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Map<Long, Service> deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DBFILE))) {
            map = (Map<Long, Service>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    public boolean createEntity(Service service){
        if(map.keySet().contains(service.getId())){
            return false;
        }else{
            map.put(service.getId(), service);
            return true;
        }
    }

    public Map<Long, Service> getMap() {
        return map;
    }

    public String getDbFile() {
        return DBFILE;
    }
    
    public boolean updateId(long altId, long neuId){
        if(map.containsKey(altId)){
            Service s = map.get(altId);
            s.setId(neuId);
            map.remove(altId);
            map.put(s.getId(), s);
            return true;
        }
        return false;
    }
    
    public boolean updateName(long id, String name){
        if(map.containsKey(id)){
            Service s = map.get(id);
            s.setName(name);
            map.put(s.getId(), s);
            return true;
        }
        return false;
    }
    
    public boolean updateQuantity(long id, int quant){
        if(map.containsKey(id)){
            Service s = map.get(id);
            s.setQuantity(quant);
            map.put(s.getId(), s);
            return true;
        }
        return false;
    }
    
    public boolean deleteEntity(long id){
        if(map.containsKey(id)){
            map.remove(id);
            return true;
        }
        return false;
    }
    
    public boolean updatePrice(long id, double price){
        if(map.containsKey(id)){
            Service s = map.get(id);
            s.setPrice(price);
            map.put(s.getId(), s);
            return true;
        }
        return false;
    }
}
