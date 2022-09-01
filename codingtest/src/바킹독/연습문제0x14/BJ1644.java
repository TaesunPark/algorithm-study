package 바킹독.연습문제0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1644 {
    static int N;
    static boolean[] prime;
    static ArrayList<Integer> list;
    static int p = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        prime = new boolean[N+1];
        prime[0] = prime[1] = true;
        for(int i=2; i*i<=N; i++){
            if(!prime[i]) for(int j=i*i; j<=N; j+=i) prime[j]=true;
        }
        for(int i=1; i<=N;i++){
            if(!prime[i]) list.add(i);
        }

        int left=0;
        int right=0;
        int sum = 0;
        int cnt = 0;

        while (left <= right && right < list.size()){

            if (sum == N){
              sum -= list.get(left);
              left++;
              cnt++;
            } else if (sum < N){
                sum += list.get(right);
                if (list.get(right) == N) cnt++;
                right++;
            } else{
                sum -= list.get(left);
                if (list.get(left) == N) cnt++;
                left++;
            }
        }
        System.out.print(cnt);
    }

}
