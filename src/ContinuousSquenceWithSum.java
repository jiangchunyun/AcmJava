import java.util.Scanner;

public class ContinuousSquenceWithSum {
    public static void main(String[] argc){
        Scanner in = new Scanner(System.in);
        int sum=in.nextInt();
        searchQueueSum(sum);
    }

    public static void searchQueueSum(int sum){
        int start = 1;
        int end = 2;
        int temp = start + end;
        while(temp != sum) {
            end ++;
            temp = temp + end;
        }
        while(start < end) {
            pirnt(start, end);
            start++;
            end--;
        }
    }

    public static void pirnt(int start,int end){
        for(int i = start; i<= end;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
