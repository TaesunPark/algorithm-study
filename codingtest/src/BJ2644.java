import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2644 {
    //
    static int[][] map;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] a = br.readLine().split(" ");
        int x = Integer.parseInt(a[0]);
        int y = Integer.parseInt(a[1]);

        int m = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        map = new int[N+1][N+1];

        for (int i=1; i<=m; i++){
            String[] b = br.readLine().split(" ");
            int n1 = Integer.parseInt(b[0]);
            int n2 = Integer.parseInt(b[1]);
            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }
        int result = -1;
        result = dfs(x,y,0);
        System.out.printf(String.valueOf(result));
    }
    public static int dfs(int src, int dst, int cnt){
        if (src == dst){
            return cnt;
        }
        int result = -1;

        visited[src] = true;

        for (int i=1; i<=N; i++){
            if (map[src][i] == 1 && visited[i] == false){
                int k = dfs(i, dst, cnt+1);
                if (k != -1){
                    result = (result >= 0) ? Math.min(result, k):k;
                }
            }
        }
        return result;
    }
}
