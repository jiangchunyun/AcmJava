import java.util.Scanner;

// 题42：连续子数组的最大和
// 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
// 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
// 1, -2, 3, 10, -4, 7, 2, -5
public class GreatestSumOfSubarrays {
    public  static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] numbers=new int[n];
        for(int i=0;i<n;i++){
            numbers[i]=in.nextInt();
        }
        System.out.println(findGreatestSumOfSubArray(numbers));
    }

    public static int findGreatestSumOfSubArray(int[] numbers){
        int max=numbers[0];
        int sum=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>0){
                sum=sum+numbers[i];
            }else{
                if(sum>0&&sum>max){
                    max=sum;
                }else if(sum==0&&max<numbers[i]){
                    max=numbers[i];
                }
                sum=0;
            }
        }
        if(sum!=0&&sum>max){
            max=sum;
        }
        return max;
    }
}
