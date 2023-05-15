import java.util.Scanner;

public class BJ17484 {

    static int[][] map;
    static int[][] dp;
    static int[][] dir;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt(); // 세로
        M = sc.nextInt(); // 가로
        map = new int[N][M];
        dp = new int[N][M];
        dir = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
                dp[i][j] =Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++){
            dp[0][i] = map[0][i];
            dir[0][i] = -1;
        }

        for (int i = 1; i < N; i++){
            for (int j = 0; j < M; j++){

                if (dir[i-1][j] != 1) {
                    dp[i][j] = Math.min(dp[i - 1][j] + map[i][j], dp[i][j]);
                    dir[i][j] = 1;
                }

                if (j - 1 >= 0){
                    if (dir[i-1][j-1] != 0) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + map[i][j], dp[i][j]);
                        dir[i][j] = 0;
                    }
                }

                if (j + 1 < M){
                    if (dir[i-1][j+1] != 2) {
                        dp[i][j] = Math.min(dp[i - 1][j + 1] + map[i][j], dp[i][j]);
                        dir[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                System.out.print(dir[i][j] + " ");
            }
            System.out.println("");
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++){
            min = Math.min(dp[N - 1][i], min);
        }



        System.out.println(min);

    }
}
