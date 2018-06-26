/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelformat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* 
Задача по алгоритмам
 */
public class ExcelFormat {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String s = "";
        while (true) {
            s = reader.readLine();
            if (s.isEmpty()) {
                //System.out.println("Out");
                break;
            }
            list.add(s);
            //System.out.println("Ok");

        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        List<Integer> numbers = new ArrayList<>();
        List<String> notNumbers = new ArrayList<>();
        for (String s : array) {
            if (isNumber(s)) {
                numbers.add(Integer.parseInt(s));
            } else {
                notNumbers.add(s);
            }
        }
        numbers.sort(Comparator.reverseOrder());

        for (int i = 1; i < notNumbers.size(); i++) {
           if (isGreaterThan(notNumbers.get(i-1), notNumbers.get(i))) {
                String temp = notNumbers.get(i);
                notNumbers.set(i, notNumbers.get(i - 1));
                notNumbers.set(i - 1, temp);
                if (i > 1) {
                    i -= 2;
                }

            }
        }

        int x = 0;
        int y = 0;
        
        for (int i = 0; i < array.length; i++) {
            if(isNumber(array[i])){
                array[i] = numbers.get(x).toString();
                x++;
            }else{
                array[i] = notNumbers.get(y);
                y++;
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') // не цифра и не начинается с '-'
                    || (i == 0 && c == '-' && chars.length == 1)) // не '-'
            {
                return false;
            }
        }
        return true;
    }
}
