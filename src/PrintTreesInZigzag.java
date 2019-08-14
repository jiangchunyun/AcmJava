import java.util.Stack;

// 题32（三）：之字形打印二叉树
// 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺
// 序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
// 其他行以此类推。
/*
        4
     6      5
   3   1  2   0

   4
   5 6
   3 1 2 0
 */
public class PrintTreesInZigzag {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node (int value){
            this.value=value;
        }
    }

    public static void main(String[]  argc){
        Node root=new Node(4);
        Node treeNode2=new Node(6);
        Node treeNode3=new Node(5);
        Node treeNode4=new Node(3);
        Node treeNode5=new Node(1);
        Node treeNode6=new Node(2);
        Node treeNode7=new Node(0);
        root.left=treeNode2;
        root.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;
        printTreesInZigzag(root);
    }

    public static void printTreesInZigzag(Node root){
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        s1.push(root);
        String res=""+root.value+"\n";
        while(true) {
            boolean sign = false;
            while (!s1.empty()) {
                sign = true;
                Node node = s1.pop();
                if (node.right != null) {
                    s2.push(node.right);
                    res = res + node.right.value + " ";
                }
                if (node.left != null) {
                    s2.push(node.left);
                    res = res + node.left.value + " ";
                }
            }
            if (!sign) {
                break;
            }
            sign = false;
            res = res + "\n";
            while (!s2.empty()) {
                sign = true;
                Node node = s2.pop();
                if (node.left != null) {
                    s1.push(node.left);
                    res = res + node.left.value + " ";
                }
                if (node.right != null) {
                    s1.push(node.right);
                    res = res + node.right.value + " ";
                }
            }
            if (!sign) {
                break;
            }
            res = res + "\n";
        }
        System.out.print(res);
    }

}
