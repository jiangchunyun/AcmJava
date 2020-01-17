import java.util.Scanner;
// 题66：构建乘积数组
// 题目：给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其
// 中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

public class ConstuctArray {
    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int[] res = constuctArray(nums);
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] constuctArray(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int front = 1;
        int back = 1;
        for (int i = 0; i < length; i++) {
            res[i] = front;
            front = front * nums[i];
        }
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * back;
            back = back * nums[i];
        }
        return res;
    }
}
