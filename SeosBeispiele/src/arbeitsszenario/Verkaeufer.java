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
public class Verkaeufer extends Arbeiter {

    private double umsatz = 0;
    private double provSatz = 0;

    public Verkaeufer(int mitarbeiterNummer,
            String vorName,
            String nachName,
            String abteilung,
            double stundenLohn,
            double geleisteteStunden,
            double umsatz,
            double provSatz) {
        
        super(mitarbeiterNummer, vorName, nachName, abteilung,stundenLohn, geleisteteStunden);
        this.umsatz = umsatz;
        this.provSatz = provSatz / 100;
    }

    public double getUmsatz() {
        return umsatz;
    }

    public void setUmsatz(double umsatz) {
        this.umsatz = umsatz;
    }

    public double getProvSatz() {
        return provSatz;
    }

    public void setProvSatz(double provSatz) {
        this.provSatz = provSatz / 100;
    }

    @Override
    public double getMonatsLohn() {
        return super.getMonatsLohn()
                + umsatz * provSatz;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Umsatz: %8.2f | Provsatz: %5.2f%% | ",
                umsatz, provSatz * 100);
    }
}
