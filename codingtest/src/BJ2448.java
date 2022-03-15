import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2448 {
    public static int n;
    public static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        n = Integer.parseInt(br.readLine()); // 24
        map = new char[n*2][n*2];

        for (int i=0; i<n*2;i++){
            for(int j=0; j<n*2; j++){
                map[i][j] = ' ';
            }
        }
        stamp(0, n-1,n);

        for (int i=0; i<n*2;i++){
            for(int j=0; j<n*2; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void stamp(int y, int x, int n){

        if (n == 3){
                map[y][x] = '*';
                map[y+1][x-1]='*';
                map[y+1][x+1]='*';
                map[y+2][x-2]='*'; map[y+2][x-1]='*'; map[y+2][x]='*'; map[y+2][x+1]='*';map[y+2][x+2]='*';
            return;
        }

        stamp(y, x, n/2);
        stamp(y+n/2, x-n/2, n/2);
        stamp(y+n/2, x+n/2, n/2);
    }
}

