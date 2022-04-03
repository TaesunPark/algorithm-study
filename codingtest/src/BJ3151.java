import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3151 {
    static int n;
    static int[] list;
    static int cnt;
    static int[] data;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        data = new int[3];
        check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx =0;
        while (st.hasMoreTokens()){
            list[idx++] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.print(cnt);
    }
    public static void dfs(int depth, int index){
        if (depth == 3){
            int sum = 0;
            for (int i=0; i<3;i++){
                sum += data[i];
            }
            if (sum == 0){
                cnt++;
            }
            return;
        }

        for (int i=index; i<n; i++){
            if (check[i] == true) continue;
            check[i] = true;
            data[depth] = list[i];
            dfs(depth+1, i);
            check[i] = false;
        }

    }
}
