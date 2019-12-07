import java.util.Scanner;
// 题57（二）：为s的连续正数序列
// 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
// 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
// 4～6和7～8。
public class ContinuousSquenceWithSum {
    public static void main(String[] argc){
        Scanner in = new Scanner(System.in);
        int sum=in.nextInt();
        searchQueueSum(sum);
    }

    public static void searchQueueSum(int sum) {
        int start = 1;
        int end = 2;
        int cursor = start + end;
        int mid = (1 + sum) / 2;
        while (start < mid) {
            if(cursor == sum){
                print(start, end);
            }
            while (cursor > sum && start < mid) {
                cursor = cursor -start;

                start++;
                if(cursor == sum) {
                    print(start,end);
                }
            }

            end ++;
            cursor = cursor + end;
        }
    }

    public static void print(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
