package Data_Structure.Stack.Setting_Stack;

import java.util.Scanner;

public class Array_Stack {
    int capacity;
    int a[];
    int topIndex;

    public Array_Stack(int size) {
        capacity = size;
        a = new int[capacity];
        topIndex = -1;
    }

    public boolean isFull() {
        return topIndex == capacity - 1;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public void push(int value) {
        if (!isFull()) {
            ++topIndex;
            a[topIndex] = value;
        }
        else {
            System.out.println("Stack đang đầy, ko thể thêm! ");
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack rỗng, ko thể xóa! ");
        }
        else {
            --topIndex;
        }
    }

    public int peek() {
        return a[topIndex];
    }

    public int size() {
        return (topIndex + 1);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty! ");
        }
        else {
            for (int i = topIndex; i >= 0; i--) {
                System.out.println(a[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Array_Stack stack = new Array_Stack(7);
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
                    stack.push(x1);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    System.out.println(stack.peek());
                    break;

                case 4:
                    System.out.println(stack.isFull());
                    break;

                case 5:
                    System.out.println(stack.isEmpty());
                    break;

                case 6:
                    System.out.println(stack.size());
                    break;

                case 7:
                    stack.print();
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
