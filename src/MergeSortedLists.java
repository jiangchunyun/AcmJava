import java.util.Scanner;

// 题25：合并两个排序的链表
// 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
// 照递增排序的。
// list1: 2 6 8 9
// list2: 1 4 7 10
// res:1 2 4 6 7 8 9 10
public class MergeSortedLists {

    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value=value;
        }
    }

    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        Node headA=new Node(0);
        Node pA=headA;
        Node headB=new Node(0);
        Node pB=headB;
        for(int i=0;i<a;i++){
            int value=in.nextInt();
            Node next=new Node(value);
            pA.next=next;
            pA=pA.next;
        }

        int b=in.nextInt();
        for(int i=0;i<b;i++){
            int value=in.nextInt();
            Node next=new Node(value);
            pB.next=next;
            pB=pB.next;
        }

        Node res=mergeSortedLists(headA.next,headB.next);

        while(res!=null){
            System.out.println(res.value);
            res=res.next;
        }
    }

    /**
     * To merge two list, the res is sorted.
     * @param headA list 1 head
     * @param headB list 2 head
     * @return res head
     */
    public static Node  mergeSortedLists(Node headA,Node headB){
        Node merge=new Node(0);
        Node head=merge;
        while(headA!=null&&headB!=null){
            if(headA.value<headB.value){
                merge.next=headA;
                headA=headA.next;
            }else{
                merge.next=headB;
                headB=headB.next;
            }
            merge=merge.next;
        }
        if(headA!=null){
            while(headA!=null){
                merge.next=headA;
                headA=headA.next;
            }
        }else{
            while(headB!=null){
                merge.next=headB;
                headB=headB.next;
            }
        }
        return head.next;
    }
}
