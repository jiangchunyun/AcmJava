import java.util.Scanner;
// 题44：数字序列中某一位的数字
// 题目：数字以0123456789101112131415…的格式序列化到一个字符序列中。在这
// 个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一
// 个函数求任意位对应的数字。
public class DigitsInSequence {
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(search(n));
    }
    public static char search(int index){
        int range=10;
        int wight=10;
        int base=1;
        while(range<index){
            index=index-range;
            int nextWight=wight*10;
            base++;
            range=base*(nextWight-wight);
            wight=wight*10;
        }
        Integer num=index/base;
        return num.toString().charAt(num%base+1);
    }

}
