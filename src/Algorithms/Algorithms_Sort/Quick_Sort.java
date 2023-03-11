package Algorithms.Algorithm_Sort;

import java.util.Arrays;

public class Quick_Sort {
    static void sort(int a[], int L, int R) {
        if (L >= R) {
            return;
        }

        int p = partition(a, L, R);
        System.out.println("P trước: "+p);
        System.out.println("R trước: "+R);
        sort(a,L,p - 1);
        System.out.println("P sau: "+p);
        System.out.println("R sau: "+R);
        sort(a,p,R);
    }

    static int partition(int a[], int L, int R) {
        int pivot = a[(L+R)/2];
        System.out.println("Pivot: "+pivot);
        int iL = L, iR = R;
        while (iL <= iR) {
            while (a[iL] < pivot)
                iL++;
            while (a[iR] > pivot)
                iR--;
            if (iL <= iR) {
                swap(a,iL,iR);
                iL++;   iR--;
            }
        }
        System.out.println("iL: "+iL);
        System.out.println(Arrays.toString(a));
        return iL;
    }

    static void swap(int a[], int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    public static void main(String[] args) {
        /*
        Random rand = new Random();
        int a[] = new int[7];

        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(70);
        }
         */
        int a[] = {1,3,2,5,6,7,4};
        System.out.println(Arrays.toString(a));
        sort(a,0,a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
