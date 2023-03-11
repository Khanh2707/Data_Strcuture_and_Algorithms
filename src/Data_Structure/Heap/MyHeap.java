package Data_Structure.Heap;

import java.util.Arrays;

public class MyHeap {
    private int MAX_SIZE = 100;
    private int arr[] = new int[MAX_SIZE + 1];
    private int size;

    MyHeap() {
        size = 0;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return arr[1];
    }

    public static void swap(int arr[], int b, int c) {
        int temp = arr[b];
        arr[b] = arr[c];
        arr[c] = temp;
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public void add(int value) {
        ++size;
        arr[size] = value;
        int childrenIndex = size;
        int parentIndex = size / 2;
        while (parentIndex != 0 && arr[parentIndex] > arr[childrenIndex]) {
            swap(arr,parentIndex,childrenIndex);
            childrenIndex = parentIndex;
            parentIndex = childrenIndex / 2;
        }
    }

    public void heapifyDown(int parent) {
        while (parent * 2 <= size) {
            int left = parent * 2;
            int right = left + 1;
            int choice = left;
            if (right <= size && arr[right] < arr[left])
                choice = right;

            if (arr[parent] > arr[choice]) {
                swap(arr,parent,choice);
                parent = choice;
            }
            else
                break;
        }
    }

    public int poll() {
        if (isEmpty()) {
            return -1;
        }

        int root = arr[1];
        arr[1] = arr[size];
        --size;

        heapifyDown(1);
        return root;
    }

    public void remove(int value) {
        int parent = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                parent = i;
                break;
            }
        }
        if (parent == -1) {
            System.out.println("Value not exist! ");
            return;
        }
        arr[parent] = arr[size];
        --size;
        heapifyDown(parent);
    }

    public static void main(String[] args) {
        MyHeap heap = new MyHeap();
        heap.add(5);
        heap.add(3);
        heap.add(6);
        heap.add(2);
        heap.add(4);
        heap.add(8);
        heap.add(7);

        heap.print();
        System.out.println();
        System.out.println(heap.peek());
        heap.poll();
        heap.print();
        heap.remove(4);
        System.out.println();
        heap.print();
    }
}
