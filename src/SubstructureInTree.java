import java.util.ArrayDeque;
import java.util.Queue;

// 题26：树的子结构
// 输入两棵二叉树A和B，判断B是不是A的子结构。
public class SubstructureInTree {

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

        Node treeB=new Node(0);
        Node treeB1=new Node(1);

        treeA.left=treeA1;
        treeA.right=treeA2;
        treeA2.right=treeA3;

        treeB.left=treeB1;

        System.out.println(substructureInTree(treeA,treeB));
    }

    public static boolean substructureInTree(Node treeA,Node treeB){
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(treeA);
        boolean res=false;
        while(!queue.isEmpty()){
            Node node=queue.peek();
            if(node.value==treeB.value){
                res=equalsTree(node,treeB);
            }
            if(res){
                return true;
            }
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            queue.poll();
        }
        return false;
    }

    public static boolean equalsTree(Node treeA,Node treeB ){
        if(treeA==null||treeB==null){
            return true;
        }
        if(treeA.value!=treeB.value){
            return false;
        }
        return equalsTree(treeA.left,treeB.left)&&equalsTree(treeA.right,treeB.right);
    }
}
