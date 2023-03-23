package 알고리즘_스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_용액 {
    static int N;
    static int[] list;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;

        while (st.hasMoreTokens()){
            list[idx++] = Integer.parseInt(st.nextToken());
        }

        result = Long.MAX_VALUE;
        Arrays.sort(list);

        int[] value = find();


        System.out.print(value[0] + " " + value[1]);

    }

    public static int[] find(){
        int st = 0;
        int en = N - 1;
        int[] tmp = new int[2];

        while (st < en){
            long sum = list[st] + list[en];

            if (Math.abs(sum) < result){
                tmp[0] = list[st];
                tmp[1] = list[en];
                result = Math.abs(sum);
            }

            if (sum == 0){
                return new int[]{list[st], list[en]};
            }

            if (sum < 0){
                st++;
            } else{
                en--;
            }
        }
        return tmp;
    }
}
