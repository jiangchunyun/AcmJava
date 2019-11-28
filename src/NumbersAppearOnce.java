import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersAppearOnce {

    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        int[] res = findNumbersAppearOnce(numbers);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    public static int[] findNumbersAppearOnce(int[] numbers) {
        int res = 0;
        for (int i = 0; i < numbers.length; i++) {
            res = res ^ numbers[i];
        }
        int index = findFirstOneIndex(res);
        List<Integer> oneNumbers = new ArrayList<Integer>();
        List<Integer> twoNumbers = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (isIndexOneNumber(numbers[i], index)) {
                oneNumbers.add(numbers[i]);
            } else {
                twoNumbers.add(numbers[i]);
            }
        }
        int[] nums = new int[2];
        nums[0] = findNumberAppearOnce(oneNumbers);
        nums[1] = findNumberAppearOnce(twoNumbers);
        return nums;
    }

    public static int findFirstOneIndex(int number) {
        int index = 0;
        while ((number & 1) == 0 && index < 32) {
            number = number >> 1;
            index++;
        }
        return index;
    }

    public static boolean isIndexOneNumber(int number, int index) {
        return ((number >> index) & 1) == 1;
    }

    public static int findNumberAppearOnce(List<Integer> numbers) {
        int res = 0;
        for (int i = 0; i < numbers.size(); i++) {
            res = res ^ numbers.get(i);
        }
        return res;
    }
}
