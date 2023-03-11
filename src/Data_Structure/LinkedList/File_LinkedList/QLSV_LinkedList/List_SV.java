package Data_Structure.LinkedList.File_LinkedList.QLSV_LinkedList;

import java.util.Scanner;

public class List_SV {
    public static SinhVien createNode() {
        Scanner sc = new Scanner(System.in);
        SinhVien s = new SinhVien();
        System.out.print("Tên: ");
        s.name = sc.nextLine();
        System.out.print("Điểm: ");
        s.point = sc.nextFloat();
        s.next = null;
        return s;
    }

    public static int length(SinhVien head) {
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }

    public static SinhVien addHead(SinhVien head) {
        SinhVien newHead = createNode();
        if (head == null) {
            head = newHead;
        }
        else {
            newHead.next = head;
            head = newHead;
            System.out.println("Đã thêm "+newHead.name+" vào vị trí đầu tiên! ");
        }
        return head;
    }

    public static SinhVien addTail(SinhVien head) {
        SinhVien newTail = createNode();
        if (head == null) {
            head = newTail;
        }
        else {
            SinhVien tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newTail;
            System.out.println("Đã thêm "+newTail.name+" vào vị trí cuối cùng! ");
        }
        return head;
    }

    public static SinhVien addIndex(SinhVien head, int index) {
        Scanner sc = new Scanner(System.in);
        if (head == null) {
            return addHead(head);
        }

        int size = length(head);
        if (index < 0 || index > size) {
            System.out.println("Vị trí nhập ko hợp lệ! ");
            System.out.print("Nhập lại: ");
            int y3 = sc.nextInt();
            head = addIndex(head, y3);
        }
        else if (index == 0) {
            return addHead(head);
        }
        else if (index == size) {
            return addTail(head);
        }
        else {
            SinhVien test = head;
            int count = 0;
            while (test != null) {
                ++count;
                if (count == index) {
                    SinhVien indexNode = createNode();
                    indexNode.next = test.next;
                    test.next = indexNode;
                    System.out.println("Đã thêm "+indexNode.name+" vào sau vị trí "+index+"! ");
                    break;
                }
                test = test.next;
            }
        }
        return head;
    }

    public static SinhVien deleteHead(SinhVien head) {
        if (head == null) {
        }
        else {
            System.out.println("Đã xóa "+head.name+" khỏi vị trí đầu tiên! ");
            head = head.next;
        }
        return head;
    }

    public static SinhVien deleteTail(SinhVien head) {
        if (head == null) {
        }
        else {
            SinhVien before = null, after = head;
            while (after.next != null) {
                before = after;
                after = after.next;
            }
            if (before == null) {
                System.out.println("Đã xóa "+after.name+" khỏi vị trí cuối cùng! ");
                head = null;
            }
            else {
                System.out.println("Đã xóa "+after.name+" khỏi vị trí cuối cùng! ");
                before.next = null;
            }
        }
        return head;
    }

    public static SinhVien deleteIndex(SinhVien head, int index) {
        Scanner sc = new Scanner(System.in);
        int size = length(head);
        if (index < 1 || index > size) {
            System.out.println("Vị trí xóa ko hợp lệ! ");
            System.out.print("Nhập lại: ");
            int x6 = sc.nextInt();
            head = deleteIndex(head, x6);
        }
        else if (index == 1) {
            return deleteHead(head);
        }
        else if (index == size) {
            return deleteTail(head);
        }
        SinhVien test = head;
        int count = 1;
        while (test != null) {
            ++count;
            if (count == index) {
                System.out.println("Đã xóa "+(test.next).name+" khỏi vị trí "+index+"! ");
                test.next = test.next.next;
                break;
            }
            test = test.next;
        }
        return head;
    }

    public static void searchIndex(SinhVien head, int index) {
        if (head == null) {
            System.out.println("List đang rỗng! ");
            return;
        }
        int count = 0;
        SinhVien test = head;
        while (test != null) {
            ++count;
            if (count == index) {
                System.out.println("Node ở vị trí " + index + " là: " + test.name + "");
                return;
            }
            test = test.next;
        }
        if (count != index) {
            System.out.println("Vi tri dang ko có node! ");
        }
    }

    public static void sortAsc(SinhVien head) {
        for (SinhVien i = head; i.next != null; i = i.next) {
            SinhVien min = i;
            for (SinhVien j = i.next; j != null; j = j.next) {
                if (j.point < min.point) {
                    min = j;
                }
            }
            String temp1 = i.name;
            i.name = min.name;
            min.name = temp1;

            float temp2 = i.point;
            i.point = min.point;
            min.point = temp2;
        }
    }

    public static void sortDesc(SinhVien head) {
        for (SinhVien i = head; i.next != null; i = i.next) {
            SinhVien max = i;
            for (SinhVien j = i.next; j != null; j = j.next) {
                if (j.point > max.point) {
                    max = j;
                }
            }
            String temp1 = i.name;
            i.name = max.name;
            max.name = temp1;

            float temp = i.point;
            i.point = max.point;
            max.point = temp;
        }
    }

    public static void printList(SinhVien head) {
        if (head == null) {
            System.out.println("List rỗng");
        }
        while (head != null) {
            System.out.print("\n"+head.name +": ");
            System.out.print(head.point);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SinhVien head = null;

        System.out.println("--------------------MENU--------------------");
        System.out.println("1. Thêm node vào đầu list");
        System.out.println("2. Thêm node vào cuối list");
        System.out.println("3. Thêm node vào giữa list");
        System.out.println("4. Xóa node đầu list");
        System.out.println("5. Xóa node cuối list");
        System.out.println("6. Xóa node giữa list");
        System.out.println("7. In list");
        System.out.println("8. Tìm kiếm node");
        System.out.println("9. Sắp xếp tăng dần");
        System.out.println("10. Sắp xếp giảm dần");
        System.out.println("11. Thoát chương trình! ");
        System.out.println("--------------------------------------------");
        while (true) {
            System.out.print("\nNhập lựa chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    head = addHead(head);
                    break;

                case 2:
                    head = addTail(head);
                    break;

                case 3:
                    System.out.print("Nhập vị trí thêm: ");
                    int y3 = sc.nextInt();
                    head = addIndex(head, y3);
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
                    System.out.print("Kết thúc chương trình! ");
                    return;

                default:
                    System.out.print("Nhập ko hợp lệ! ");
            }
        }
    }
}
