package 바킹독.연습문제0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20922 {
    static int N;
    static int K;
    static int[] list;
    static int[] check;
    static int max=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];
        check = new int[100001];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int left=0;
        int right = 0;
        int cnt = 0;

        while (left <= right){
            if (right<=N-1 && check[list[right]] < K){
                check[list[right]]++;
                right++;
            } else if(check[list[right]] == K){
                check[list[left]]--;
                left++;
            }

            max = Math.max(max, right-left);
            if (right == N) break;
        }

        System.out.print(max);



    }
}
