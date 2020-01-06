import java.util.Scanner;
// 题62：圆圈中最后剩下的数字
// 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
// 删除第m个数字。求出这个圆圈里剩下的最后一个数字。

public class LastNumberInCircle {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node head = new Node(in.nextInt());
        Node p = head;
        for (int i = 1; i < n; i++) {
            p.next= new Node(in.nextInt());
        }
        int m = in.nextInt();
        Node res = findLastNumber(head, m);
        System.out.println(res.value);
    }

    public static Node findLastNumber(Node head, int m) {
        Node p = head;
        Node q = head;
        int sum = 0;
        while (p.next != null) {
            if (sum == m) {
                q.next = p.next;
                sum = 0;
            }
            q = p;
            p = p.next;
        }
        return p;
    }
}
