import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9633 {
    public static int[][] map;
    public static int n;
    public static boolean[] isUsed1;
    public static boolean[] isUsed2;
    public static boolean[] isUsed3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        isUsed1 = new boolean[30];
        isUsed2 = new boolean[30];
        isUsed3 = new boolean[30];


    }
}
