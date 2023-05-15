package 바킹독.그래프;

import java.util.*;

public class BJ11000 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        List list = new ArrayList();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node[] nodes = new Node[N];

        for (int i = 0 ; i < N; i++){
            int s = Integer.parseInt(sc.nextLine());
            int e = Integer.parseInt(sc.nextLine());
            nodes[i] = new Node(s,e);
        }

        Arrays.sort(nodes, (o1, o2)->{
            if (o1.st == o2.st) return o1.en - o2.en;
            return o1.st - o2.st;
        });

        pq.offer(nodes[0].en);
        for (int i = 1; i < N; i++){
            int fastEnd = pq.peek();
            Node node = nodes[i];

            if (fastEnd <= node.st) pq.poll();
            pq.offer(node.en);
        }

    }

    public static class Node implements Comparable<Node>{
        int st;
        int en;

        public Node(int st, int en){
            this.st = st;
            this.en = en;
        }

        @Override
        public int compareTo(Node o2) {
            if (this.st == o2.st){
                return this.en - o2.en;
            }
            return this.st - o2.st;
        }
    }
}
