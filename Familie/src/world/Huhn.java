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
public class Huhn extends Tier implements Nutztier {
    private String haltung;
    private String nutzen;

    public Huhn(String haltung, String nutzen, String gattung, String bewegung, String toene, String vorname, String ichBin) {
        super(gattung, bewegung, toene, vorname, ichBin);
        this.haltung = haltung;
        this.nutzen = nutzen;
    }

    public String getHaltung() {
        return haltung;
    }

    public void setHaltung(String haltung) {
        this.haltung = haltung;
    }

    public String getNutzen() {
        return nutzen;
    }

    public void setNutzen(String nutzen) {
        this.nutzen = nutzen;
    }

    @Override
    public String toString() {
        return "Huhn{" + "haltung=" + haltung + ", nutzen=" + nutzen + '}';
    }
    
    
    
}
