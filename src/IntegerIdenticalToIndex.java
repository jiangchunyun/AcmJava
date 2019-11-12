import java.util.Scanner;

// 题53（三）：数组中数值和下标相等的元素
// 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
// 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1,
// 1, 3, 5}中，数字3和它的下标相等。
public class IntegerIdenticalToIndex {
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] numbers=new int[n];
        for(int i=0;i<n;i++){
            numbers[i]=in.nextInt();
        }

        System.out.println(getNumberSameAsIndex(numbers));
    }

    public static int getNumberSameAsIndex(int[] numbers){
        int start=0;
        int end=numbers.length-1;
        while(start<end){
            int mid=(start+end)/2;
            if(numbers[mid]==mid){
                return numbers[mid];
            }

            if(numbers[mid]<mid){
                start=mid+1;
            }else{
                end=mid-1;
            }

        }
        return -1;
    }
}
