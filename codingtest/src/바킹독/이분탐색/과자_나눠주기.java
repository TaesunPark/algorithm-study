package 바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 과자_나눠주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] list = new int[M];

        for (int i = 0; i < M; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);
        int left = 1;
        int right = list[M - 1];
        int result = 0;

        while (left <= right){
            int mid = (right + left) / 2;
            int cnt = getCnt(mid, list);
            if (cnt >= N){
                left = mid + 1;
                result = Math.max(result, mid);
            } else{
                right = mid - 1;
            }
        }

        System.out.print(result);
    }
    public static int getCnt(int mid, int[] list){
        int result = 0;

        for (int i = 0; i < list.length; i++){
            result += (list[i] / mid);
        }

        return result;
    }
}
