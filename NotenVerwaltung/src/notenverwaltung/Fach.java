/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notenverwaltung;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vvlasov
 */
public abstract class Fach {

    Map<String, Integer> assessment = new HashMap<>();

    public abstract void getAverageAssessment();

    public Map<String, Integer> getAssessment() {
        return assessment;
    }
    
    
}
