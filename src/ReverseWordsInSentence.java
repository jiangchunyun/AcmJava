import java.util.ArrayList;
import java.util.Scanner;
// 题58（一）：翻转单词顺序
// 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
// 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
// 则输出"student. a am I"。
public class ReverseWordsInSentence {
    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        reverseWords(str);
    }

    public static void reverseWords(String str) {
        ArrayList<String> res = new ArrayList<>();
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res.add(word);
                word = "";
            } else {
                word = word + str.charAt(i);
            }
        }
        res.add(word);
        for (int i=res.size()-1;i>=0;i--) {
            System.out.print(res.get(i)+" ");
        }
    }
}
