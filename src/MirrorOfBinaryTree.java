public class MirrorOfBinaryTree {


    // 题27：二叉树的镜像
    // 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
    //例如：
    /*
          0             0
        1   2        2     1
     3    4              4   3

    */
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value=value;
        }
    }

    public static void main(String[] argc){
        Node treeA=new Node(0);
        Node treeA1=new Node(1);
        Node treeA2=new Node(2);
        Node treeA3=new Node(3);
        Node treeA4=new Node(4);
        treeA.left=treeA1;
        treeA.right=treeA2;
        treeA1.left=treeA3;
        treeA1.right=treeA4;
        mirrorOfBinaryTree(treeA);
        printTree(treeA);
    }

    public  static void mirrorOfBinaryTree(Node head){
        if(head==null){
            return;
        }
        Node temp=head.left;
        head.left=head.right;
        head.right=temp;
        mirrorOfBinaryTree(head.left);
        mirrorOfBinaryTree(head.right);
    }

    public static void printTree(Node head){
        if(head==null){
            return;
        }
        System.out.println(head.value);
        printTree(head.left);
        printTree(head.right);
    }
}
