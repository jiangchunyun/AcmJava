import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
// 题32（一）：不分行从上往下打印二叉树
// 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
/*
           1
       2       3
    4    5   6   7
 */
public class PrintTreeFromTopToBottom {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
        }
    }
    public static void main(String[] argc){
        Node root=new Node(1);
        Node treeNode2=new Node(2);
        Node treeNode3=new Node(3);
        Node treeNode4=new Node(4);
        Node treeNode5=new Node(5);
        Node treeNode6=new Node(6);
        Node treeNode7=new Node(7);
        root.left=treeNode2;
        root.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;
        printTreeFromTopToBottom(root);


    }

    public static void printTreeFromTopToBottom(Node root){
        Queue<Node> queue=new LinkedBlockingQueue<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node=queue.poll();
            System.out.println(node.value);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null) {
                queue.add(node.right);
            }
        }
    }
}
