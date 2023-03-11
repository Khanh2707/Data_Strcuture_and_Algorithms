package Algorithms.Algorithm_Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Selection_Sort {
    static void slss(int a[]) {
        int min = 0;
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random rand = new Random();
        int a[] = new int[7];

        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(70);
        }

        System.out.println(Arrays.toString(a));
        slss(a);
        System.out.println(Arrays.toString(a));
    }
}
