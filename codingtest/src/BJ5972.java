import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ5972 {


    static int N, M;
    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws IOException{
        StringTokenizer st1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }



        for (int i = 0; i < M; i++){
            st1 = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(st1.nextToken());
            int en = Integer.parseInt(st1.nextToken());
            int dis = Integer.parseInt(st1.nextToken());

            list.get(st).add(new Node(en, dis));
            list.get(en).add(new Node(st, dis));
        }

        System.out.print(dij(1));

    }

    public static int dij(int start){
        int[] di = new int[N + 1];
        Arrays.fill(di, Integer.MAX_VALUE);
        di[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()){
            Node node = queue.poll();

            if (di[node.en] != node.dis) continue;

            for (Node tmp : list.get(node.en)){
                if (di[tmp.en] <= tmp.dis + di[node.en]) continue;
                di[tmp.en] = tmp.dis + di[node.en];
                queue.add(new Node(tmp.en, di[tmp.en]));
            }
        }

        return di[N];
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
