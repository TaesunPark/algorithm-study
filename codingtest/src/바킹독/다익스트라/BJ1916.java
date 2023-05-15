package 바킹독.다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1916 {
    static int N;
    static int M;
    static int A;
    static int B;
    static ArrayList<ArrayList<Node>> list;
    static int[] d;

    public static void main(String[] args) {
        // N개의 도시가 있다.
        // 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다.
        // A -> B 까지 가는데 드는 버스 비용을 최소화
        //
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 도시의 개수
        M = sc.nextInt(); // 버스의 개수
        list = new ArrayList<>();
        d = new int[N + 1];

        for (int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            int st = sc.nextInt();
            int en = sc.nextInt();
            int dis = sc.nextInt();
            list.get(st).add(new Node(en, dis));
        }

        A = sc.nextInt(); // 출발 지점
        B = sc.nextInt(); // 도착 지점Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.fill(d, Integer.MAX_VALUE);
        dij(A);


        System.out.print(d[B]);

    }

    public static void dij(int st){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[st] = 0;
        pq.add(new Node(st, 0));

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int en = node.en;
            int dis = node.dis;

            if (d[en] != dis) continue;

            for (Node tmp : list.get(en)){
                if (d[tmp.en] <= tmp.dis + d[en]) continue;
                d[tmp.en] = tmp.dis + d[en];
                pq.add(new Node(tmp.en ,d[tmp.en]));
            }

        }
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
