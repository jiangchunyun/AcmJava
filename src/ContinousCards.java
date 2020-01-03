import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// 题61：扑克牌的顺子
// 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。

public class ContinousCards {
    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            nums.add(value);
        }
        System.out.println(isContinousCards(nums));
    }

    public static boolean isContinousCards(ArrayList<Integer> nums) {
        if (nums.size() <= 0) {
            return false;
        }
        Collections.sort(nums);
        int length = nums.size();

        int zeroCount = 0;
        for (int i = 0; i < length; i++) {
            if (nums.get(i) == 0) {
                zeroCount++;
            }
        }
        int dp = 0;
        for (int i = 1; i < length; i++) {
            if (nums.get(i) != 0 && nums.get(i) == nums.get(i - 1)) {
                return false;
            } else if (nums.get(i) != 0 && nums.get(i - 1) != 0) {
                dp = dp + (nums.get(i) - nums.get(i - 1) - 1);
            }
        }
        return zeroCount >= dp;
    }
}
