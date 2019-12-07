import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 题46：把数字翻译成字符串
// 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻
// 译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例
// 如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和
// "mzi"。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。

public class TranslateNumbersToStrings {
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(getTranslationCount(n));
    }

    public static int getTranslationCount(int n){
        if(n<0){
            return 0;
        }
        List<Integer> counts=new ArrayList<>();
        List<Integer> nums=new ArrayList<>();
        counts.add(1);
        nums.add(n%10);
        n=n/10;
        while(n!=0){
            int num=n%10;
            int former=nums.get(nums.size()-1);
            if(num>0&&(num*10+former<26)){
                int count;
                if(counts.size()>=2){
                    count=counts.get(counts.size()-1)+counts.get(counts.size()-2);
                }else{
                    count=counts.get(counts.size()-1)+1;
                }
                counts.add(count);
            }
            nums.add(num);
            n=n/10;
        }
        return counts.get(counts.size()-1);
    }
}
