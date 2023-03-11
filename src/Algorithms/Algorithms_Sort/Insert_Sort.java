package Algorithms.Algorithm_Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Insert_Sort {
    static void iss(int a[]) {
        for (int i = 1; i < a.length; ++i) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                --j;
            }
            a[j + 1] = key;
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
        iss(a);
        System.out.println(Arrays.toString(a));
    }
}
