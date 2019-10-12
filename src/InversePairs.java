import java.util.Scanner;
// 题51：数组中的逆序对
// 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
// 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
public class InversePairs {
    public static void main(String[] argc){
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        System.out.println(getInversePairs(nums));
    }

    public static int getInversePairs(int[] nums){
        int sum=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[i]){
                    sum++;
                }
            }
        }
        return sum;
    }
}
