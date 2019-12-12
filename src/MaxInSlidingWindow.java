import java.util.ArrayList;
import java.util.Scanner;

public class MaxInSlidingWindow {
    public static void main(String[] argc){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i]=in.nextInt();
        }
        int windowSize = in.nextInt();
        ArrayList res = maxInWindows(array,windowSize);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
    public static ArrayList maxInWindows(int[] array, int windowSize) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = windowSize; i <= array.length; i++){
            int max = array[i-1];
            for(int j = i - windowSize;j < i - 1; j++){
                if(max<array[j]){
                    max = array[j];
                }
            }
            res.add(max);
        }
        return res;
    }
}
