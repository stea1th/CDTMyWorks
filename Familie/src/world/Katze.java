/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

/**
 *
 * @author vvlasov
 */
public class Katze extends Tier {
    
    private String lebensart;

    public Katze(String lebensart, String gattung, String bewegung, String toene, String vorname, String ichBin) {
        super(gattung, bewegung, toene, vorname, ichBin);
        this.lebensart = lebensart;
    }
    
    public String getLebensart() {
        return lebensart;
    }

    public void setLebensart(String lebensart) {
        this.lebensart = lebensart;
    }

    @Override
    public String toString() {
        return "Katze{" + "lebensart=" + lebensart + '}';
    }
    
    
    
    
}
