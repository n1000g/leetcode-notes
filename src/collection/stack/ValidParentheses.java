package collection.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description: 20
 * @author: n8g
 * @createDate: 2020/9/7
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(new ValidParentheses().isValid(s));
    }
}
