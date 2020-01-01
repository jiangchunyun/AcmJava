import java.util.HashMap;
import java.util.Scanner;

// 题60：n个骰子的点数
// 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s
// 的所有可能的值出现的概率。
public class DicesProbability {
    public static int n = 0;
    public static HashMap<Integer, Integer> res = new HashMap<>();

    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        calDicesProbability(0,1);
        res.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }

    public static void calDicesProbability(int sum, int size) {
        if (size > n) {
            if (res.get(sum) != null) {
                res.put(sum, res.get(sum) + 1);
            } else {
                res.put(sum, 1);
            }
            return;
        }

        for (int i = 1; i <= 6; i++) {
            calDicesProbability(sum + i, size + 1);
        }

    }
}
