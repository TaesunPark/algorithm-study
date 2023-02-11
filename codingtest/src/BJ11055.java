import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ11055 {

    static int N;
    static int[] list;
    static Integer[] dp;

    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        list = new int[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++){
            list[i] = sc.nextInt();
        }

        dp[0] = list[0];

        for (int i = 1; i < N; i++){
            dp[i] = list[i];
            for (int j = 0; j < i; j++){
                if (list[i] > list[j]){
                    dp[i] = Math.max(dp[j] + list[i], dp[i]);
                }
            }
        }

        Arrays.sort(dp, Collections.reverseOrder());
        System.out.print(dp[0]);
    }
}
