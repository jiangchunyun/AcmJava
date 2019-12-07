import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 题45：把数组排成最小的数
// 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼
// 接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数
// 字能排成的最小数字321323。
public class SortArrayForMinNumber {
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] numbers=new int[n];
        for(int i=0;i<n;i++){
            numbers[i]=in.nextInt();
        }

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(compare(numbers[j],numbers[j+1])){
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            System.out.print(numbers[i]);
        }
    }
    public static boolean compare(int a,int b){
        List<Integer> aList=new ArrayList<>();
        while(a!=0){
            aList.add(a%10);
            a=a/10;
        }
        List<Integer> bList=new ArrayList<>();
        while(b!=0){
            bList.add(b%10);
            b=b/10;
        }
        int aIndex=aList.size()-1;
        int bIndex=bList.size()-1;
        while(aIndex>=0&&bIndex>=0){
            if(aList.get(aIndex)<bList.get(bIndex)){
                return true;
            }
            aIndex--;
            bIndex--;
        }
        if(aIndex>0){
            return true;
        }
        return false;
    }
}
