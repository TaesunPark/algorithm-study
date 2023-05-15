package 바킹독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ22233 {
    public static void main(String[] args) throws IOException {
        HashSet<String> map = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++){
            String key = br.readLine();
            map.add(key);
        }

        for (int i = 0; i < M; i++){
            String[] values = br.readLine().split(",");

            for (String key : values) {

                if (map.contains(key)){
                    map.remove(key);
                }
            }

            sb.append(map.size() + "\n");
        }

        System.out.print(sb);

    }

}
