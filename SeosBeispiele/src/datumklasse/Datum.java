/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datumklasse;

import java.util.Calendar;

/**
 *
 * @author vvlasov
 */
public class Datum {

    private int tag;
    private int monat;
    private int jahr;
    private static final int[] TAGE_DES_MONATS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] TAGE_DER_WOCHE = {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};
    private static final int START = 1900;

    public Datum() {
        fillEmptyDate();
    }

    public Datum(int tag, int monat, int jahr) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
        checkData();
    }

    public Datum(Datum d) {
        tag = d.tag;
        monat = d.monat;
        jahr = d.jahr;
    }

    private void fillEmptyDate() {
        Calendar calendar = Calendar.getInstance();
        tag = calendar.get(Calendar.DATE);
        monat = calendar.get(Calendar.MONTH) + 1;
        jahr = calendar.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%d", tag, monat, jahr);
    }

    private void checkData() {
        checkJahr();
    }

    private void checkTag() {
        if (tag <= 0 || tag > TAGE_DES_MONATS[monat - 1]) {
            error();
        }
    }

    private void checkMonat() {
        if (monat > 0 && monat <= 12) {
            checkTag();
        } else {
            error();
        }
    }

    private void checkJahr() {
        if (jahr >= START && jahr <= 2500) {
            if (isSchaltJahr(jahr)) {
                TAGE_DES_MONATS[1] = 29;
            } else {
                TAGE_DES_MONATS[1] = 28;
            }
            checkMonat();
        } else {
            error();
        }
    }

    private boolean isSchaltJahr(int jahr) {
        return jahr % 4 == 0 && (jahr % 100 != 0 || jahr % 400 == 0);
    }

    private void error() {
        fillEmptyDate();
        System.err.println("Falsche Eingabe!!!");
        System.err.printf("Datum wurde auf %s gesetzt\n", this);
    }

    public int datumInsTage() {
        int sum = -1;
        for (int i = START; i < jahr; i++) {
            sum += 365;
            if (isSchaltJahr(i)) {
                sum++;
            }
        }
        if (isSchaltJahr(jahr)) {
            TAGE_DES_MONATS[1] = 29;
        }
        for (int i = 0; i < monat - 1; i++) {
            sum += TAGE_DES_MONATS[i];
        }
        TAGE_DES_MONATS[1] = 28;
        return sum += tag;
    }

    public int differenz(Datum d) {
        return Math.abs(datumInsTage() - d.datumInsTage());
    }

    private Datum tageInsDatum(int t) {
        int j = START + t / 365;
        t %= 365;
        for (int i = START; i < j; i++) {
            if (isSchaltJahr(i)) {
                t--;
            }
        }
        if (isSchaltJahr(j)) {
            TAGE_DES_MONATS[1] = 29;
        }
        int m = 1;
        for (int i = 0; i < 12; i++) {
            if (t / TAGE_DES_MONATS[i] >= 1) {
                t -= TAGE_DES_MONATS[i];
                m++;
            } else {
                break;
            }
        }
        TAGE_DES_MONATS[1] = 28;
        //System.out.printf("%02d.%02d.%d\n", d, m, j);
        //return new Datum(tag, monat, jahr);
        return new Datum(t + 1, m, j);
    }

    public Datum addierenTage(int t, boolean b) {
        Datum d = tageInsDatum(datumInsTage() + t);
        checkData();
        if (b) {
            tag = d.tag;
            monat = d.monat;
            jahr = d.jahr;
        } else {
            return new Datum(d.tag, d.monat, d.jahr);
        }
        return this;
    }

    public void bekommenTagDerWoche() {
        int t = datumInsTage() % 7;
        System.out.println("Tag der Woche ist: " + TAGE_DER_WOCHE[t]);
    }

    public void print() {
        System.out.print(this);
    }

    public void println() {
        print();
        System.out.println();
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
        checkData();
    }

    public int getMonat() {
        return monat;
    }

    public void setMonat(int monat) {
        this.monat = monat;
        checkData();
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
        checkData();
    }
}
