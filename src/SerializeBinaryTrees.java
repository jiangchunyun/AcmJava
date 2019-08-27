// 题37：序列化二叉树
// 题目：请实现两个函数，分别用来序列化和反序列化二叉树
/*
         8
     6       9
  5     4

  //8 6 5 ! ! 4 ! 9 !
 */
public class SerializeBinaryTrees {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
        }
    }
    static int index=0;
    public static void main(String[] argc){
        StringBuilder str=new StringBuilder("");
        Node root=new Node(8);
        Node treeNode2=new Node(6);
        Node treeNode3=new Node(9);
        Node treeNode4=new Node(5);
        Node treeNode5=new Node(4);
        root.left=treeNode2;
        root.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        serialize(root,str);
        System.out.println(str.toString());
        String[] numbers=str.toString().split(" ");
        Node p=deserialize(numbers);
        print(p);
    }

    public static void serialize(Node root,StringBuilder str){
        if(root==null){
            str.append("! ");
            return;
        }
        str.append(root.value);
        str.append(" ");
        serialize(root.left,str);
        serialize(root.right,str);
    }
    public static Node deserialize(String[] numbers){
        if(numbers[index].equals("!")){
            index++;
            return null;
        }
        Node node = new Node(Integer.valueOf(numbers[index]));
        index++;
        node.left=deserialize(numbers);
        node.right=deserialize(numbers);
        return node;
    }

    public static void print(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.value);
        if(root.left!=null){
            print(root.left);
        }
        if(root.right!=null){
            print(root.right);
        }
    }
}
