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

        System.out.println(findNumberAppearingOnce(numbers));

    }

    public static int findNumberAppearingOnce(int[] numbers) {
        int length = numbers.length;
        int[] res = new int[32];
        for (int i = 0; i < length; i++) {
            int bit=1;
            for (int j = 0; j < 32; j++) {
                int temp = numbers[i] & bit;
                if (temp != 0) {
                    res[j] = res[j] + 1;
                }
                bit = bit << 1;
            }
        }

        int appearingOnceNumber = 0;
        for (int i = 31; i >= 0; i--) {
            appearingOnceNumber = appearingOnceNumber << 1;
            appearingOnceNumber = appearingOnceNumber + (res[i] % 3);
        }
        return appearingOnceNumber;
    }

}
