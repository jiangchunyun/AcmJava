// 题40：最小的k个数
// 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
// 这8个数字，则最小的4个数字是1、2、3、4。
public class KLeastNumbers {
    public static void main(String[] argc){

    }

    int[] getKLeastNumbers(int[] numbers,int n){
        for(int i=1;i<numbers.length;i++){
            int currentNumber=numbers[i];
            int j=0;
            if(i<n){
                j=i-1;
            }else{
                j=n;
            }
            for(;j>=0;j--){
                if(currentNumber>numbers[j]){
                    int temp=currentNumber;
                    currentNumber=numbers[j];
                    numbers[j]=temp;
                    break;
                }
            }
        }
        return numbers;
    }
}
