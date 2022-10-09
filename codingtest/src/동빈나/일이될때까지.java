package 동빈나;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이될때까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] value = br.readLine().split(" ");
        System.out.print(solution(Integer.parseInt(value[0]), Integer.parseInt(value[1])));
    }

    public static int solution(int N, int K){
        // 1. N - 1
        // 2. N / K
        // 1이 될 때 까지
        // 17 4 16 4 4 1
        int cnt = 0;
        for(int i=N; N != 1; i--){
            if(N % K == 0){
                N = N/K;
            } else{
                N = N - 1;
            }
            cnt++;
        }
        return cnt;
    }
}
