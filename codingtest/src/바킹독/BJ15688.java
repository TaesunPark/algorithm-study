package 바킹독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15688 {
    static int n;
    static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        int tIdx=0;
        index = new int[2000001];

        for (int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            index[num+1000000]++;
        }

        for (int i=0; i<=2000000; i++){
            for (int j=index[i]; j>0; j--){
                sb.append((i-1000000)+"\n");
            }
        }
        System.out.print(sb);
    }
}
