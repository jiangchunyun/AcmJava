import java.util.Scanner;

// 题40：最小的k个数
// 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
// 这8个数字，则最小的4个数字是1、2、3、4。
public class KLeastNumbers {
    public static void main(String[] argc){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        Integer[] numbers=new Integer[n];
        for(int i=0;i<n;i++){
            numbers[i]=in.nextInt();
        }
        int k=in.nextInt();
        //getKLeastNumbers(numbers,k);
        numbers=getKLeastNumbersSecondPlan(numbers,k);
        for(int i=0;i<k;i++){
            System.out.println(numbers[i]);
        }
    }

    public static Integer[] getKLeastNumbers(Integer[] numbers,int n){
        for(int i=1;i<numbers.length;i++){
            int index=i;
            int j=0;
            if(index<=n){
                j=index-1;
            }else{
                j=n;
            }
            for(;j>=0;j--){
                if(numbers[index]<numbers[j]){
                    int temp=numbers[index];
                    numbers[index]=numbers[j];
                    numbers[j]=temp;
                    index=j;
                }else{
                    break;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(numbers[i]);
        }
        return numbers;
    }

    public static Integer[] getKLeastNumbersSecondPlan(Integer[] numbers,int k){
        int start=0;
        int end=numbers.length-1;
        int index=searchIndex(numbers,start,end);
        while(index!=k-1){
            if(index<k-1){
                start=index+1;
            }else if(index>k-1){
                end=index-1;
            }
            index=searchIndex(numbers,start,end);
        }
        return numbers;
    }
    public static int searchIndex(Integer[] numbers,int start,int end){
        while(start<end){
            while(start<end&&numbers[start]<=numbers[end]){
                end--;
            }
            if(start<end){
                int temp=numbers[start];
                numbers[start]=numbers[end];
                numbers[end]=temp;
            }
            while(start<end&&numbers[start]<=numbers[end]){
                start++;
            }
            if(start<end){
                int temp=numbers[start];
                numbers[start]=numbers[end];
                numbers[end]=temp;
            }

        }
        return end;
    }
}
