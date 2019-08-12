import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

// 题32（二）：分行从上到下打印二叉树
// 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
/*
           8
        4     7
      1   5
 */
public class PrintTreesInLines {
    public static class Node{
        int value;
        int level=0;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
        }
    }

    public static void main(String[] argc){
        Node root=new Node(8);
        Node treeNode2=new Node(4);
        Node treeNode3=new Node(7);
        Node treeNode4=new Node(1);
        Node treeNode5=new Node(5);
        root.left=treeNode2;
        root.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        printTreesInLines(root);
    }

    public static void printTreesInLines(Node root){
            Queue<Node> queue=new LinkedBlockingQueue<>();
            queue.add(root);
            int level=0;
            while(!queue.isEmpty()){
                Node node=queue.poll();
                if(node.level!=level){
                    System.out.print("\n"+node.value+" ");
                    level=node.level;
                }else{
                    System.out.print(node.value+" ");
                }
                if(node.left!=null){
                    node.left.level=node.level+1;
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    node.right.level=node.level+1;
                    queue.add(node.right);
                }
            }
    }
}
