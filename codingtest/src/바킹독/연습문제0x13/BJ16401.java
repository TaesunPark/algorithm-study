package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16401 {
    static int[] list;
    public static void main(String[] args) throws IOException {
        int m, n; // n 과자 길이
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 조카수
        n = Integer.parseInt(st.nextToken()); // 과자 수
        list = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int left = 1;
        int right = list[n-1];

        while (left <= right){
            int mid = left + (right - left) / 2;

            int cnt = 0;

            for (int i : list){
                cnt += i / mid;
            }

            if (cnt >= m){
                max = mid;
                left = mid+1;
            } else{
                right = mid-1;
            }
        }

        System.out.print(max);
    }
}
