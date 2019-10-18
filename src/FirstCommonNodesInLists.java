// 题52：两个链表的第一个公共结点
// 题目：输入两个链表，找出它们的第一个公共结点。
// 第一个公共结点在链表中间
// 1 - 2 - 3 \
//            6 - 7
//     4 - 5 /
public class FirstCommonNodesInLists {
    public static class Node{
        int value;
        int times=0;
        Node next;
        public Node(int value){
            this.value=value;
        }
    }
    public static void main(String[] argc){
        Node one=new Node(1);
        Node two=new Node(2);
        Node three=new Node(3);
        Node four=new Node(4);
        Node five=new Node(5);
        Node six=new Node(6);
        Node seven=new Node(7);

        Node first=one;
        first.next=two;
        two.next=three;
        three.next=six;
        six.next=seven;

        Node second=four;
        second.next=five;
        five.next=six;

        System.out.println(getFirstCommonNodesInLists(first,second).value);
    }

    public static Node getFirstCommonNodesInLists(Node first,Node second){
        Node p=first;
        while(p!=null){
            p.times++;
            p=p.next;
        }
        p=second;
        while(p!=null){
            if(p.times==1){
                return p;
            }
            p=p.next;
        }
        return null;
    }
}
