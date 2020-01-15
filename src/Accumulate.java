import java.util.Scanner;
// 题64：求1+2+…+n
// 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
// 等关键字及条件判断语句（A?B:C）。
public class Accumulate {
    public static void main(String[] argc){
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(sum(n));
    }

    public static int sum(int n) {
        int res = 0;
        boolean temp = n == 0 || (res = sum(n - 1)) > 0;
        return res + n;
    }
}
