package 바킹독.연습문제0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2217 {
    static int n;
    static int[] list;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        max = Integer.MIN_VALUE;

        for (int i=0; i<n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        for (int i=0; i<n; i++){
            int w = list[i] * (n-i);
            max = Math.max(max, w);
        }

        System.out.print(max);
    }
}
