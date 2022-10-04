package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ10815 {
    public static void main(String[] args) throws IOException {
        int n;
        HashMap<Integer, Integer> hashMap = new HashMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++){
            hashMap.put(Integer.parseInt(st.nextToken()), 0);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<m; i++){
            if (hashMap.containsKey(Integer.parseInt(st.nextToken()))){
                sb.append("1 ");
            } else{
                sb.append("0 ");
            }
        }

        System.out.print(sb);
    }
}
