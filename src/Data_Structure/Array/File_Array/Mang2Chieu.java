package Data_Structure.Array.File_Array;

import java.util.Scanner;

public class Mang2Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        System.out.print("Nhập số dòng: ");
        do {
            n = sc.nextInt();
            if (n < 3 || n > 5) {
                System.out.print("Nhập lại: ");
            }
        } while (n < 3 || n > 5);

        System.out.print("Nhập số cột: ");
        do {
            m = sc.nextInt();
            if (m < 3 || m > 5) {
                System.out.print("Nhập lại: ");
            }
        } while (m < 3 || m > 5);

        double a[][] = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("\nNhập phần tử thứ [" + i + ", " + j + "]: ");
                a[i][j] = sc.nextDouble();
            }
        }

        System.out.println("\nMảng vừa nhập: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("\t"+a[i][j]);
            }
            System.out.println("\n");
        }

        double max = 0;
        double tongmax = 0;
        int hangmax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max += a[i][j];
                hangmax = i;
            }
            break;
        }

        for (int i = 1; i < n; i++) {
            tongmax = 0;
            for (int j = 0; j < m; j++) {
                tongmax += a[i][j];
            }
            if (tongmax > max) {
                max = tongmax;
                hangmax = i;
            }
        }
        System.out.println("Max = "+max);
        System.out.println("Hàng max là hàng "+(hangmax + 1));

        double min = 0;
        double tongmin = 0;
        int hangmin = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min += a[i][j];
                hangmin = i;
            }
            break;
        }

        for (int i = 1; i < n; i++) {
            tongmin = 0;
            for (int j = 0; j < m; j++) {
                tongmin += a[i][j];
            }
            if (tongmin < min) {
                min = tongmin;
                hangmin = i;
            }
        }
        System.out.println("Min = "+min);
        System.out.println("Hàng min là hàng "+(hangmin+1));

        double temp[] = new double[m];
        for (int j = 0; j < m; j++) {
            temp[j] = a[hangmax][j];
            a[hangmax][j] = a[hangmin][j];
            a[hangmin][j] = temp[j];
        }

        System.out.println("\nMảng sau khi đổi chỗ hàng max và min");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("\t"+a[i][j]);
            }
            System.out.println("\n");
        }
    }
}
