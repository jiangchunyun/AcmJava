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
        System.out.println(getUglyNumberSolution2(n));
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

    public static int getUglyNumberSolution1(int n){
        int sum=1;
        int number=1;
        while(sum<=n){
            if(isUglyNumber(number)){
                sum++;
            }
            number++;
        }
        return number;
    }
    public static int getUglyNumberSolution2(int size){
        int index2=0;
        int index3=0;
        int index5=0;
        int index=1;
        int[] numbers=new int[size];
        numbers[0]=1;
        while(index<size){
            int min=min(numbers[index2]*2,numbers[index3]*3,numbers[index5]*5);
            numbers[index]=min;
            if(min==numbers[index2]*2)
            {
                index2++;
            }
            if(min==numbers[index3]*3){
                index3++;
            }
            if(min==numbers[index5]*5){
                index5++;
            }
            index++;
        }
        return numbers[size-1];
    }

    public static int min(int num1,int num2,int num3){
        int minNum=num1>num2?num2:num1;
        return minNum>num3?num3:minNum;
    }
}
