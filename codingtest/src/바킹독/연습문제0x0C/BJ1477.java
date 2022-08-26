package 바킹독.연습문제0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1477 {

    static int n;
    static int m;
    static int L;
    static int left;
    static int right;
    static int[] list;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        list = new int[n+2];

        st = new StringTokenizer(br.readLine());
        list[0] = 1;
        list[n+1] = L;
        for (int i=1; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        findIndexFunc();
        System.out.print(left);
    }

    public static void findIndexFunc() {
        left = 0;
        right = L;

        while (left<=right){
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i=1; i<n+2; i++){
                sum += (list[i] - list[i-1] - 1) / mid;
            }

            if (sum > m){
                left = mid+1;
            } else{
                right = mid - 1;
            }

        }

    }

}
