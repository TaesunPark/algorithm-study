import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭
public class BJ12865 {
    public static void main(String[] args) throws IOException {
        int N, W; 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N][W+1];
        Node[] back = new Node[N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            back[i] = new Node(w, v);
        }

        for (int i = 0; i <= W; i++){
            Node node = back[0];
            if (node.w <= i){
                dp[0][i] = node.k;
            }
        }

        for (int i = 1; i < N; i++){
            Node node = back[i];
            for (int j = 0; j <= W; j++){
                dp[i][j] = dp[i-1][j];

                if (node.w <= j){
                    dp[i][j] = Math.max(dp[i][j], node.k + dp[i-1][j - node.w]);
                }
            }
        }

        System.out.print(dp[N-1][W]);

    }
    public static class Node{
        int w;
        int k;
        public Node(int w, int k){
            this.w = w;
            this.k = k;
        }
    }
}
