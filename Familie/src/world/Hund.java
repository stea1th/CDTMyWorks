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
public class Hund extends Tier {
    private int steuernummer;

    public Hund(int steuernummer, String gattung, String bewegung, String toene, String vorname, String ichBin) {
        super(gattung, bewegung, toene, vorname, ichBin);
        this.steuernummer = steuernummer;
    }

    public int getSteuernummer() {
        return steuernummer;
    }

    public void setSteuernummer(int steuernummer) {
        this.steuernummer = steuernummer;
    }

    @Override
    public String toString() {
        return "Hund{" + "steuernummer=" + steuernummer + '}';
    }
    
    
    
    
    
    
}
