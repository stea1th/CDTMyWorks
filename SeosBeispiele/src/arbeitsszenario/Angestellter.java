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
public class Angestellter extends Mitarbeiter {
    
    private double monatsGehalt = 0;

   public Angestellter(int mitarbeiterNummer, 
           String vorName, 
           String nachName, 
           String abteilung, 
           double monatsGehalt) {
        
       super(mitarbeiterNummer, vorName, nachName, abteilung);
        this.monatsGehalt = monatsGehalt;
    }

    public double getMonatsGehalt() {
        return monatsGehalt;
    }

    public void setMonatsGehalt(double monatsGehalt) {
        this.monatsGehalt = monatsGehalt;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("Monatsgehalt: %10.2f | ", monatsGehalt);
    }
}
