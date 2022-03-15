import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1780 {
    static int n;
    static int[][] map;
    static int zero;
    static int minus;
    static int plus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 0;

            while (st.hasMoreTokens()){
                map[i][index++] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0,0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    static void recur(int y, int x, int n){
        if (n == 1){
            int data = map[y][x];

            if (data == -1){
                minus++;
            } else if(data == 0){
                zero++;
            } else{
                plus++;
            }
            return;
        }

        if (!check(y, x, n)){
            recur(y, x, n/3);
            recur(y, x+(n/3), n/3);
            recur(y, x+(2*(n/3)), n/3);
            recur(y+(n/3), x, n/3);
            recur(y+(2*(n/3)), x, n/3);
            recur(y+(n/3), x+(n/3), n/3);
            recur(y+(n/3), x+(2*(n/3)), n/3);
            recur(y+(2*(n/3)), x+(n/3), n/3);
            recur(y+(2*(n/3)), x+(2*(n/3)), n/3);
        }
    }

    static boolean check(int y, int x, int n){
        int data = map[y][x];

        for (int i=y; i<y+n; i++){
            for (int j=x; j<x+n; j++){
                if (map[i][j] != data) return false;
            }
        }
        if (data == -1){
            minus++;
        } else if(data == 0){
            zero++;
        } else{
            plus++;
        }
        return true;
    }
}
