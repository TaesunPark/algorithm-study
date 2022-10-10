package 바킹독.다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1238 {
    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Node>> list1;
    public static ArrayList<ArrayList<Node>> list2;
    public static int[] d;
    public static int[] d1;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int start = sc.nextInt();
        d = new int[n + 1];
        d1 = new int[n + 1];
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.fill(d1, Integer.MAX_VALUE);

        for(int i=0; i<=n; i++){
            list1.add(i, new ArrayList<>());
            list2.add(i, new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cnt = sc.nextInt();

            list1.get(v1).add(new Node(v2, cnt));
            list2.get(v2).add(new Node(v1, cnt));
        }

        d = dij(start, list1);
        d1 =dij(start, list2);
        int max = Integer.MIN_VALUE;


        for(int i=1; i<=n; i++){
            max = Math.max(max, d1[i] + d[i]);
        }
        System.out.println(max);
    }

    public static int[] dij(int st, ArrayList<ArrayList<Node>> list){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int[] d2 = new int[n + 1];
        Arrays.fill(d2, Integer.MAX_VALUE);
        d2[st] = 0;
        pq.add(new Node(st, d2[st]));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int cur = node.cur;
            int dis = node.dis;

            if(d2[cur] != dis) continue;

            for(Node tmp : list.get(cur)){
                if(d2[tmp.cur] <= d2[cur] + tmp.dis) continue;
                d2[tmp.cur] = d2[cur] + tmp.dis;
                pq.add(new Node(tmp.cur, d2[tmp.cur]));
            }

        }
        return d2;
    }

    public static class Node implements Comparable<Node>{
        int cur;
        int dis;
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
