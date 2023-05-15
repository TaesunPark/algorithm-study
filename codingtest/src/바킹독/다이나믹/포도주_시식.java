package 바킹독.다이나믹;

import java.util.Scanner;

public class 포도주_시식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        if (n == 1){
            System.out.print(arr[1]);
            return;
        }

        if (n == 2){
            System.out.print(arr[1] + arr[2]);
            return;
        }

        dp[1] = arr[1];

        if (n > 1){
            dp[2] = arr[1] + arr[2];
        }

        for(int i=3; i<=n; i++){
            //연속 0 번 마신경우 	//연속 1번 마신경우 //연속 2번마신 경우
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]));

        }

        System.out.print(dp[n]);
    }
}
