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
public class PersonalTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new Mitarbeiter(4367, "Vadim", "Vlasov", "IT").displayln();
        //new Arbeiter(4367, "Vadim", "Vlasov", "IT").displayln();
        Mitarbeiter m1 = new Mitarbeiter(320, "Frank", "Meyer", "BH");
        m1.displayln();
        Angestellter m = new Angestellter(4367, "Vadim", "Vlasov", "IT", 3500);
        m.displayln();
        m.urlaub(12);
        m.displayln();
        Arbeiter a = new Arbeiter(9234, "Gabi", "König", "VK", 9.5, 120);
        a.displayln();
        Verkaeufer v = new Verkaeufer(7456, "Boris", "Bozhedomov", "VK", 8.84, 160, 3500.45, 12);
        v.displayln();
        //v.setStundenLohn(8.84);
        //v.setGeleisteteStunden(160);
        v.urlaub(28);
        v.setUmsatz(5680.57);
        v.setProvSatz(10);
        v.displayln();
        v.setUmsatz(0);
        v.displayln();
        v.urlaub(28);
        v.displayln();
    }

}
