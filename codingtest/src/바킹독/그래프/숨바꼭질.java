package 바킹독.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
    public static void main(String[] args) throws IOException {

        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++){
            list.add(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, 0));
            list.get(b).add(new Node(a, 0));
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[] check = new boolean[N + 1];
        check[1] = true;
        queue.add(new Node(1, 0));
        int max = 0;
        int cnt = 0;
        int idx = 0;

        while (!queue.isEmpty()){
            Node node = queue.poll();

            if (node.cnt > max){
                max = node.cnt;
                cnt = 1;
                idx = node.pos;
            }
            else if (node.cnt == max){
                idx = Math.min(idx, node.pos);
                cnt++;
            }

            for (Node node1 : list.get(node.pos)){
                if (check[node1.pos] == true) continue;
                queue.add(new Node(node1.pos, node.cnt + 1));
                check[node1.pos] = true;
            }
        }

        System.out.print(idx + " " + max + " " + cnt);

    }

    public static class Node{
        int cnt;
        int pos;
        public Node(int pos, int cnt){
            this.pos = pos;
            this.cnt = cnt;
        }
    }
}
