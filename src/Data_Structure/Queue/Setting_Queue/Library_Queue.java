package Data_Structure.Queue.Setting_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Library_Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> myQueue = new LinkedList<>();
        System.out.println("----------MENU----------");
        System.out.println("1. Add");
        System.out.println("2. Remove");
        System.out.println("3. Peek");
        System.out.println("4. IsEmpty ?");
        System.out.println("5. Print");
        System.out.println("6. End game");

        while (true) {
            System.out.print("\nNhập lựa chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nhập giá trị cần đẩy: ");
                    int x1 = sc.nextInt();
                    myQueue.add(x1);
                    break;

                case 2:
                    myQueue.remove();
                    break;

                case 3:
                    System.out.println(myQueue.peek());
                    break;

                case 4:
                    System.out.println(myQueue.isEmpty());
                    break;

                case 5:
                    for (Integer i : myQueue) {
                        System.out.println(i);
                    }
                    break;

                case 6:
                    System.out.println("End game! ");
                    return;

                default:
                    System.out.println("Lựa chọn ko hợp lệ! ");
            }
        }
    }
}
