package Algorithms.Algorithm_Sort;

import java.util.Arrays;

public class Quick_Sort_3 {
    static void sort(int a[], int L, int R) {
        if (L >= R)
            return;

        int p = partition(a,L,R);
        sort(a,L,p);
        sort(a,p+1,R);
    }

    static int partition(int a[], int L, int R) {
        int pivot = a[L];
        int i = L - 1;
        int j = R + 1;
        while (true) {
            do {
                ++i;
            } while (a[i] < pivot);

            do {
                --j;
            } while (a[j] > pivot);

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            else
                System.out.println(Arrays.toString(a));
            return j;
        }
    }

    public static void main(String[] args) {
        int a[] = {5,4,6,7,8,4,2,9,1,3};
        System.out.println(Arrays.toString(a));
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
