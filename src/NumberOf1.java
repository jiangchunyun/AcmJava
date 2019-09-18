import java.util.Scanner;
// 题43：从1到n整数中1出现的次数
// 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如
// 输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次
public class NumberOf1 {

    public static void main(String[] argc){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(numberOf1(n));
    }
    public static int numberOf1(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=sum+hasOneTimes(i);
        }
        return sum;
    }

    public static int hasOneTimes(int num){
        int times=0;
        while(num!=0){
            if(num%10==1){
                times++;
            }
            num=num/10;
        }
        return times;
    }
}
