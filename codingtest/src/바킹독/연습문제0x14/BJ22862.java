package 바킹독.연습문제0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ22862 {
    static int N;
    static int K;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmpValue = 0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N-1];

        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++){
            int value = Integer.parseInt(st.nextToken());
            if (i == K) continue;
            list[tmpValue++] = value;
        }

        int start = 0;
        int end = N-2;
        int cnt=0;

        while (start < end){

            if (start == end){
                if (list[start] % 2 == 0) cnt++;
                break;
            }

            if (list[start] % 2 == 0) cnt++;
            start++;

            if (list[end] % 2 == 0) cnt++;
            end--;
        }

        System.out.print(cnt);
    }
}
