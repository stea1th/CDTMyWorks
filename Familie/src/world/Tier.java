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
public class Tier extends Lebewesen {
    private String gattung;

    public Tier(String gattung, String bewegung, String toene, String vorname, String ichBin) {
        super(bewegung, toene, vorname, ichBin);
        this.gattung = gattung;
    }

    public String getGattung() {
        return gattung;
    }

    public void setGattung(String gattung) {
        this.gattung = gattung;
    }

    @Override
    public String toString() {
        return "Tier{" + "gattung=" + gattung + '}';
    }
    
    
}
