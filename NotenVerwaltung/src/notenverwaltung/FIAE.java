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
public class FIAE extends Fach {
    
    

    public FIAE() {
        assessment.put("Java", 0);
        assessment.put("Java2", 0);
        assessment.put("Server", 0);
    }

    @Override
    public void getAverageAssessment() {
        ConsoleHelper.println("--------------------------");
        ConsoleHelper.println("Durchschnitt: " + assessment.values()
                .stream()
                .mapToInt(i -> (int) i)
                .average()
                .getAsDouble());
    }

    @Override
    public Map<String, Integer> getAssessment() {
        return assessment;
    }

}
