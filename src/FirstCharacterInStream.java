import java.util.Scanner;
// 题50（二）：字符流中第一个只出现一次的字符
// 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从
// 字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字
// 符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
public class FirstCharacterInStream {
    public static int[] hash=new int[256];
    public static String string;
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        string=in.next();
        for(int i=0;i<string.length();i++){
            insert(string.charAt(i));
        }
        System.out.println(getFirstCharacterInStream());
    }

    public static void insert(char c){
        hash[c]++;
    }

    public static char getFirstCharacterInStream(){
        for(int i=0;i<string.length();i++){
            if(hash[string.charAt(i)]==1){
                return string.charAt(i);
            }
        }
        return ' ';
    }

}
