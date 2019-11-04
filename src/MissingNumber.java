import java.util.Scanner;

// 题53（二）：0到n-1中缺失的数字
// 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
// 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
// 中，请找出这个数字。
public class MissingNumber {
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] numbers=new int[n];
        for(int i=0;i<n-1;i++){
            numbers[i]=in.nextInt();
        }
        System.out.println(searchMissingNumber(numbers));
    }

    public static int searchMissingNumber(int[] numbers){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]!=i){
                return i;
            }
        }
        return -1;
    }
}
