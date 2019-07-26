import java.util.Scanner;
// 链表中环的入口结点
// 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
// 环的入口结点是结点3。
public class FindLoopEnterNode {

    public static class Node{
        public int value;
        public Node next;
        public boolean sign=false;
        public Node(int value){
            this.value=value;
        }
    }

    public static void main(String[] argc){
        Node head=new Node(0);
        Node first=new Node(1);
        Node second=new Node(2);
        Node third=new Node(3);
        Node four=new Node(4);
        Node five=new Node(5);
        head.next=first;
        first.next=second;
        second.next=third;
        third.next=four;
        four.next=five;
        five.next=five;
        Node res=findLoopEnterNode(head);
        System.out.print(res.value);
    }

    public static Node findLoopEnterNode(Node head){
        Node enterNode=head;
        while(head!=null){
            if(head.sign==true){
                enterNode=head;
                break;
            }else{
                head.sign=true;
                head=head.next;
            }
        }
        return enterNode;
    }
}
