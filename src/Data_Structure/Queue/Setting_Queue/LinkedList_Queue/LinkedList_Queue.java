package Data_Structure.Queue.Setting_Queue.LinkedList_Queue;

import java.util.Scanner;

public class LinkedList_Queue {
    public static boolean isFull() {
        return false;
    }

    public static boolean isEmpty(Node_Queue top) {
        return top == null;
    }

    public static Node_Queue push(Node_Queue top, int value) {
        if (isFull()) {
            System.out.println("Queue is full, can't push! ");
        }
        if (isEmpty(top)) {
            Node_Queue newNode = new Node_Queue(value);
            top = newNode;
        }
        else {
            Node_Queue tail = top;
            while (tail.next != null) {
                tail = tail.next;
            }
            Node_Queue newNode = new Node_Queue(value);
            tail.next = newNode;
        }
        return top;
    }

    public static Node_Queue pop(Node_Queue top) {
        if (isEmpty(top)) {
            System.out.println("Queue is empty, can't pop! ");
        }
        else {
            top = top.next;
        }
        return top;
    }

    public static int top(Node_Queue top) {
        if (isEmpty(top)) {
            System.out.println("Queue is empty, can't top! ");
        }
        return top.value;
    }

    public static int size(Node_Queue top) {
        int count = 0;
        while (top != null) {
            ++count;
            top = top.next;
        }
        return count;
    }

    public static void print(Node_Queue top) {
        if (isEmpty(top)) {
            System.out.println("Stack is empty! ");
        }
        else {
            while (top != null) {
                System.out.print(top.value+"\t");
                top = top.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node_Queue top = null;
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
                    System.out.println(top(top));
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
