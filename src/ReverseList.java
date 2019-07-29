import java.util.Scanner;
// 题24：反转链表
// 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
// 头结点。
public class ReverseList {

    public static class Node{
        public int value;//node value.
        public Node next;//list next node.
        public Node(int value){
            this.value=value;
        }
    }


    public static void main(String[] argc){
        Scanner in = new Scanner(System.in);
        Node head=new Node(0);
        Node p=head;
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int value=in.nextInt();
            Node next=new Node(value);
            p.next=next;
            p=p.next;
        }
        Node res=ReverseList(head.next);
        while(res!=null){
            System.out.println(res.value);
            res=res.next;
        }
    }

    /**
     * this function is to reverse list.
     * @param head list head
     * @return reverse list head.
     */
    public static Node ReverseList(Node head){
        if(head.next==null||head==null){
            return head;
        }
        Node p=head.next;//the current node next node.
        Node q=null;//the current node pre node.
        while(head.next!=null){
            head.next=q;
            q=head;
            head=p;
            p=p.next;
        }
        head.next=q;
        return head;
    }
}
