package Data_Structure.Stack.Setting_Stack;

import java.util.Scanner;
import java.util.Stack;

public class Library_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> myStack = new Stack<>();
        System.out.println("----------MENU----------");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Top");
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
                    myStack.push(x1);
                    break;

                case 2:
                    myStack.pop();
                    break;

                case 3:
                    System.out.println(myStack.peek());
                    break;

                case 4:
                    System.out.println(myStack.empty());
                    break;

                case 5:
                    for (Integer i : myStack) {
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
