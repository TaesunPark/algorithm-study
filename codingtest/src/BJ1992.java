import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1992 {

    static int n;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        map = new int[n][n];

        for (int i=0; i<n; i++){
            String str = br.readLine();
            for (int j=0; j<n; j++){
                map[i][j] = str.charAt(j) - ('1'-1);
            }
        }

        recur(0,0,n);
        System.out.print(sb);
    }
    static void recur(int y, int x, int n){
        if (n == 1){
            sb.append(map[y][x]);
            return;
        }
        if (!check(y, x, n)){
            sb.append("(");
            recur(y, x, n/2);
            recur(y, x+(n/2), n/2);
            recur(y+(n/2), x, n/2);
            recur(y+(n/2), x+(n/2), n/2);
            sb.append(")");
        }
    }
    static boolean check(int y, int x, int n){
        int data = map[y][x];

        for (int i=y; i<y+n; i++){
            for (int j=x; j<x+n; j++){
                if (map[i][j] != data) return false;
            }
        }
        sb.append(data);
        return true;
    }
}
