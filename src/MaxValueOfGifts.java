import java.util.Scanner;
// 题47：礼物的最大价值
// 题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值
// （价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或
// 者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计
// 算你最多能拿到多少价值的礼物？
public class MaxValueOfGifts {
    public static void main(String[] argc){
        Scanner in=new Scanner(System.in);
        int row=in.nextInt();
        int column=in.nextInt();
        int[][] matrix=new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                matrix[i][j]=in.nextInt();
            }
        }

        System.out.print(getMaxValueOfGifts(matrix,row,column));
    }
    public static int getMaxValueOfGifts(int[][] matrix,int row,int column){
        for(int i=1;i<row;i++){
            matrix[i][0]=matrix[i-1][0]+matrix[i][0];
        }
        for(int j=1;j<column;j++){
            matrix[0][j]=matrix[0][j]+matrix[0][j-1];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<column;j++){
                matrix[i][j]=max(matrix[i-1][j],matrix[i][j-1])+matrix[i][j];
            }
        }
        return matrix[row-1][column-1];
    }

    public static int max(int a,int b){
        if(a>b){
            return a;
        }
        return b;
    }
}
