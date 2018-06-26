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
public class Beispiel10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] arr = {{12, 16, 3, 143, 5},
        {32, 23, 7, 11, 1},
        {46, 67, 30, 10, 2}};
        
        
        
        System.out.println(vavg(arr));
        int[][] x = vsort(arr, true);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + " ");
            }
        }
    }

    
    
   
    
    public static int vmax(int[][] arr) {
        return vsort(arr, false)[0][0];

    }

    public static int vmin(int[][] arr) {
        return vsort(arr, true)[0][0];
    }

    public static double vavg(int[][] arr) {
        double avg = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                avg += arr[i][j];
                count++;
            }

        }
        return avg / count;
    }

    public static int[][] vsort(int[][] arr, boolean b) {
        int[][] array = arr;
        boolean isTrue = true;
        while (isTrue) {
            isTrue = false;
            int i;
            for (i = 0; i < array.length; i++) {
                array[i] = sortArr(array[i]);
            }
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j][array[j].length - 1] > array[j + 1][0]) {
                    int temp = array[j][array[j].length - 1];
                    array[j][array[j].length - 1] = array[j + 1][0];
                    array[j + 1][0] = temp;
                    isTrue = true;
                }
            }
        }

        return b ? array : reverse(array);
    }

    private static int[][] reverse(int[][] arr) {
        int a = arr.length;
        int b = arr[0].length;
        int[][] x = new int[a][b];
        for (int i = 0; i < arr.length; i++) {
            b = arr[i].length;
            for (int j = 0; j < arr[i].length; j++) {
                x[i][j] = arr[a - 1][b - 1];
                b--;
            }
            a--;
        }
        return x;
    }

    private static int[] sortArr(int[] a) {
        int[] x = a;
        for (int i = 1; i < x.length; i++) {
            if (x[i] < x[i - 1]) {
                int temp = x[i];
                x[i] = x[i - 1];
                x[i - 1] = temp;
                if (i > 1) {
                    i -= 2;
                }
            }
        }
        return x;
    }

}
