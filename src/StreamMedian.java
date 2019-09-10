import java.util.PriorityQueue;
// 题41：数据流中的中位数
// 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
// 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
// 那么中位数就是所有数值排序之后中间两个数的平均值。
public class StreamMedian {
    public static PriorityQueue<Integer> maxHap=new PriorityQueue<>((o1,o2)->o2-o1);
    public static PriorityQueue<Integer> minHap=new PriorityQueue<>();
    public static int n=0;
    public static void main(String[] argc){
        n++;
        insert(new Integer(1));
        n++;
        insert(new Integer(6));
        n++;
        insert(new Integer(3));
        n++;
        insert(new Integer(5));
        System.out.println(getStreamMedian());
    }
    public static void insert(Integer num){
        if(n%2==0){
            minHap.offer(num);
            maxHap.offer(minHap.poll());
        }else{
            maxHap.offer(num);
            minHap.offer(maxHap.poll());
        }
    }
    public static Integer getStreamMedian(){
        if(n%2==0){
            return(minHap.peek()+maxHap.peek())/2;
        }else{
            return minHap.peek();
        }
    }
}
