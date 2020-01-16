import java.util.Scanner;
// 题65：不用加减乘除做加法
// 题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷
// 四则运算符号。
public class AddTwoNumbers {
    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        System.out.println(add(num1,num2));
    }

    public static int add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
