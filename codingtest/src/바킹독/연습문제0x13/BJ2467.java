package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2467 {
    public static void main(String[] args) throws IOException {
        int n;
        int[] list;
        long min = Long.MAX_VALUE;
        int left = 0;
        int right;
        int resultLeft=0;
        int resultRight=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ii=0;
        right = n-1;

        while (st.hasMoreTokens()){
            list[ii] = Integer.parseInt(st.nextToken());
            ii++;
        }

        while (left<right){
            long sum = list[left] + list[right];

            if (Math.abs(sum) < min){
                resultLeft = list[left];
                resultRight = list[right];
                min = Math.abs(sum);
            }

            if (sum >= 0){
                right--;
            } else{
                left++;
            }
        }
        System.out.print(resultLeft);
        System.out.print(" "+ resultRight);

    }
}
