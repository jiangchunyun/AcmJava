import java.util.Scanner;

/*
   a b c
             root
    a          b             c
  b   c     a     c       a    b
c      b  c         a   b        a

 */

/*
栈帧{str,res} str=abc res="abc" ;
栈帧{str,res,temp for(i=2)} str=abc res="ab" temp="ab";
栈帧{str,res,temp for(i=1)} str=abc res="a" temp="a";
栈帧{str,res,temp, for(i = 0)} str=abc res="" temp = ""
*
*/

/*
栈帧{str,res,temp for(i=2)} str=abc res="ab" temp="ab";
栈帧{str,res,temp for(i=1)} str=abc res="a" temp="a";
栈帧{str,res,temp, for(i = 0)} str=abc res="" temp = ""
*
*/

/*
栈帧{str,res,temp for(i)} str=abc res="ac" temp="ac";
栈帧{str,res,temp for(i=2)} str=abc res="a" temp="a";
栈帧{str,res,temp, for(i = 0)} str=abc res="" temp = "";
*
*/

public class SortChar {
    public static int[] sign = new int[1000];

    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        dfs(str, "");
    }

    // a b c
    public static void dfs(String str, String res) {
        if (res.length() >= 3) {
            System.out.println(res);
            return;
        }
        String temp = res;
        for (int i = 0; i < str.length(); i++) {
            if (sign[i] == 0) {
                sign[i] = 1;
                dfs(str, res+str.charAt(i));
                sign[i] = 0;
                res=temp;
            }
        }
    }
}
