/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbeitsszenario;

/**
 *
 * @author vvlasov
 */
public class PersonalTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Verkaeufer v1 = new Verkaeufer(3333, "Rudi", "Ratlos", "XYZ", 8.84, 160, 5600, 12);
        
        Angestellter a = new Angestellter(1222, "Gabi", "Peterson", "ABC", 3500);
        
        v1.displayln();
        a.displayln();
        Mitarbeiter m;
        m = a;
        m.displayln();
        Verkaeufer v2 = (Verkaeufer) m;
        v2.displayln();
    }
    
}
