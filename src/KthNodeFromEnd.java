import java.util.Scanner;
// 题22：链表中倒数第k个结点
// 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
// 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
// 值为4的结点。
public class KthNodeFromEnd {
    public static class Node{
        public Node(int val){
            this.val=val;
        }
        int val;
        Node next;
    }

    public static void main(String[] argc){
        int n;
        int k;
        Scanner in=new Scanner(System.in);
        Node head=new Node(0);
        Node p=head;
        n=in.nextInt();
        for(int i=0;i<n;i++){
            int val;
            val=in.nextInt();
            p.next=new Node(val);
            p=p.next;
        }
        k=in.nextInt();
        printKthNodeFromEnd(head.next,k);

    }

    public static Node printKthNodeFromEnd(Node head,int k){
        Node q=head;
        Node p=head;
        while(p!=null){
            if(k>0){
                p=p.next;
            }else if(k<0){
                p=p.next;
                q=q.next;
            }
            k--;
        }
        System.out.print("The kth node is ");
        System.out.print(q.val);
        return head;
    }
}
