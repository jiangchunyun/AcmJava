import java.util.ArrayList;
import java.util.Scanner;

// 题29：顺时针打印矩阵
// 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
/*
    1 2 3 4
    5 6 7 8
    9 4 6 4
*/
public class PrintMatrix {
    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        ArrayList<Integer> res = printArray(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static ArrayList<Integer> printArray(int[][] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int up = 0;
        int down = nums.length - 1;
        int left = 0;
        int right = nums[0].length - 1;
        while (true) {
            //右
            for (int i = left; i <= right; i++) {
                res.add(nums[up][i]);
            }
            if (++up > down) {
                break;
            }
            //下
            for (int i = up; i <= down; i++) {
                res.add(nums[i][right]);
            }
            if (--right < left) {
                break;
            }
            //左
            for (int i = right; i >= left; i--) {
                res.add(nums[down][i]);
            }
            if (--down < up) {
                break;
            }
            //上
            for (int i = down; i >= up; i--) {
                res.add(nums[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
