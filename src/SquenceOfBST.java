import java.util.Scanner;

// 题33：二叉搜索树的后序遍历序列
// 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
/*
            6
        4       8
     1     5

     1 5 4 8 6
 */
public class SquenceOfBST {
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] squence=new int[n];
        for(int i=0;i<n;i++){
            squence[i]=in.nextInt();
        }
        System.out.print(isSquenceOfBST(squence,n-1,0,n-1));
    }

    public static boolean isSquenceOfBST(int[] squence,int root, int left,int right){
        if(left==right){
            return true;
        }
        int mid=left;
        int i=0;
        for( i=left;i<=right;i++){
            if(squence[root]<squence[i]){
                mid=i;
                break;
            }
        }
        int j=i;
        for(;j<=right;j++){
            if(squence[j]<squence[root]){
                return false;
            }
        }
        boolean resLeft=true;
        boolean resRight=true;
        if(i>0){
            resLeft=isSquenceOfBST(squence,mid-1,left,mid-1);
        }
        if(j<=right){
            resRight=isSquenceOfBST(squence,right,mid+1,right);
        }
        return resLeft&&resRight;
    }
}
