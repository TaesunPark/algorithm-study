package 바킹독.연습문제0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] listA = new int[n];
        int[] listB = new int[n];
        Integer[] listC = new Integer[n];
        Integer[] listD = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            listA[i] = Integer.parseInt(st.nextToken());
            listC[i] = listA[i];
        }
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            listB[i] = Integer.parseInt(st.nextToken());
            listD[i] = listB[i];
        }

        Arrays.sort(listC);
        Arrays.sort(listD);


    }
}
