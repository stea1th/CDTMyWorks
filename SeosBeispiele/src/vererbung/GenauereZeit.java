/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vererbung;

import benutzerdefdatentyp.Zeit;

/**
 *
 * @author vvlasov
 */
public class GenauereZeit extends Zeit {

    private int millis;

    public GenauereZeit(int h, int m, int s, int millis) {
        super(h, m, s);
        if (millis > 999) {
            this.millis = 0;
        } else if (millis > 0) {
            this.millis = millis;
        }
    }

    public GenauereZeit(Zeit z, int millis) {
        super(z);
        this.millis = millis;
    }

    public GenauereZeit() {
        super();
    }

    public GenauereZeit(GenauereZeit p) {
        //super(p.getHour(), p.getMinute(), p.getSecond());
        super(p);
        millis = p.millis;
    }

    public String toString() {
        return super.toString() + String.format(",%03d", millis);
    }

    public int getMillis() {
        return millis;
    }

    public void setMillis(int millis) {
        if (millis >= 0 && millis <= 999) {
            this.millis = millis;
        }
    }

    @Override
    public void print() {
        if (getFormat() == 1) {
            System.out.println(this);
        } else {
            System.out.println(getHour() + " Stunden, "
                    + getMinute() + " Minuten, "
                    + getSecond() + " Sekunden und "
                    + millis + " Millisekunden");
        }
    }

    public boolean equals(GenauereZeit p) {
        /*return getHour() == p.getHour() &&
                getMinute() == p.getMinute() &&
                getSecond() == p.getSecond() &&
                millis == p.millis;*/
        return millis == p.millis && super.equals(p);
    }

    public int compareTo(GenauereZeit z) {
        return super.compareTo(z) == 0 ? millis - z.millis : super.compareTo(z);
    }

    public GenauereZeit addiereGenauereZeit(GenauereZeit p) {
        
        this.millis += p.millis;
        if (this.millis > 999) {
            this.millis %= 1000;
            this.addSec(1);
        }
        return new GenauereZeit(this.addiereZeit(p), this.millis);
    }

}
