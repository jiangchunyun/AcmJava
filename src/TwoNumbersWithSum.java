import java.util.Scanner;
// 题57（一）：和为s的两个数字
// 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们
// 的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
public class TwoNumbersWithSum {

    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        int sum = in.nextInt();
        int[] res = findNumbersWithSum(numbers, sum);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] findNumbersWithSum(int[] numbers, int sum) {
        int start = 0;
        int end = numbers.length - 1;
        int[] res = new int[2];
        while (start < end) {
            if ((numbers[start] + numbers[end]) == sum) {
                res[0] = numbers[start];
                res[1] = numbers[end];
                return res;
            } else if ((numbers[start] + numbers[end]) < sum) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }
}
