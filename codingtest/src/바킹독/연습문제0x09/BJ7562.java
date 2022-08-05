package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7562 {
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {2,1,-1,-2,2,1,-1,-2};
    static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();

        while (N != 0){
            queue.clear();
            N--;
            int I = Integer.parseInt(br.readLine());
            int[][] map = new int[I][I];
            boolean[][] check = new boolean[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            queue.offer(new Node(startX, startY, 0));
            check[startY][startX] = true;
            map[endY][endX] = 1;

            while (!queue.isEmpty()){
                Node node = queue.poll();
                int nowX = node.x;
                int nowY = node.y;
                int nowCnt = node.cnt;

                if (map[nowY][nowX] == 1){
                    sb.append(nowCnt + "\n");
                    break;
                }

                for (int i=0; i<8; i++){
                    int dx_x = nowX + dx[i];
                    int dy_y = nowY + dy[i];
                    if (dx_x >= I || dx_x <0 || dy_y >= I || dy_y <0 || check[dy_y][dx_x] == true) continue;
                    queue.offer(new Node(dx_x, dy_y, nowCnt + 1));
                    check[dy_y][dx_x] = true;
                }
            }
        }
        System.out.print(sb);
    }
    static class Node{
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
