import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ14284 {

    static int N,M;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        map = new int[M+1][M+1];

        for (int i=0;i<M;i++){
            String[] b = br.readLine().split(" ");
            int first = Integer.parseInt(b[0]);
            int second = Integer.parseInt(b[1]);
            int weight =  Integer.parseInt(b[2]);
            
            map[first][second] = 1;
            map[second][first] = 1;
        }
    }

    public class Node{

    }
}

