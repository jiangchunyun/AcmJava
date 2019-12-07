import java.util.Scanner;

// 题53（一）：数字在排序数组中出现的次数
// 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,
// 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
public class NumberOfK {
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        int k=in.nextInt();
        System.out.println(getNumberOfK(nums,k));
    }

    public static int getNumberOfK(int[] nums,int k){
        int index=findNumberIndex(nums,k,0,nums.length-1);
        int i=index;
        int times=0;
        while(i>0&&nums[index]==nums[i]){
            i--;
            times++;
        }
        i=index+1;
        while(i<nums.length-1&&nums[index]==nums[i]){
            i++;
            times++;
        }
        return times;
    }

    public static int findNumberIndex(int[] nums,int k,int start,int end){
        int mid=(start+end)/2;
        if(nums[mid]==k){
            return mid;
        }
        if(nums[mid]>k){
            return findNumberIndex(nums,k,start,mid);
        }
        return findNumberIndex(nums,k,mid+1,end);
    }
}
