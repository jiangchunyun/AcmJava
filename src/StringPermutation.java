// 题38：字符串的排列
// 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
// 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba

import java.util.Scanner;

/*
              root
      a         b          c
  b      c   a     c    b     a

 */
public class StringPermutation {
    public static boolean sign[]=new boolean[1000];
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        StringBuilder res=new StringBuilder("");
        String str=in.next();
        stringPermutation(str,res);
    }
    public static void stringPermutation(String str,StringBuilder res){
        if(str.length()==res.length()){
            System.out.println(res.toString());
            return;
        }

        for(int i=0;i<str.length();i++){
            if(sign[i]==false){
                res.append(str.charAt(i));
                sign[i]=true;
                stringPermutation(str,res);
                res.deleteCharAt(res.length()-1);
                sign[i]=false;
            }
        }
    }
}
