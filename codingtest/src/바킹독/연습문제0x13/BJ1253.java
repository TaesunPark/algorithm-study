package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1253 {
    static int[] list;
    static boolean[] check;
    static int start;
    static int end;
    static int n;

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        for (int i=0; i<n; i++){
            int left = 0;
            int right = n-1;
            while (true){
                if (left == i) left++;
                else if(right == i) right--;

                if (left >= right) break;

                if (list[left] + list[right] > list[i]) right--;
                else if(list[left] + list[right] < list[i]) left++;
                else{
                    cnt++;
                    break;
                }
            }
        }

        System.out.print(cnt);
    }

}
