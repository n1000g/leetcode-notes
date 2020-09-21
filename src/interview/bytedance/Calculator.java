package interview.bytedance;

import java.util.Scanner;

/**
 * 计算器，加减乘幂
 */
public class Calculator {

    public static final int MOD = 1000000007;
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            long operand1 = sc.nextLong();
            long operand2 = sc.nextLong();
            char op = sc.next().charAt(0);

            switch (op) {
                case '-':
                    System.out.println(operand2 - operand1);
                    break;
                case '+':
                    System.out.println(operand1 + operand2);
                    break;
                case '*':
                    System.out.println((operand2 % MOD) * (operand1 % MOD) % MOD);
                    break;
                case '^':
                    System.out.println(myPow(operand1, operand2) % MOD);
            }

        }
    }
    private static double myPow(double x, long n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n < 0) return 1 / (myPow(x, -(n+1)) * x); // ??????
        double m = myPow(x, n/2);
        if (n % 2 == 0) return (m % MOD) * (m % MOD) % MOD;
        else return (x % MOD) * (m % MOD) * (m % MOD) % MOD;
    }
}
