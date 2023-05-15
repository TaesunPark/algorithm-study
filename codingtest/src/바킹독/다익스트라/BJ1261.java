package 바킹독.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BJ1261 {
    static int N;
    static int M;
    static int K;
    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws IOException {
        list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(v).add(new Node(u,c));
        }

        ArrayList<Integer> room = new ArrayList<>();


        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int idx = Integer.parseInt(st.nextToken());
            room.add(idx);
        }



        int[] result = new int[2];

        int[] d = new int[0];
        for (int i = 0; i < K; i++){
            int[] tmp = dij(room.get(i));

            if (d.length == 0){
                d = tmp;
                continue;
            }

            for (int j = 0; j < N + 1; j++){
                if(tmp[j] < d[j]){
                    d[j] = tmp[j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N + 1; i++){
            if (d[i] == Integer.MAX_VALUE) continue;
            if (max < d[i]){
                max = d[i];
                result[1] = max;
                result[0] = i;
            }
        }

        for (int i = 0; i < 2; i++){
            System.out.println(result[i]);
        }

    }

    public static int[] dij(int st){
        int[] d = new int[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[st] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(st, d[st]));

        while (!pq.isEmpty()){
            Node node = pq.poll();

            if (d[node.en] != node.dis) continue;

            for (Node tmp : list.get(node.en)){
                if (d[tmp.en] <= d[node.en] + tmp.dis) continue;
                d[tmp.en] = d[node.en] + tmp.dis;
                pq.add(new Node(tmp.en, d[tmp.en]));
            }
        }

        return d;

    }

    public static class Node implements Comparable<Node>{
        int en;
        int dis;

        public Node(int en, int dis){
            this.en = en;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }
}

