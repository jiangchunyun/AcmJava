import java.util.Scanner;
// 题51：数组中的逆序对
// 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
// 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
// { 1, 2, 3, 4, 7, 6, 5 } 3
public class InversePairs {
    public static int sum=0;
    public static void main(String[] argc){
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        sort(nums,0,nums.length-1);
        System.out.println(sum);
    }

    //暴力解决
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

    //归并排序解决
    public static void sort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;
        sort(nums,left,mid);
        sort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    // 合并数组
    public static void merge(int[] nums,int left,int mid,int right){
        int[] temp=new int[nums.length];
        int midCopy=mid+1;
        int leftCopy=left;
        int start=left;
        while(left<=mid&&midCopy<=right){
            if(nums[left]<=nums[midCopy]){
                temp[leftCopy++]=nums[left++];
            }else{
                temp[leftCopy++]=nums[midCopy++];
                sum=sum+(mid-(left-1));
            }
        }
        while(midCopy<=right){
            temp[leftCopy++]=nums[midCopy++];
        }
        while(left<=mid){
            temp[leftCopy++]=nums[left++];
        }
        while(start<=right){
            nums[start]=temp[start++];
        }
    }
}
