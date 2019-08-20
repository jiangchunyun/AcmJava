// 题34：二叉树中和为某一值的路径
// 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
// 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
/*
        4
     6      5
   3   1  2   0


 */
public class PathInTree {
    public static StringBuilder path=new StringBuilder();
    public static class Node{
        int value;
        Node right;
        Node left;
        public Node(int value){
            this.value=value;
        }
    }

    public static void main(String[] argc){
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
        pathInTree(root,0,13);
    }

    public static void pathInTree(Node root,int value,int number){
        if(root.left==null&&root.right==null){
            value=value+root.value;
            path.append(root.value);
            if(value==number){
                System.out.println(path.toString());
            }
            if(path.length()>0){
                path.deleteCharAt(path.length()-1);
            }
            return;
        }

        path.append(root.value);
        value=value+root.value;
        pathInTree(root.left,value,number);
        pathInTree(root.right,value,number);
        path.deleteCharAt(path.length()-1);
    }
}
