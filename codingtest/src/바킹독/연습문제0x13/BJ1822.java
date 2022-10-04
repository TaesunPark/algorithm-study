package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1822 {
    public static void main(String[] args) throws IOException {
        int n,m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] listA = new int[n];
        int[] listB = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            listA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<m; i++){
            listB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(listB);
        int size = 0;

        for (int i=0; i<n; i++){
            if (Arrays.binarySearch(listB, listA[i]) < 0){
                System.out.println(Arrays.binarySearch(listB, listA[i]));
                sb.append(listA[i] + " ");
                size++;
            }
        }

        if (size == 0){
            System.out.print(size);
        } else{
            System.out.println(size);
            System.out.print(sb);
        }
    }
}
