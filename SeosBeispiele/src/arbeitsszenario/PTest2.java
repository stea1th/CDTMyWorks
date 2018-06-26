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
public class PTest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mitarbeiter[] arr = new Mitarbeiter[4];
        arr[0] = new Verkaeufer(3333, "Rudi", "Ratlos", "XYZ", 8.84, 160, 5600, 12);
        arr[1] = new Angestellter(1222, "Gabi", "Peterson", "ABC", 3500);
        arr[2] = new Mitarbeiter(2345, "Genna", "Kirich", "XYZ");
        arr[3] = new Arbeiter(6573, "Boria", "Bozhedomov", "FDG", 12.43, 165);
        
        for(Mitarbeiter m  : arr){
            System.out.println(m);
        }
    }
    
}
