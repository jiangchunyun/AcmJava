import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// 题39：数组中出现次数超过一半的数字
// 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
// 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
// 出现了5次，超过数组长度的一半，因此输出2
public class MoreThanHalfNumber {

    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            Integer number=in.nextInt();
            list.add(number);
        }
        System.out.println(searchMoreThanHalfNumber(list));
    }

    public static Integer searchMoreThanHalfNumber(List<Integer> numbers){
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<numbers.size();i++){
            Integer size= map.get(numbers.get(i));
            if(size==null){
                map.put(numbers.get(i),1);
            }else{
                if(size+1>numbers.size()/2)
                {
                    return numbers.get(i);
                }
                map.replace(numbers.get(i),size+1);
            }

        }
        return numbers.get(numbers.size()-1);
    }

}
