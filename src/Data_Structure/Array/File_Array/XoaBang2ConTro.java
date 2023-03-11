package Data_Structure.Array.File_Array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class XoaBang2ConTro {
    static int remove(int a[], int x) {
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != x) {
                a[k] = a[i];
                ++k;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int a[] = new int[7];

        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(70);
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }
        System.out.print("\nNhập x: ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int nMoi = remove(a, x);
        for (int i = 0; i < nMoi; i++) {
            System.out.print(a[i]+"\t");
        }
    }
}
