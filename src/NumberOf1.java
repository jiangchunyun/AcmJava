import java.util.Scanner;
// 题43：从1到n整数中1出现的次数
// 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如
// 输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次
public class NumberOf1 {

    public static void main(String[] argc){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(numberOfOneMethodFirst(n));
    }
    public static int numberOfOneMethodFirst(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=sum+hasOneTimes(i);
        }
        return sum;
    }

    public static int hasOneTimes(int num){
        int times=0;
        int temp=num;
        while(num!=0){
            if(num%10==1){
                times++;
            }
            num=num/10;
        }
        if(times>0){
            System.out.print(temp+" ");
        }
        return times;
    }

    public static int numberOfOneMethodSecond(int n){
        int sum=0;
        int base=1;
        int round=n;
        int wight=0;
        int former=0;
        while(round>0){
            former=wight;
            wight=round%10;
            round=round/10;
            if(wight==0){
                sum=sum+base*round;
            }else if(wight==1){
                sum=sum+base*round+former+1;
            }else if(wight>1){
                sum=sum+base*round+base;
            }
            base=base*10;
        }
        return sum;
    }
}
