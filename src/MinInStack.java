import java.util.Stack;
// 题30：包含min函数的栈
// 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
// 函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
public class MinInStack {
    public static void main(String[] argc){
        MinStack minStack=new MinStack();
        minStack.push(new Node(5));
        minStack.push(new Node(2));
        minStack.push(new Node(6));
        minStack.push(new Node(1));
        minStack.push(new Node(4));
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.min());
    }

    static class MinStack{
        private Stack<Node> stack=new Stack<>();
        private int min=100000;
        public void push(Node node){
            if(node.val<min){
                min=node.val;
                node.min=node.val;
            }else{
                node.min=min;
            }
            stack.push(node);
        }

        public Node pop(){
            Node popNode=stack.pop();
            min=stack.peek().min;
            return popNode;
        }

        public int min(){
            return min;
        }
    }

    static class Node{
        int val;
        int min;
        public Node(int val){
            this.val=val;
        }
    }
    /*
    5
    2
    6
    3
    4
    5
     */
}
