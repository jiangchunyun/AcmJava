import java.util.Scanner;

// 题48：最长不含重复字符的子字符串
// 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子
// 字符串的长度。假设字符串中只包含从'a'到'z'的字符。
// 例如，在字符串“arabcacfr”中，最长的不含重复字符的子字符串是“acfr”，长度为4。
// 1 2 2 3 4 4 4 4 4
// abcdddddda
public class LongestSubstringWithoutDup {
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dpPre = 0; // 以上一个字符结尾的不包含重复字符的最长子字符串的长度
        int maxdp = 0;// 记录最大的值
        int[] position = new int[128]; // 记录上个字符出现的位置
        for (int i = 0; i < 128; i++)
            position[i] = -1;
        for (int dpIndex = 0; dpIndex < s.length(); dpIndex++) { // 遍历每个位置
            int preIndex = position[s.charAt(dpIndex)];
            if (preIndex < 0 || dpIndex - preIndex > dpPre) {
                dpPre++;
            } else {
                dpPre = dpIndex - preIndex;
            }
            if (dpPre > maxdp) {
                maxdp = dpPre;
            }
            position[s.charAt(dpIndex)] = dpIndex;
        }
        return maxdp;
    }
}
