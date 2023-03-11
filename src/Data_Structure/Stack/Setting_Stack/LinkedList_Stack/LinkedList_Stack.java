package Data_Structure.Stack.Setting_Stack.LinkedList_Stack;

import java.util.Scanner;

public class LinkedList_Stack {
    public static boolean isEmpty(Node_Stack top) {
        return top == null;
    }

    public static boolean isFull() {
        return false;
    }

    public static Node_Stack push(Node_Stack top, int value) {
        Node_Stack newTop = new Node_Stack(value);
        if (isFull()) {
            System.out.println("Stack is full, not push! ");
        }
        else {
            newTop.next = top;
            top = newTop;
        }
        return top;
    }

    public static Node_Stack pop(Node_Stack top) {
        if (isEmpty(top)) {
            System.out.println("Stack is empty, not pop! ");
        }
        else {
            top = top.next;
        }
        return top;
    }

    public static int peek(Node_Stack top) {
        return top.value;
    }

    public static int size(Node_Stack top) {
        int count = 0;
        while (top != null) {
            ++count;
            top = top.next;
        }
        return count;
    }

    public static void print(Node_Stack top) {
        if (isEmpty(top)) {
            System.out.println("Stack is empty! ");
        }
        else {
            while (top != null) {
                System.out.println(top.value+" ");
                top = top.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node_Stack top = null;
        System.out.println("----------MENU----------");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Top");
        System.out.println("4. IsFull ?");
        System.out.println("5. IsEmpty ?");
        System.out.println("6. Size");
        System.out.println("7. Print");
        System.out.println("8. End game");

        while (true) {
            System.out.print("\nNhập lựa chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nhập giá trị cần đẩy: ");
                    int x1 = sc.nextInt();
                    top = push(top, x1);
                    break;

                case 2:
                    top = pop(top);
                    break;

                case 3:
                    System.out.println(peek(top));
                    break;

                case 4:
                    System.out.println(isFull());
                    break;

                case 5:
                    System.out.println(isEmpty(top));
                    break;

                case 6:
                    System.out.println(size(top));
                    break;

                case 7:
                    print(top);
                    break;

                case 8:
                    System.out.println("End game! ");
                    return;

                default:
                    System.out.println("Lựa chọn ko hợp lệ! ");
            }
        }
    }
}
