package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ13913 {
    static Queue<Node> queue;
    static int M;
    static int N;
    static int cnt;
    static int cntt = 0;
    static int[] check = new int[100001];
    static int[] parrent = new int[100001];
    static int tempFirst=0;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        bfs(M);
        Stack<Integer> stack = new Stack<>();
        System.out.println(min);
        for (int i=N; i!=M; i=parrent[i]){
            stack.push(i);
        }
        stack.push(M);
        int size = stack.size();
        for (int i=0; i<size;i++){
            System.out.print(stack.pop()+" ");
        }
    }

    public static void bfs(int start){
        queue = new LinkedList<>();
        boolean[] checked = new boolean[100001];
        checked[start] = true;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int nowPos = node.pos;
            cnt = node.num;

            if (nowPos == N && min >= cnt){
                min = cnt;
                break;
            }

            for (int i=0; i<3;i++){
                int next = nowPos;

                if (i == 0){
                    next = nowPos*2;
                } else if(i == 1){
                    next = nowPos+1;
                } else if(i == 2){
                    next = nowPos-1;
                }
                if (next < 0 || next > 100000) continue;

                if (next == N && tempFirst == cnt){
                    checked[next] = false;
                }

                if (checked[next] == false) {
                    checked[next] = true;
                    parrent[next] = nowPos;
                    queue.offer(new Node(next, cnt + 1));
                }
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
