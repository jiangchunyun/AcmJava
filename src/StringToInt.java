import java.util.Scanner;

// 面试题67：把字符串转换成整数
// 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
// 能使用atoi或者其他类似的库函数。
public class StringToInt {
    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(stringToInt(str));
    }

    public static int stringToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int symbol = 1;
        if (str.charAt(0) == '-') {
            symbol = -1;
        }
        int number = 0;
        int strSize = str.length();
        for (int i = (symbol == -1 ? 1 : 0); i < strSize; i++) {
            number = number * 10;
            number = number + str.charAt(i) - '0';
        }
        return symbol * number;
    }
}
