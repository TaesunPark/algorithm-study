import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ11053 {

    static int N;
    static int[] list;
    static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        list = new int[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++){
            list[i] = sc.nextInt();
        }

        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++){
            for (int j = 0; j < i; j++){
                if (list[i] > list[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp, Collections.reverseOrder());
        System.out.print(dp[0]);
    }
}
