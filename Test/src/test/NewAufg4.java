/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class NewAufg4 {

    private GregorianCalendar gcal = new GregorianCalendar();

    private static final String[] S = {"Tag", "Monat", "Jahr", "Bitte", "eingeben"};
    private int d, m;

    public static void main(String[] args) throws Exception {

        new NewAufg4().printResult();
        /*System.out.println(Arrays.stream(model.getDays())
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));*/

    }

    /*public void printIt() {
        
        
        gcal.set(Calendar.DAY_OF_MONTH, scanner.nextInt());
        System.out.printf("%s %s %s: \n", s[3], s[1], s[4]);
        gcal.set(Calendar.MONTH, scanner.nextInt() - 1);
        
        gcal.set(Calendar.YEAR, scanner.nextInt());
        if (gcal.isLeapYear(gcal.getWeekYear())) {
            System.out.println("Aaah, ein Schaltjahr");
        }
        System.out.printf("Der %d.%d.%d ist der %d. %s des %ses %d\n", gcal.get(Calendar.DAY_OF_MONTH), gcal.get(Calendar.MONTH) + 1, gcal.get(Calendar.YEAR), gcal.get(Calendar.DAY_OF_YEAR),s[0], s[2], gcal.get(Calendar.YEAR));

    }*/
    public void printResult() {
        int result = getResult(getDay(), getMonth());
        if (gcal.isLeapYear(gcal.getWeekYear())) {
            System.out.println("Aaah, ein Schaltjahr");
        }
        System.out.printf("Der %d.%d.%d ist der %d. %s des %ses %d\n", d, m, gcal.getWeekYear(), result, S[0], S[2], gcal.getWeekYear());
    }

    private static int scan() {
        return new Scanner(System.in).nextInt();

    }

    private int getResult(int d, int m) {
        this.d = d;
        this.m = m;

        return Arrays.stream(getDays())
                .limit(m - 1)
                .sum() + d;
    }

    private int getDay() {
        System.out.printf("%s %s %s: \n", S[3], S[0], S[4]);
        return scan();
    }

    private int getMonth() {
        System.out.printf("%s %s %s: \n", S[3], S[1], S[4]);
        return scan();
    }

    private int[] getDays() {
        System.out.printf("%s %s %s: \n", S[3], S[2], S[4]);
        int y = scan();
        /*int[]x = new int[12];
        for (int i = 0; i <x.length ; i++) {
            gcal.set(y, i, 1);
            x[i]=gcal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }*/
        //return x;

        return IntStream.range(0, 11)
                .map(i -> {
                    gcal.set(y, i, 1);
                    return i;
                })
                .map(i -> {
                    i = gcal.getActualMaximum(Calendar.DAY_OF_MONTH);
                    return i;
                })
                .toArray();
    }

}
