package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2110 {
    public static int[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        list = new int[n];
        int ii= 0;

        for (int i=0; i<n; i++){
            list[ii] = Integer.parseInt(br.readLine());
            ii++;
        }

        Arrays.sort(list);

        int start = 1;
        int end = list[list.length-1];

        while (start<end){
            int mid = (start + end) / 2;

            if (count(mid) < c){
                end = mid;
            } else{
                start = mid+1;
            }
        }
        System.out.print(start-1);
    }

    public static int count(int mid){
        int cnt = 1;
        int lastLocate = list[0];

        for (int i=1; i<list.length; i++){
            int locate = list[i];

            System.out.print(lastLocate+" ");
            System.out.println(locate);
            if (locate - lastLocate > mid){
                cnt++;
                lastLocate = locate;
            }
        }
        return cnt;
    }
}
