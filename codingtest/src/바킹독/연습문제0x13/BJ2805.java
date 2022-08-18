package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805 {
    public static void main(String[] args) throws IOException {
        int n, m;
        int[] list;
        int[] subList;
        int max = Integer.MIN_VALUE;
        int min = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int ii = 0;
        list = new int[n];

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            list[ii] = Integer.parseInt(st.nextToken());
            if (max < list[ii]) max = list[ii];
            ii++;
        }

        while (min < max){
            int mid = (min + max) / 2;
            long sum = 0;

            for (int treeHeight : list){
                if (treeHeight - mid > 0) {
                    sum += (treeHeight - mid);
                }
            }

            if (sum < m){
                max = mid;
            } else{
                min = mid + 1;
            }
        }

        System.out.print(min - 1);

    }
}
