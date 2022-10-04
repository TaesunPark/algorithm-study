package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13549 {
    static Queue<Node> queue;
    static int[] timeArray = new int[200001];
    static int M;
    static int N;
    static int cnt;
    static int cntt = 0;
    static int tempFirst=0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        if (N == M){
            System.out.println(0);
            return;
        }
        bfs(M);
        System.out.println(min);
    }

    public static void bfs(int start){
        queue = new LinkedList<>();
        boolean[] checked = new boolean[200001];
        checked[start] = true;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int nowPos = node.pos;
            cnt = node.num;

            if (nowPos == N && min > cnt){
                min = Math.min(min, cnt);
            }

                int next;
                next = node.pos * 2;
                if(next < 100001 && !checked[next]) {
                    checked[next] = true;
                    queue.offer(new Node(next, cnt));
                }

                next = node.pos - 1;
                if(next >= 0 && !checked[next]) {
                    checked[next] = true;
                    queue.offer(new Node(next, cnt + 1));
                }

                next = node.pos + 1;
                if(next < 100001 && !checked[next]) {
                    checked[next] = true;
                    queue.offer(new Node(next, cnt + 1));
                }
        }

    }

    public static class Node{
        int pos;
        int num;
        public Node(int pos, int num){
            this.pos = pos;
            this.num = num;
        }
    }
}
