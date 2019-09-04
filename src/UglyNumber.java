import java.util.Scanner;

// 题49：丑数
// 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到
// 大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。
// 习惯上我们把1当做第一个丑数。
// 1 2 3 5 4 6 10
public class UglyNumber {
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int sum=1;
        int number=1;
        while(sum<=n){
            if(isUglyNumber(number)){
                sum++;
            }
            number++;
        }
        System.out.println(number);
    }

    public static boolean isUglyNumber(int number){
        while(number%2==0){
            number=number/2;
        }
        while(number%3==0){
            number=number/3;
        }
        while(number%5==0){
            number=number/5;
        }
        return number==1;
    }
}
