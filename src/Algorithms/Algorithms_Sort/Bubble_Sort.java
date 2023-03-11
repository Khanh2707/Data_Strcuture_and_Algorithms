package Algorithms.Algorithm_Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bubble_Sort {
    static void bbs(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int check = 0;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    ++check;
                }
            }
            if (check == 0) {
                break;
            }
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
        bbs(a);
        System.out.println(Arrays.toString(a));
    }
}
