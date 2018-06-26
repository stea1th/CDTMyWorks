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
public class Mitarbeiter {

    private int mitarbeiterNummer;
    private String vorName;
    private String nachName;
    private String abteilung;
    private int restUrlaub;

    public Mitarbeiter(int mitarbeiterNummer, String vorName, String nachName, String abteilung) {
        this.mitarbeiterNummer = mitarbeiterNummer;
        this.vorName = vorName;
        this.nachName = nachName;
        this.abteilung = abteilung;
        restUrlaub = 30;
    }

    public int getRestUrlaub() {
        return restUrlaub;
    }

    public boolean urlaub(int tage) {
        if (tage > restUrlaub) {
            return false;
        } else {
            restUrlaub -= tage;
            return true;
        }
    }

    public int getMitarbeiterNummer() {
        return mitarbeiterNummer;
    }

    public void setMitarbeiterNummer(int mitarbeiterNummer) {
        this.mitarbeiterNummer = mitarbeiterNummer;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    @Override
    public String toString() {
        return String.format("Mitarbeiter: %06d | Vorname: %10s | Nachname: %10s | Abteilung: %2s | Urlaub: %2d | ",
                 mitarbeiterNummer, vorName, nachName, abteilung, restUrlaub);
    }

    public void displayln() {
        System.out.print(this);
        System.out.println();
    }

}
