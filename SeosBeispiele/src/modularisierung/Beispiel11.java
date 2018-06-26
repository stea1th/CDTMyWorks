/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularisierung;

/**
 *
 * @author vvlasov
 */
public class Beispiel11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {18, 13, 24, 5, 1, 7};
        //System.out.println(vmax(arr));
        //System.out.println(vmin(arr));
        //System.out.println(vavg(arr));
        System.out.println(vsearch2(arr, -8));

        //System.out.println(vsearch2(arr, 5));
        //vsort(arr, true);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    private static int[] copy(int[] arr) {
        int[] x = new int[arr.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = arr[i];
        }
        return x;
    }

    public static void vsort(int[] arr, boolean b) {
        if (b) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    if (i > 1) {
                        i -= 2;
                    }
                }
            }
        } else {
            vsort(arr, true);
            reverse(arr);
        }
    }

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static int vsearch1(int[] arr, int wert) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (wert == arr[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int vmax(int[] arr) {
        int[] x = copy(arr);
        vsort(x, false);
        return x[0];

    }

    public static int vmin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int vsearch2(int[] arr, int wert) {
        int[] x = copy(arr);
        vsort(x, true);
        int i= -1, low = 0, high = arr.length, mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (wert == x[mid]) {
                i = mid;
                break;
            } else {
                if (wert < x[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return i;
    }

    public static double vavg(int[] arr) {
        double sum = 0;
        for(int x : arr){
            sum += x;
        }
        return sum / arr.length;
    }
}
