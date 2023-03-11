package Algorithms.Algorithm_Sort;

import java.util.Arrays;

public class Quick_Sort_2 {
    static void sort(int a[], int L, int R) {
        if (L >= R)
            return;

        int p = partition(a, L, R);
        sort(a,L,p - 1);
        sort(a,p + 1, R);
    }

    static int partition(int a[], int L, int R) {
        int pivot = a[R];
        int i = L - 1;

        for (int j = L; j < R; j++) {
            if (a[j] <= pivot) {
                ++i;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        ++i;
        int temp = a[i];
        a[i] = a[R];
        a[R] = temp;
        System.out.println(Arrays.toString(a));
        return i;
    }

    public static void main(String[] args) {
        int a[] = {6,4,2,5,3,1,8,7,9};
        System.out.println(Arrays.toString(a));
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
