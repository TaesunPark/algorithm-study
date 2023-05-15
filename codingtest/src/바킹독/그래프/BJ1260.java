package 바킹독.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, V;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++){
            list.add(i, new ArrayList<>());
        }

        for (int i = 0 ; i < M; i++){
            String[] cmd = br.readLine().split(" ");
            int v1 = Integer.parseInt(cmd[0]);
            int v2 = Integer.parseInt(cmd[1]);
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        StringBuilder sb = new StringBuilder();
        boolean[] check = new boolean[N + 1];
        dfs(list, V, sb, check);
        System.out.print(sb);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> list, int V, StringBuilder sb, boolean[] check){

        check[V] = true;
        sb.append(V);

        for (int value : list.get(V)){
            if (true == check[value]) continue;
            dfs(list, value, sb, check);
        }
    }
}
