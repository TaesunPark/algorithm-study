import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {

    static int[][] map;
    static int n;
    static int blue_cnt;
    static int white_cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()){
                map[i][j++]= Integer.parseInt(st.nextToken());
            }
        }
        recur(0,0,n);
        System.out.println(white_cnt);
        System.out.println(blue_cnt);
    }

    public static void recur(int y, int x, int n){
        if (n == 1){
            int data = map[y][x];

            if (data == 1)
                blue_cnt++;
            else
                white_cnt++;
            return;
        }
        if (!check(y, x, n)){
            recur(y, x, n/2); // 2사분면
            recur(y, x+(n/2), n/2);
            recur(y+(n/2), x, n/2);
            recur(y+(n/2), x+(n/2), n/2);
        }
    }

    public static boolean check(int y, int x, int n){
        int data = map[y][x];

        for (int i=y; i<n+y; i++){
            for (int j=x; j<n+x; j++){
                if (map[i][j] != data){
                    return false;
                }
            }
        }

        if (data == 1)
            blue_cnt++;
        else
            white_cnt++;
        return true;
    }
}
