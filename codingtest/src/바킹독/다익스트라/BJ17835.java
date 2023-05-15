package 바킹독.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ17835 {
    static ArrayList<Node>[] list;
    static ArrayList<Integer> desList;
    static long[] result;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[out].add(new Node(in, cost));
        }

        desList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            desList.add(Integer.parseInt(st.nextToken()));
        }

        result = new long[N + 1];
        Arrays.fill(result, Long.MAX_VALUE);


        dij(desList);


        int idx = 0;
        long value = Long.MIN_VALUE;

        for (int i = 1; i <= N; i++){
            if (value < result[i]){
                value = result[i];
                idx = i;
            }
        }

        System.out.println(idx);
        System.out.print(value);

    }

    public static void dij(ArrayList<Integer> st){
        long[] d = new long[N + 1];
        Arrays.fill(d, Long.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < st.size(); i++){
            pq.add(new Node(st.get(i), 0));
            d[st.get(i)] = 0;
        }

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int now_en = node.en;
            if (d[now_en] != node.cost) continue;

            for (Node tmp : list[now_en]){
                if (tmp.cost + d[now_en] >= d[tmp.en]) continue;
                d[tmp.en] = tmp.cost + d[now_en];
                pq.add(new Node(tmp.en, d[tmp.en]));
            }
        }

        for (int i = 1; i <= N; i++){
            result[i] = Math.min(d[i], result[i]);
        }

    }

    public static class Node implements Comparable<Node>{
        int en;
        long cost;

        public Node(int en, long cost){
            this.en = en;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}
