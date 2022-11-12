package 바킹독.DP;

import java.util.Arrays;
import java.util.Scanner;

public class BJ12852 {
    public static void main(String[] args) {
        int n;
        int tmpN;
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tmpN = n;

        int[] dp = new int[1000001];
        int[] arr = new int[1000001];

        Arrays.fill(dp, 1000001);
        dp[n] = 0;

        for (int i = n; i >= 1; i--){
            dp[i - 1] = Math.min(dp[i] + 1, dp[i - 1]);

            if(dp[i - 1] == dp[i] + 1){
                arr[i - 1] = 1;
            }

            if(i % 2 == 0){
                dp[i / 2] = Math.min(dp[i] + 1, dp[i / 2]);

                if(dp[i / 2] == dp[i] + 1){
                    arr[i / 2] = 2;
                }
            }

            if(i % 3 == 0){
                dp[i / 3] = Math.min(dp[i] + 1, dp[i / 3]);

                if(dp[i / 3] == dp[i] + 1){
                    arr[i / 3] = 3;
                }
            }
        }

        int start = 1;
        sb.append(start + " ");

        while(true){
            if (arr[start] == 1){
                start += 1;
            } else{
                start *= arr[start];
            }
            sb.append(start + " ");
            if (start == n) break;
        }

        String[] result = sb.toString().split(" ");

        if(n == 1){
            System.out.println(0);
            System.out.println(1);
            return;
        }

        System.out.println(dp[1]);

        for (int i = result.length - 1; i >= 0; i--){
            System.out.print(result[i] + " ");
        }

    }
}
