package 바킹독.다익스트라;

import java.util.*;

public class BJ11779 {

    public static ArrayList<ArrayList<Node>> list;
    public static int[] d;
    public static int[] check;
    public static int n;
    public static int cityCnt = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        d = new int[n + 1];
        list = new ArrayList<>();
        check = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

        for(int i = 0; i <= n; i++){
            list.add(i, new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int dis = sc.nextInt();

            list.get(v1).add(new Node(dis, v2));
        }

        int st = sc.nextInt();
        int en = sc.nextInt();
        dijkstra(st);

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = searchPath(st,en);

        while(!stack.isEmpty()){
            int city = stack.pop();
            sb.append(city + " ");
        }
        System.out.println(d[en]);
        System.out.println(cityCnt);
        System.out.println(sb);
    }

    public static Stack<Integer> searchPath(int start,int end){
        Stack<Integer> stack = new Stack<>();
        int cur = end;

        while(cur != start) {
            stack.push(cur);
            cityCnt++;

            cur = check[cur];
        }
        stack.push(cur);
        cityCnt++;

        return stack;
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        check[start] = 0;
        pq.add(new Node(d[start], start));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int cur = node.end;
            int dis = node.dis;

            if(d[cur] != dis) continue;

            for(Node tmp : list.get(cur)){
                if(d[tmp.end] <= tmp.dis + d[cur]) continue;
                d[tmp.end] = tmp.dis + d[cur];
                pq.add(new Node(d[tmp.end], tmp.end));
                check[tmp.end] = cur;
            }

        }
    }

    public static class Node implements Comparable<Node>{
        int dis;
        int end;

        public Node(int dis, int end){
            this.dis = dis;
            this.end = end;
        }

        @Override
        public int compareTo(Node node){
            return this.dis - node.dis;
        }

    }
}
