package 바킹독.연습문제0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2003 {

    static int N;
    static int M;
    static int[] list;
    static int sum = 0;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new int[N];

        for (int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N-1; i++){
            sum = 0;
            sum += list[i];
            if (sum == M){
                cnt++;
                continue;
            }
            for (int j=i+1; j<N; j++){
                sum += list[j];

                if (sum == M){
                    cnt++;
                    break;
                } else if(sum > M){
                    break;
                }
            }
        }

        if (list[N-1] == M) cnt++;

        System.out.print(cnt);
    }
}
