package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2473 {
    public static void main(String[] args) throws IOException {
        int n;
        long min = Long.MAX_VALUE;
        long[] result = new long[3];
        int resultLeft=0;
        int resultRight=0;
        int resultI=0;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] list = new long[n];

        for (int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        for (int i=0; i<n; i++){
            int left = 0;
            int right = n-1;

            while (true){
                if (left == i) left++;
                else if (right == i) right--;

                long sum = list[left] + list[right] + list[i];

                if (left >= right) break;

                if (Math.abs(sum) < Math.abs(min)) {
                    min = sum;
                    resultLeft = left;
                    resultRight = right;
                    resultI = i;
                }

                if (sum <0){
                    left++;
                } else if(sum >0){
                    right--;
                } else{
                    result[0] = list[resultLeft];
                    result[1] = list[resultI];
                    result[2] = list[resultRight];
                    Arrays.sort(result);
                    sb.append(result[0] + " ");
                    sb.append(result[1] + " ");
                    sb.append(result[2] + " ");
                    System.out.print(sb);
                    return;
                }
            }

        }
        result[0] = list[resultLeft];
        result[1] = list[resultI];
        result[2] = list[resultRight];

        Arrays.sort(result);

        sb.append(result[0] + " ");
        sb.append(result[1] + " ");
        sb.append(result[2] + " ");

        System.out.print(sb);

    }
}
