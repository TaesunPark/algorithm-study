import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2447 {
    static int n;
    static char[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        map = new char[n][n];

        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++){
                map[i][j] = ' ';
            }
        }

        recur(0,0,n);

        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    public static void recur(int y, int x, int n){
        if (n == 3){
            for (int i = y; i<n+y; i++){
                for (int j = x; j<n+x; j++){
                    map[i][j] = '*';
                    if (i == 1 + y && j == 1 + x)
                        map[i][j] = ' ';
                }
            }
            return;
        }
        recur(y,x,n/3);
        recur(y,x+(n/3),n/3);
        recur(y,x+2*(n/3),n/3);
        recur(y+(n/3),x,n/3);
        recur(y+(n/3),x+2*(n/3),n/3);
        recur(y+2*(n/3),x,n/3);
        recur(y+2*(n/3),x+(n/3),n/3);
        recur(y+2*(n/3),x+2*(n/3),n/3);
    }
}
