package Algorithms.Algorithm_Sort;

import java.util.Arrays;
import java.util.Random;

public class Quick_Sort_4 {
    static void sort(int a[], int L, int R) {
        if (L >= R) {
            return;
        }

        int pivotIndex = new Random().nextInt(R - L) + L;
        int pivot = a[pivotIndex];
        swap(a, pivotIndex,R);

        int p = partition(a, L, R, pivot);
        sort(a, L,p - 1);
        sort(a,p + 1, R);

    }

    static int partition(int a[], int L, int R, int pivot) {
        int iL = L; int iR = R;

        while (iL < iR) {
            while (a[iL] <= pivot && iL < iR) {
                ++iL;
            }

            while (a[iR] >= pivot && iL < iR) {
                --iR;
            }

            swap(a,iL,iR);
        }
        swap(a,iL,R);

        return iL;
    }

    static void swap(int a[], int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int a[] = new int[7];

        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(70);
        }

        System.out.println(Arrays.toString(a));
        sort(a,0,a.length - 1);
        System.out.println(Arrays.toString(a));

    }
}
