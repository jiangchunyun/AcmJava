
// 题28：对称的二叉树
// 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
// 它的镜像一样，那么它是对称的。
//例如：
/*
        2
    3       3
 1    2   2    1

*/
public class SymmetricalBinaryTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value=value;
        }
    }

    public static void main(String[] argc){
        Node root=new Node(0);
        Node oneNode=new Node(2);
        Node twoNode=new Node(1);
        root.left=oneNode;
        root.right=twoNode;
        System.out.println(isSymmetricalBinaryTree(root,root));
    }

    public static boolean isSymmetricalBinaryTree(Node left,Node right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.value!=right.value){
            return false;
        }
        return isSymmetricalBinaryTree(left.left,right.right)&&isSymmetricalBinaryTree(left.right,right.left);
    }
}
