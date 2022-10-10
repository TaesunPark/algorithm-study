package 바킹독.다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1753 {
    public static int N;
    public static int M;
    public static ArrayList<ArrayList<Node>> list;
    public static int[] d;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int K = sc.nextInt();
        list = new ArrayList<>();
        d = new int[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

        for(int i = 0; i <= N; i++){
            list.add(i, new ArrayList<Node>());
        }

        for(int i = 1; i <= M; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();

            list.get(v1).add(new Node(v2, w));
        }

        di(K);
        for(int i = 1; i<=N; i++){
            if(d[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            } else{
                System.out.println(d[i]);
            }
        }
    }
    public static void di(int st){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[st] = 0;
        pq.add(new Node(st, d[st]));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int dis = node.dis;
            int end = node.end;

            if(d[end] != dis) continue;

            for(Node tmp : list.get(end)){
                // 최단 거리 비교
                if(d[tmp.end] <= tmp.dis + d[end]) continue;
                d[tmp.end] = tmp.dis + d[end];
                pq.add(new Node(tmp.end, d[tmp.end]));
            }

        }
    }

    public static class Node implements Comparable<Node>{
        public int dis;
        public int end;

        public Node(int end, int dis){
            this.end = end;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node node){
            return this.dis - node.dis;
        }
    }
}
