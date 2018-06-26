/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notenverwaltung;

/**
 *
 * @author vvlasov
 */
public class User {

    private int id;
    private String vName;
    private String nName;
    private Fach fach;

    public void setId(int id) {
        this.id = id;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    public void setFach(Fach fach) {
        this.fach = fach;
    }

    public Fach getFach() {
        return fach;
    }

    public int getId() {
        return id;
    }

    public String getnName() {
        return nName;
    }

    @Override
    public String toString() {

        return String.format("id:%14d\n"
                + "Vorname:%10s\n"
                + "Nachname:%10s\n"
                + "Fach: %10s\n", id, vName, nName, fach.getClass().getSimpleName());
    }

}
