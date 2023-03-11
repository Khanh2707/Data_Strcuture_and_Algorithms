package Algorithms.Algorithm_Search;

import java.util.Scanner;

public class Binary_Search {
    static int search(int a[], int x) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == x) {
                return m;
            }
            else if (a[m] > x) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập x: ");
        int x = sc.nextInt();
        System.out.println("Tìm thấy "+x+" ở vị trí: " +search(a, x));
    }
}
