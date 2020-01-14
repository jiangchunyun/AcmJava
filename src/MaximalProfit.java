import java.util.Scanner;
// 题63：股票的最大利润
// 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股
// 票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,
// 7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能
// 收获最大的利润11。

public class MaximalProfit {

    public static void main(String[] argc){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0;i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(maxDiff(nums));
    }
    public static int maxDiff(int[] nums) {
        int min = nums[0];
        int max = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] - min < 0) {
                min = nums[i];
            }
            if(nums[i] - min > max) {
                max = nums[i] - min;
            }
        }
        return max;
    }
}
