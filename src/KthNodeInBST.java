// 题54：二叉搜索树的第k个结点
// 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。
//            8
//        6      10
//       5 7    9  11
public class KthNodeInBST {
    public static int k = 3;

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] argc) {
        Node head = new Node(8);
        Node node6 = new Node(6);
        Node node10 = new Node(10);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node11 = new Node(11);
        head.left = node6;
        head.right = node10;
        node6.left = node5;
        node6.right = node7;
        node10.left = node9;
        node10.right = node11;
        Dfs(head);
    }

    public static void Dfs(Node head) {
        if (head == null || k <= 0) {
            return;
        }
        if (head.right != null && k > 0) {
            Dfs(head.right);
        }
        k--;
        if (k == 0) {
            System.out.println(head.value);
            return;
        }
        if (head.left != null && k > 0) {
            Dfs(head.left);
        }
    }
}
