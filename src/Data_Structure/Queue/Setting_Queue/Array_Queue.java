package Data_Structure.Queue.Setting_Queue;

import java.util.Scanner;

public class Array_Queue {
    int capacity;
    int a[];
    int headIndex;
    int tailIndex;

    Array_Queue(int size) {
        capacity = size;
        a = new int[capacity];
        headIndex = 0;
        tailIndex = -1;
    }

    public boolean isFull() {
        return tailIndex == capacity - 1;
    }

    public boolean isEmpty() {
        return (headIndex == 0) && (tailIndex == -1);
    }

    public void push(int value) {
        if (!isFull()) {
            ++tailIndex;
            a[tailIndex] = value;
        }
        else {
            System.out.println("Queue đầy, ko thể thêm! ");
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Queue rỗng, ko thể xóa! ");
        }
        else {
            ++headIndex;
        }
    }

    public int top() {
        return a[headIndex];
    }

    public int size() {
        return (tailIndex + 1);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue rỗng! ");
        }
        else {
            for (int i = headIndex; i <= tailIndex; i++) {
                System.out.print(a[i]+"\t");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Array_Queue queue = new Array_Queue(7);
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
                    queue.push(x1);
                    break;

                case 2:
                    queue.pop();
                    break;

                case 3:
                    System.out.println(queue.top());
                    break;

                case 4:
                    System.out.println(queue.isFull());
                    break;

                case 5:
                    System.out.println(queue.isEmpty());
                    break;

                case 6:
                    System.out.println(queue.size());
                    break;

                case 7:
                    queue.print();
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
