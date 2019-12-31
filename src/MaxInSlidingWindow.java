import java.util.ArrayList;
import java.util.Scanner;
// 题59（一）：滑动窗口的最大值
// 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
// 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
// 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，
public class MaxInSlidingWindow {
    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        int windowSize = in.nextInt();
        ArrayList res = maxInWindowsTwo(array, windowSize);
        for (int i = 0; i < res.size(); i++) {
            System.out.println( res.get(i));
        }
    }

    public static ArrayList maxInWindows(int[] array, int windowSize) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = windowSize; i <= array.length; i++) {
            int max = array[i - 1];
            for (int j = i - windowSize; j < i - 1; j++) {
                if (max < array[j]) {
                    max = array[j];
                }
            }
            res.add(max);
        }
        return res;
    }

    public static ArrayList<Integer> maxInWindowsTwo(int[] nums, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> queue = new ArrayList<>();
        for (int i = 0; i < size - 1; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.get(queue.size() - 1)]) {
                queue.remove(queue.size() - 1);
            }
            queue.add(i);
        }

        for (int i = size - 1; i < nums.length; i++) {
            while(!queue.isEmpty() && i - queue.get(0) + 1 > size) {
                queue.remove(0);
            }
            while(!queue.isEmpty() && nums[i] >= nums[queue.get(queue.size() - 1)]){
                queue.remove(queue.size() - 1);
            }
            queue.add(i);
            res.add(nums[queue.get(0)]);
        }
        return res;
    }
}
