import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ거리 {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] str = new char[N + 1];
        long[] dp = new long[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        String str1 = br.readLine();
        str = str1.toCharArray();

        for (int i = 0; i < N; i++){
            if(str[i] == 'B'){
                for (int j = i + 1; j < N; j++){
                    if (str[j] == 'O'){
                        dp[j] = Math.min(dp[j], (j - i) * (j - i) + dp[i]);
                    }
                }
            }
            else if(str[i] == 'O'){
                for (int j = i + 1; j < N; j++){
                    if (str[j] == 'J'){
                        dp[j] = Math.min(dp[j], (j - i) * (j - i) + dp[i]);
                    }
                }
            }
            else if(str[i] == 'J'){
                for (int j = i + 1; j < N; j++){
                    if (str[j] == 'B'){
                        dp[j] = Math.min(dp[j], (j - i) * (j - i) + dp[i]);
                    }
                }
            }
        }

        if (dp[N-1] == Integer.MAX_VALUE){
            System.out.print("-1");
        } else{
            System.out.print(dp[N-1]);
        }
    }
}
