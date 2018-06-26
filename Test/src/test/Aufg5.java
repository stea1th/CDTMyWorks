/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class Aufg5 {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Aufg5 auf = new Aufg5();

        auf.ausgabe(auf.getSum());
    }

    private int getSum() {
        boolean neueKarte = true;
        String bild = "";
        String words = "Sie haben die Karte";
        int sum = 0;
        int zahl;
        System.out.println("Lass uns spielen: ");
        while (neueKarte) {
            zahl = (int) (Math.random() * 10 + 2);
            if (zahl == 10) {
                int var = (int) (Math.random() * 4);
                Bilder[] bilder = Bilder.values();
                bild = var==3? "10" : bilder[var].name();
               
            }
            if (zahl > 9 && zahl < 11) {
                System.out.printf("%s %s bekommen\n", words, bild);
            } else if (zahl == 11) {
                System.out.printf("%s %s bekommen\n", words , Bilder.AS.name());
                System.out.println("Wollen Sie 11 oder 1 bekommen?");
                String x = scanner.nextLine();
                switch (x) {
                    case "11":
                        zahl = 11;
                        break;
                    case "1":
                        zahl = 1;
                        break;
                    default:
                        System.out.println("Ungültige Eingabe");
                        zahl = 11;
                }
            } else {
                System.out.printf("%s %d bekommen\n", words, zahl);
            }
            sum += zahl;
            System.out.printf("Ihre Zahlenstand ist: %d\n", sum);
            if (sum >= 21) {
                return sum;
            }
            System.out.println("Noch eine Karte? y oder n");
            if (!scanner.nextLine().equalsIgnoreCase("y")) {
                neueKarte = false;
            }

        }
        return sum;
    }

    private void ausgabe(int sum) {
        if (sum == 21) {
            System.out.println("Sie haben gewonnen!");
        } else if (sum > 21) {
            System.out.println("Sie haben verloren!");
        } else {
            System.out.printf("Sie haben Spiel mit %d Punkten beendet\n", sum);
        }
    }

}
