// 题55（一）：二叉树的深度
// 题目：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的
// 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
public class TreeDepth {
    public static class Node{
        int value;
        Node right;
        Node left;
        public Node(int value){
            this.value=value;
        }
    }
    public static int MAX_DEPTH = 0;
    public static void main(String[] argc){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        Node node5 = new Node(2);
        Node node6 = new Node(3);
        node1.left=node2;
        node1.right=node3;
        node2.right=node4;
        node2.left=node5;
        node5.left=node6;
        treeDepth(node1,0);
        System.out.println(MAX_DEPTH);

    }
    public static void treeDepth(Node root, int dp){
        if (root == null) {
            return;
        }
        MAX_DEPTH = dp >= MAX_DEPTH ? dp : MAX_DEPTH;
        if (root.left != null) {
            treeDepth(root.left,dp + 1);
        }

        if(root.right != null) {
            treeDepth(root.right,dp + 1);
        }
    }
}
