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
public class Mensch extends Lebewesen {
    
    private String nachname;
    private String hobby;

    public Mensch(String nachname, String hobby, String bewegung, String toene, String vorname, String ichBin) {
        super(bewegung, toene, vorname, ichBin);
        this.nachname = nachname;
        this.hobby = hobby;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Mensch{" + "nachname=" + nachname + ", hobby=" + hobby + '}';
    }
    
    
}
