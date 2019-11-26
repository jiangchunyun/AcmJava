public class BalancedBinaryTree {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] argc) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        Node node5 = new Node(2);
        Node node6 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node2.left = node5;
        node5.left = node6;
        System.out.println(treeDepth(node1, 0));
    }

    public static boolean isBalancedBinaryTree(Node head) {
        return false;
    }

    public static int treeDepth(Node head, int dp) {
        if (head == null) {
            return dp;
        }

        int leftDp = dp;
        int rightDp = dp;

        if (head.left != null) {
            leftDp = treeDepth(head.left, dp + 1);
        }

        if (head.right != null) {
            rightDp = treeDepth(head.right, dp + 1);
        }

        return Math.max(leftDp, rightDp);
    }
}
