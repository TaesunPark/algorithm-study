package 바킹독.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 네트워크_연결 {

    static int N, M;
    static ArrayList<Edge> list;
    static int[] p;
    public static void main(String[] args) throws IOException {
        list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        p = new int[N + 1];

        for (int i = 0; i <= N; i++){
            p[i] = i;
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++){

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Edge(v1, v2, cost));
        }

        Collections.sort(list, (o1, o2) -> {
            return o1.cost - o2.cost;
        });

        int result = 0;

        for (int i = 0; i < list.size(); i++){
            int v1 = find(list.get(i).v1);
            int v2 = find(list.get(i).v2);
            if (v1 == v2) continue;

            p[v2] = v1;
            result += list.get(i).cost;
        }

        System.out.print(result);
    }

    public static int find(int value){
        if (value == p[value]) return value;
        return p[value] = find(p[value]);
    }

    public static class Edge{
        int v1;
        int v2;
        int cost;
        public Edge(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
}
