import java.util.HashMap;
import java.util.Scanner;

// 题50（一）：字符串中第一个只出现一次的字符
// 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出
// 'b'。
public class FirstNotRepeatingChar {
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        String str=in.next();
        System.out.println(getFirstNotRepeatingChar(str));
    }

    public static String getFirstNotRepeatingChar(String str){
        HashMap<String,Integer> hashMap=new HashMap<>();
        for(int i=0;i<str.length();i++){
            Integer times=hashMap.get(String.valueOf(str.charAt(i)));
            if(times==null){
                hashMap.put(String.valueOf(str.charAt(i)),1);
            }else{
                times++;
                hashMap.put(String.valueOf(str.charAt(i)),times);
            }
        }
        String res="";
        for(String key:hashMap.keySet()){
            Integer times=hashMap.get(key);
            if(times==1){
                res=key;
                break;
            }
        }
        return res;
    }
}
