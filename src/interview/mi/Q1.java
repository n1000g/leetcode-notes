package interview.mi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while ((input = scanner.nextLine()) != null) {
            System.out.println(new Q1().isValid(input));
        }
    }

    private boolean isValid(String input) {
        if (input.contentEquals("")) return true;
        Deque<Character> stack = new LinkedList<>();
        for (Character c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                char c1 = stack.pop();
                if (c1 == '(' && c != ')') return false;
                if (c1 == '[' && c != ']') return false;
                if (c1 == '{' && c != '}') return false;
            }
        }
        return stack.isEmpty();
    }
}
