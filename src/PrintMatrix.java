import java.util.Scanner;
// 题29：顺时针打印矩阵
// 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
/*
    1 2 3 4
    5 6 7 8
    9 4 6 4
*/
public class PrintMatrix {
    public static int n;
    public static int m;
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();
        int [][] matrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=in.nextInt();
            }
        }
        printMatrix(matrix,0,0);

    }

    public static void printMatrix(int[][] matrix,int row,int col){
        if(row<0||row>=n||col<0||col>=m||matrix[row][col]==-100){
            return;
        }
        System.out.println(matrix[row][col]);
        matrix[row][col]=-100;
        printMatrix(matrix,row+1,col);
        printMatrix(matrix,row,col+1);
        printMatrix(matrix,row-1,col);
        printMatrix(matrix,row,col-1);
    }
}
