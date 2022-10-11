package 바킹독.다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1504 {

    static int n;
    static int m;
    static int v1;
    static int v2;
    static ArrayList<ArrayList<Node>> list0;
    static ArrayList<ArrayList<Node>> list1;
    static ArrayList<ArrayList<Node>> list2;

    private static final int INF = 200_000_000;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list0 = new ArrayList<>();
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        for(int i=0; i<=n; i++){
            list0.add(i, new ArrayList<Node>());
            list1.add(i, new ArrayList<Node>());
            list2.add(i, new ArrayList<Node>());
        }

        for(int i=0; i<m; i++){
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int w = sc.nextInt();

            list0.get(a1).add(new Node(a2, w));
            list0.get(a2).add(new Node(a1, w));
            list1.get(a1).add(new Node(a2, w));
            list1.get(a2).add(new Node(a1, w));
            list2.get(a1).add(new Node(a2, w));
            list2.get(a2).add(new Node(a1, w));
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        int[] d1 = di(1, list0);
        int[] d2 = di(v1, list1);
        int[] d3 = di(v2, list2);
        int r1 = d1[v1] + d2[v2]+ d3[n];
        int r2 = d1[v2] + d2[n] + d3[v1];

        if(INF <= r1 && INF <= r2){
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(r1, r2));

    }

    public static int[] di(int st, ArrayList<ArrayList<Node>> list){
        int[] d;
        d= new int[n+1];
        Arrays.fill(d, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[st] = 0;
        pq.add(new Node(st, d[st]));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int cur = node.cur;
            int dis = node.dis;

            if(d[cur] != dis) continue;

            for(Node tmp : list.get(cur)){
                if(d[tmp.cur] <= d[cur] + tmp.dis) continue;
                d[tmp.cur] = d[cur] + tmp.dis;
                pq.add(new Node(tmp.cur, d[tmp.cur]));
            }
        }
        return d;
    }


    public static class Node implements Comparable<Node>{
        int dis;
        int cur;
        public Node(int cur, int dis){
            this.cur = cur;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node node){
            return this.dis - node.dis;
        }
    }
}
