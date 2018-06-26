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
public class Kuh extends Tier implements Nutztier {
    
    private String farbe;
    private String nutzen = "Kuh";

    public Kuh(String farbe, String gattung, String bewegung, String toene, String vorname, String ichBin) {
        super(gattung, bewegung, toene, vorname, ichBin);
        this.farbe = farbe;
        nutzen = vorname.equals("Milka")? "sie schmeckt" : "gibt Milch";
    }

    

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    @Override
    public String toString() {
        return super.toString()+" Kuh{" + "farbe=" + farbe + ", nutzen=" + nutzen + '}';
    }
    
    
    
    
}
