// 题36：二叉搜索树与双向链表
// 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
// 不能创建任何新的结点，只能调整树中结点指针的指向。
/*
           10
       7        15
    3    9    12   18
 */
public class ConvertBinarySearchTree {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
        }
    }
    public static Node lastNode=null;
    public static void main(String[] argc){
        Node root=new Node(10);
        Node oneNode=new Node(7);
        Node twoNode=new Node(15);
        Node threeNode=new Node(3);
        Node fourNode=new Node(9);
        Node fiveNode=new Node(12);
        Node sixNode=new Node(18);
        root.left=oneNode;
        root.right=twoNode;
        oneNode.left=threeNode;
        oneNode.right=fourNode;
        twoNode.left=fiveNode;
        twoNode.right=sixNode;
        convertBinarySearchTree(root);
        while(lastNode!=null){
            System.out.println(lastNode.value);
            lastNode=lastNode.left;
        }
    }
    public static void convertBinarySearchTree(Node root)
    {
        if(root==null){
            return;
        }
        convertBinarySearchTree(root.left);
        root.left=lastNode;
        if(lastNode!=null){
            lastNode.right=root;
        }
        lastNode=root;
        convertBinarySearchTree(root.right);
    }
}
