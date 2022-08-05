package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> queue = new LinkedList<>();
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[2000002];
        int[] map = new int[2000002];
        queue.offer(new Node(S, 0));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int nowX = node.x;
            int cnt = node.cnt;

            if (nowX == G){
                System.out.print(cnt); return;
            }

            for (int i=0; i<2; i++){
                int next=nowX;
                if (i==0){
                    next += U;
                } else if (i == 1){
                    next -= D;
                }
                if (next <= 0 || next > F || check[next] == true) continue;
                check[next] = true;
                queue.add(new Node(next, cnt+1));
            }
        }
        System.out.printf("use the stairs");
    }
    static class Node{
        int cnt;
        int x;
        public Node(int x, int cnt){
            this.cnt = cnt;
            this.x = x;
        }
    }
}
