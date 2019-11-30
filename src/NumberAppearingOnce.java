import java.util.Scanner;
// 题56（二）：数组中唯一只出现一次的数字
// 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
// 找出那个吃出现一次的数字。
public class NumberAppearingOnce {

    public static void main(String[] argc) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        findNumberAppearingOnce(numbers);

    }

    public static int findNumberAppearingOnce(int[] numbers) {
        int length = numbers.length;
        int[] res = new int[32];
        for (int i = 0; i < 32; i++) {
            res[i] = 0;
            for (int j = 0; j < length; j++) {
                int temp = numbers[j] & 1;
                if (temp == 1) {
                    res[i] = res[i] + 1;
                }
                numbers[j] = numbers[j] >> 1;
            }
        }

        int appearingOnceNumber = 0;
        for (int i = 31; i >= 0; i--) {
            appearingOnceNumber = appearingOnceNumber << 1;
            appearingOnceNumber = appearingOnceNumber + (res[i] % 3);
            System.out.println(appearingOnceNumber);
        }
        return appearingOnceNumber;
    }

}
