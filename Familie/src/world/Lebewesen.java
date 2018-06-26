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
public class Lebewesen {
    private String bewegung;
    private String toene;
    private String vorname;
    private String ichBin;

    public Lebewesen(String bewegung, String toene, String vorname, String ichBin) {
        this.bewegung = bewegung;
        this.toene = toene;
        this.vorname = vorname;
        this.ichBin = ichBin;
    }

    public String getBewegung() {
        return bewegung;
    }

    public void setBewegung(String bewegung) {
        this.bewegung = bewegung;
    }

    public String getToene() {
        return toene;
    }

    public void setToene(String toene) {
        this.toene = toene;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getIchBin() {
        return ichBin;
    }

    public void setIchBin(String ichBin) {
        this.ichBin = ichBin;
    }

    @Override
    public String toString() {
        return "Lebewesen{" + "bewegung=" + bewegung + ", toene=" + toene + ", vorname=" + vorname + ", ichBin=" + ichBin + '}';
    }
    
    
}
