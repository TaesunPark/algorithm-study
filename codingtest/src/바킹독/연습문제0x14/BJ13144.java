package 바킹독.연습문제0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13144 {
    static int N;
    static long cnt;
    static int[] list;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        check = new boolean[N+1];
        StringTokenizer str = new StringTokenizer(br.readLine());
        int en = 0;

        for (int i=0; i<N; i++){
            list[i] = Integer.parseInt(str.nextToken());
        }

        check[list[0]] = true;


        for (int st = 0; st<N; st++){
            while (en < N-1 && !check[list[en+1]]){
                en++;
                check[list[en]] = true;
            }
            cnt += (en-st+1);
            check[list[st]] = false;
        }
        System.out.print(cnt);
    }


}

