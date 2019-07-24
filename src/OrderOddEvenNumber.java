import java.util.ArrayList;
import java.util.Scanner;
// 调整数组顺序使奇数位于偶数前面
// 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
// 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
public class OrderOddEvenNumber {
    public static void main(String[] arg){
        ArrayList<Integer> numbers=new ArrayList<Integer>();
        int n;
        Scanner in =new Scanner(System.in);
        n=in.nextInt();
        for(int i=0;i<n;i++){
            Integer val=in.nextInt();
            numbers.add(val);
        }
        order(numbers);
        numbers.forEach((item)->{
            System.out.println(item);
        });

    }

    public static ArrayList<Integer> order(ArrayList<Integer> numbers){
        int start=0;
        int end=numbers.size()-1;
        while(start<end){
            while(start<end){
                if(numbers.get(start)%2==1){
                    start++;
                }else{
                    break;
                }
            }
            while(start<end){
                if(numbers.get(end)%2==0){
                    end--;
                }else{
                    break;
                }
            }
            if(start<end){
                Integer temp=numbers.get(start);
                numbers.set(start,numbers.get(end));
                numbers.set(end,temp);
            }
        }
        return numbers;
    }


}
