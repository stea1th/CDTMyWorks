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
public class Arbeiter extends Mitarbeiter {

    private double stundenLohn = 0;
    private double geleisteteStunden = 0;

    public Arbeiter(int mitarbeiterNummer,
            String vorName,
            String nachName,
            String abteilung,
            double stundenLohn,
            double geleisteteStunden) {
        
        super(mitarbeiterNummer, vorName, nachName, abteilung);
        this.stundenLohn = stundenLohn;
        this.geleisteteStunden = geleisteteStunden;
    }

    public double getStundenLohn() {
        return stundenLohn;
    }

    public void setStundenLohn(double stundenLohn) {
        this.stundenLohn = stundenLohn;
    }

    public double getGeleisteteStunden() {
        return geleisteteStunden;
    }

    public void setGeleisteteStunden(double geleisteteStunden) {
        this.geleisteteStunden = geleisteteStunden;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Monatsgehalt: %10.2f | Stundenlohn: %6.2f | Stunden: %5.2f | ", 
                getMonatsLohn(), stundenLohn, geleisteteStunden);
    }

    public double getMonatsLohn() {
        return getGeleisteteStunden() * getStundenLohn();
    }
}
