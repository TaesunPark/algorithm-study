package 바킹독.다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1753 {

    static ArrayList<ArrayList<Node>> list;
    static int[] d;
    public static void main(String[] args) {
        list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int V, E, start;
        V = sc.nextInt();
        E = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= V; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++){
            int st = sc.nextInt();
            int en = sc.nextInt();
            int dis = sc.nextInt();

            list.get(st).add(new Node(en, dis));
        }
        Arrays.fill(d, Integer.MAX_VALUE);
        dij(start);
    }

    public static void dij(int start){
        d[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, d[start]));

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int dis = node.dis; // 거리
            int end = node.end; // 오는 점
            // 1, 0

            if(d[end] != dis) continue;

            for (Node tmp : list.get(end)){
                if (d[tmp.end] <= dis + d[end]) continue;
                d[tmp.end] = dis + d[end];
                pq.add(new Node(tmp.end, d[tmp.end]));
            }

        }

    }

    public static class Node implements Comparable<Node>{

        int end;
        int dis;

        public Node(int end, int dis){
            this.end = end;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }

}
