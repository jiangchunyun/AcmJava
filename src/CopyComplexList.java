// 题35：复杂链表的复制
// 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复
// 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
// 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。

public class CopyComplexList {
    public static class Node{
        int value;
        Node next;
        Node sbiling;
        Node (int value){
            this.value=value;
        }
    }
    public static void main(String[] argc){

    }
    public static Node copy(Node head){
        Node p=head;
        while(p!=null){
            Node copyNode=new Node(p.value);
            copyNode.next=p.next;
            p.next=copyNode;
            p=copyNode.next;
        }
        Node q=head.next;
        p=head;
        while(p!=null)
        {
            if(p.sbiling!=null) {
                q.sbiling = p.sbiling.next;
            }
            p=q.next;
            q=p.next;
        }
        Node copyHead=head.next;
        p=copyHead;
        q=p.next.next;
        while(p!=null){
            p.next=q;
            p=q;
            q=q.next.next;

        }
        return copyHead;
    }
}
