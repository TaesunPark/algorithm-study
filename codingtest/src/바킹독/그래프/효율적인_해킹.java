package 바킹독.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적인_해킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        int max = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] result = new int[N + 1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++){
            list.add(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(f);
        }

        for (int i = 1; i <= N; i++){
            Queue<Integer> queue = new LinkedList<>();
            boolean[] check = new boolean[N + 1];
            int cnt = 0;


            check[i] = true;
            queue.add(i);

            while (!queue.isEmpty()){
                int idx = queue.poll();
                cnt++;
                for (int j : list.get(idx)){
                    if (check[j] == true) continue;
                    check[j] = true;
                    queue.add(j);
                }
            }
            result[i] = cnt;
            max = Math.max(max, cnt);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++){
            if (max == result[i]){
                sb.append(i + " ");
            }
        }

        System.out.print(sb);
    }
}
