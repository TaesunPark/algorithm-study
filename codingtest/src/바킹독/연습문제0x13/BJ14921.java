package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14921 {
    static int diff;
    public static void main(String[] args) throws IOException {
        int N;
        int[] list;
        int left = 0;
        int right = 0;
        int value = 0;
        diff = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        right = N-1;

        while (left < right){

            int sum = list[left] + list[right];

            if (Math.abs(sum) < Math.abs(diff)){
                diff = sum;
            }

            if (sum == 0) {
                System.out.print("0");
                return;
            }

            if (sum < 0) {
                left++;
            } else{
                right--;
            }
        }
        System.out.print(diff);
    }
}
