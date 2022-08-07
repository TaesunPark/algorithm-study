package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1600 {
    static int hn;
    static int[][] map;
    static boolean[][][] check;
    static int[] hdx = {2,1,-1,-2,2,1,-1,-2};
    static int[] hdy = {1,2,2,1,-1,-2,-2,-1};
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<Node> queue;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();
        hn = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;

            while (st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        System.out.print(bfs());

    }
    static int bfs(){
        queue = new LinkedList<>();
        queue.offer(new Node(0,0,0,hn));
        check = new boolean[n][m][hn+1];
        check[0][0][hn] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;
            int nowHCnt = node.hcnt;
            int nowCnt = node.cnt;

            if (nowX == m-1 && nowY == n-1){
                return nowCnt;
            }
            for (int i=0; i<4; i++){
                int dx_x = nowX + dx[i];
                int dy_y = nowY + dy[i];
                if (dx_x < 0 || dx_x >= m || dy_y <0 || dy_y >= n || check[dy_y][dx_x][nowHCnt] == true || map[dy_y][dx_x] == 1) continue;
                queue.offer(new Node(dx_x, dy_y, nowCnt+1, nowHCnt));
                check[dy_y][dx_x][nowHCnt] = true;
            }

            if (nowHCnt > 0){
                for (int i=0; i<8; i++){
                    int dx_x = nowX + hdx[i];
                    int dy_y = nowY + hdy[i];
                    if (dx_x < 0 || dx_x >= m || dy_y <0 || dy_y >= n || check[dy_y][dx_x][nowHCnt-1] == true || map[dy_y][dx_x] == 1) continue;
                    queue.offer(new Node(dx_x, dy_y, nowCnt+1, nowHCnt-1));
                    check[dy_y][dx_x][nowHCnt-1] = true;
                }
            }

        }
        return -1;
    }
    static class Node{
        int x;
        int y;
        int cnt;
        int hcnt;

        public Node(int x, int y, int cnt, int hcnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.hcnt = hcnt;
        }
    }
}
