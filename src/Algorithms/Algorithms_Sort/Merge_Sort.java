package Algorithms.Algorithm_Sort;

import java.util.Arrays;
import java.util.Random;

public class Merge_Sort {
    public static int[] merge(int a1[], int a2[]) {
        int r = a1.length + a2.length;
        int result[] = new int[r];

        int i = 0, i1 = 0, i2 = 0;
        while (i < r) {
            if (i1 < a1.length && i2 < a2.length) {
                if (a1[i1] < a2[i2]) {
                    result[i] = a1[i1];
                    i++; i1++;
                }
                else {
                    result[i] = a2[i2];
                    i++; i2++;
                }
            }
            else {
                if (i1 < a1.length) {
                    result[i] = a1[i1];
                    i++; i1++;
                }
                else {
                    result[i] = a2[i2];
                    i++; i2++;
                }
            }
        }
        return result;
    }

    public static int[] sort(int a[], int L, int R) {
        if (L == R) {
            int single[] = {a[L]};
            return single;
        }

        System.out.println("Chia "+L+" - "+R+"");
        int K = (L + R) / 2;
        int a1[] = sort(a, L, K);
        int a2[] = sort(a, (K + 1), R);

        int result[] = merge(a1, a2);

        return result;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int a[] = new int[7];

        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(70);
        }

        System.out.println(Arrays.toString(a));
        a = sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
