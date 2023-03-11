package Data_Structure.Stack.File_Stack;

import java.util.Scanner;
import java.util.Stack;

public class KiemTraMoNgoacDongNgoacCoHopLe {
    public static boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                myStack.push(c);
            }
            else {
                if (myStack.isEmpty())
                    return false;
                char peek = myStack.peek();
                if ((c == '}' && peek == '{') || (c == ']' && peek == '[') || (c == ')' && peek == '(')) {
                    myStack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.print("Nhập String: ");
        s = sc.nextLine();
        System.out.println(isValid(s));
    }
}
