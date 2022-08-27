package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2531 {

    static boolean[] check;
    static int[] list;
    static int N;
    static int k;
    static int d;
    static int c;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        list = new int[N];
        check = new boolean[3001];

        for (int i=0; i<N; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<N; i++){
            int start = i;
            int cnt = 0;
            int index = 0;
            check = new boolean[3001];
            for (int j=start; j<start+k;j++){
                index = j % N;
                if (check[list[index]] == false){
                    cnt++;
                    check[list[index]] = true;
                }
            }
            if (check[c] == false) cnt++;
            max = Math.max(max, cnt);
        }

        System.out.print(max);

    }
}
