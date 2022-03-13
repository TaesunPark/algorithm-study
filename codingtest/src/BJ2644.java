import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ2644{
    static int N;
    static int[][] map;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        check = new boolean[N+1];

        String[] a = br.readLine().split(" ");
        int start = Integer.parseInt(a[0]);
        int finish = Integer.parseInt(a[1]);
        int M = Integer.parseInt(br.readLine());

        for(int i=1; i<=M; i++){
            String[] b = br.readLine().split(" ");
            int s = Integer.parseInt(b[0]);
            int f = Integer.parseInt(b[1]);
            map[s][f] = 1;
            map[f][s] = 1;
        }
        int result = -1;
        result = dfs(start, finish, 0);
        System.out.printf(String.valueOf(result));
    }
    public static int dfs(int src, int dst, int cnt){
        if (src == dst){
            return cnt;
        }
        int result = -1;
        check[src] = true;

        for(int i=0; i<N; i++){
            if (check[i] == false && map[src][i] == 1){
                int con = dfs(i, dst, cnt+1);
                if (con != -1){
                    result = (result >= 0) ? Math.min(result, con):con;
                }
            }
        }
        return result;
    }
}