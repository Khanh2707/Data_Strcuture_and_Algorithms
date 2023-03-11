package Data_Structure.LinkedList.Setting_LinkedList;

import java.util.Scanner;

public class My_LinkedList {
    public static Node createNode(int value) {
        Node node = new Node(value);
        node.next = null;
        return node;
    }

    public static int length(Node head) {
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }

    public static Node addHead(Node head, int value) {
        Node newHead = createNode(value);
        if (head == null) {
            head = newHead;
        }
        else {
            newHead.next = head;
            head = newHead;
            System.out.println("Đã thêm "+newHead.value+" vào vị trí đầu tiên! ");
        }
        return head;
    }

    public static Node addTail(Node head, int value) {
        Node newTail = createNode(value);
        if (head == null) {
            head = newTail;
        }
        else {
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newTail;
            System.out.println("Đã thêm "+newTail.value+" vào vị trí cuối cùng! ");
        }
        return head;
    }

    public static Node addIndex(Node head, int value, int index) {
        Scanner sc = new Scanner(System.in);
        if (head == null) {
            return addHead(head, value);
        }

        int size = length(head);
        if (index < 0 || index > size) {
            System.out.println("Vị trí nhập ko hợp lệ! ");
            System.out.print("Nhập giá trị: ");
            int x3 = sc.nextInt();
            System.out.print("Nhập vị trí thêm: ");
            int y3 = sc.nextInt();
            head = addIndex(head, x3, y3);
        }
        else if (index == 0) {
            return addHead(head, value);
        }
        else if (index == size) {
            return addTail(head, value);
        }
        else {
            Node test = head;
            int count = 0;
            while (test != null) {
                ++count;
                if (count == index) {
                    Node indexNode = createNode(value);
                    indexNode.next = test.next;
                    test.next = indexNode;
                    System.out.println("Đã thêm "+indexNode.value+" vào sau vị trí "+index+"! ");
                    break;
                }
                test = test.next;
            }
        }
        return head;
    }

    public static Node deleteHead(Node head) {
        if (head == null) {
        }
        else {
            System.out.println("Đã xóa "+head.value+" khỏi vị trí đầu tiên! ");
            head = head.next;
        }
        return head;
    }

    public static Node deleteTail(Node head) {
        if (head == null) {
        }
        else {
            Node before = null, after = head;
            while (after.next != null) {
                before = after;
                after = after.next;
            }
            if (before == null) {
                System.out.println("Đã xóa "+after.value+" khỏi vị trí cuối cùng! ");
                head = null;
            }
            else {
                System.out.println("Đã xóa "+after.value+" khỏi vị trí cuối cùng! ");
                before.next = null;
            }
        }
        return head;
    }

    public static Node deleteIndex(Node head, int index) {
        Scanner sc = new Scanner(System.in);
        int size = length(head);
        if (index < 1 || index > size) {
            System.out.println("Vị trí xóa ko hợp lệ! ");
            System.out.print("Nhập vị tri xóa: ");
            int x6 = sc.nextInt();
            head = deleteIndex(head, x6);
        }
        else if (index == 1) {
            return deleteHead(head);
        }
        else if (index == size) {
            return deleteTail(head);
        }
        Node test = head;
        int count = 1;
        while (test != null) {
            ++count;
            if (count == index) {
                System.out.println("Đã xóa "+(test.next).value+" khỏi vị trí "+index+"! ");
                test.next = test.next.next;
                break;
            }
            test = test.next;
        }
        return head;
    }

    public static void searchIndex(Node head, int index) {
        if (head == null) {
            System.out.println("List đang rỗng! ");
            return;
        }
        int count = 0;
        Node test = head;
        while (test != null) {
            ++count;
            if (count == index) {
                System.out.println("Node ở vị trí " + index + " là: " + test.value + "");
                return;
            }
            test = test.next;
        }
        if (count != index) {
            System.out.println("Vi tri dang ko có node! ");
        }
    }

    public static void sortAsc(Node head) {
        for (Node i = head; i.next != null; i = i.next) {
            Node min = i;
            for (Node j = i.next; j != null; j = j.next) {
                if (j.value < min.value) {
                    min = j;
                }
            }
            int temp = i.value;
            i.value = min.value;
            min.value = temp;
        }
    }

    public static void sortDesc(Node head) {
        for (Node i = head; i.next != null; i = i.next) {
            Node max = i;
            for (Node j = i.next; j != null; j = j.next) {
                if (j.value > max.value) {
                    max = j;
                }
            }
            int temp = i.value;
            i.value = max.value;
            max.value = temp;
        }
    }

    public static Node reverse(Node head) {
        if (head == null) {
            System.out.println("List có đéo gì mà hoán đổi! ");
        }
        Node n1 = head;
        while (n1.next != null) {
            Node n2 = n1.next;
            n1.next = n2.next;
            n2.next = head;
            head = n2;
        }
        return head;
    }

    public static Node reverse2(Node head) {
        if (head == null) {
            System.out.println("Đéo có gì mà đảo! ");
            return head;
        }

        Node nodeNext = head.next;

        if (nodeNext == null) {
            return head;
        }

        Node newHead = reverse2(nodeNext);

        nodeNext.next = head;
        head.next = null;

        return newHead;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("List rỗng");
        }
        while (head != null) {
            System.out.print(head.value+"\t");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = null;

        System.out.println("--------------------MENU--------------------");
        System.out.println("1. Thêm đầu");
        System.out.println("2. Thêm cuối");
        System.out.println("3. Thêm giữa");
        System.out.println("4. Xóa đầu");
        System.out.println("5. Xóa cuối");
        System.out.println("6. Xóa giữa");
        System.out.println("7. In list");
        System.out.println("8. Tìm kiếm");
        System.out.println("9. Sắp xếp tăng");
        System.out.println("10. Sắp xếp giảm");
        System.out.println("11. Đảo vị trí node");
        System.out.println("12. Thoát chương trình! ");
        System.out.println("--------------------------------------------");
        while (true) {
            System.out.print("\nNhập lựa chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nhập giá trị: ");
                    int x1 = sc.nextInt();
                    head = addHead(head, x1);
                    break;

                case 2:
                    System.out.print("Nhập giá trị: ");
                    int x2 = sc.nextInt();
                    head = addTail(head, x2);
                    break;

                case 3:
                    System.out.print("Nhập giá trị: ");
                    int x3 = sc.nextInt();
                    System.out.print("Nhập vị trí thêm: ");
                    int y3 = sc.nextInt();
                    head = addIndex(head, x3, y3);
                    break;

                case 4:
                    head = deleteHead(head);
                    break;

                case 5:
                    head = deleteTail(head);
                    break;

                case 6:
                    System.out.print("Nhập vị tri xóa: ");
                    int x6 = sc.nextInt();
                    head = deleteIndex(head, x6);
                    break;

                case 7:
                    printList(head);
                    break;

                case 8:
                    System.out.print("Nhập vị trí cần tìm: ");
                    int x8 = sc.nextInt();
                    searchIndex(head, x8);
                    break;

                case 9:
                    sortAsc(head);
                    System.out.println("List đã sắp xếp tăng dần! ");
                    break;

                case 10:
                    sortDesc(head);
                    System.out.println("List đã sắp xếp giảm dần! ");
                    break;

                case 11:
                    head = reverse(head);
                    break;

                case 12:
                    System.out.print("Kết thúc chương trình! ");
                    return;

                default:
                    System.out.print("Nhập ko hợp lệ! ");
            }
        }
    }
}
