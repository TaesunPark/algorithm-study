import java.util.Scanner;

public class BJ14501 {

    static int N;
    static int[] Ti;
    static int[] Pi;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Ti = new int[N+2];
        Pi = new int[N+2];
        dp = new int[N+2];

        for (int i = 0; i < N; i++){
            Ti[i] = sc.nextInt();
            Pi[i] = sc.nextInt();
        }

        int max = 0;

        for (int i = 0; i < N; i++){
            max = Math.max(dp[i], max);
            if (Ti[i] + i > N) continue;
            dp[Ti[i] + i] = Math.max(dp[Ti[i] + i], Pi[i] + max);
        }

        System.out.print(max);
    }
}
