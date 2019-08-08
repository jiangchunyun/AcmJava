import java.util.Scanner;
import java.util.Stack;

// 题31：栈的压入、弹出序列
// 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
// 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
// 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
// 4、3、5、1、2就不可能是该压栈序列的弹出序列。
public class StackPushPopOrder {
    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] stack = new int[n];
        int[] popOrder = new int[n];
        for (int i = 0; i < n; i++) {
            stack[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            popOrder[i] = in.nextInt();
        }
        System.out.println(isStackPushPopOrder(stack, popOrder));
    }

    public static boolean isStackPushPopOrder(int[] inputOrder, int[] popOrder) {
        int n = inputOrder.length;
        int position = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!stack.empty() && stack.peek().intValue() == popOrder[i]) {
                stack.pop();
            } else if (position == n && stack.peek().intValue() != popOrder[i]) {
                return false;
            } else {
                boolean sign = false;
                while (position < n && inputOrder[position] != popOrder[i]) {
                    stack.push(inputOrder[position]);
                    position++;
                    sign = true;
                }
                if (sign && position == n) {
                    return false;
                } else {
                    position++;
                }
            }

        }
        return true;
    }
}
