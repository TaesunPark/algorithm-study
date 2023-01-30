package 바킹독.다이나믹;

import java.util.Scanner;

public class BJ9095 {

    public static int N;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int loop = N;

        while (loop-- > 0) {
            int M = sc.nextInt();
            dp = new int[M + 1];
            if(M == 1){
                System.out.println("1");
                continue;
            }
            if(M == 2){
                System.out.println("2");
                continue;
            }
            if(M == 3){
                System.out.println("4");
                continue;
            }

            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i <= M; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            System.out.println(dp[M]);
        }
    }
}
