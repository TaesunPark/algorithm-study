package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2146 {
    static int n;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Node> queue;
    static int cnt=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new boolean[n][n];

        for (int i=0; i<n; i++){
            int j=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        divide();

        int min = Integer.MAX_VALUE;

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (map[i][j] > 0){
                    check = new boolean[n][n];
                    int num = bfs(j, i);

                    if (num == -1) continue;
                    min = min > num ? num : min;
                }
            }
        }

        System.out.print(min-1);

    }

    public static int bfs(int x, int y){
        queue = new LinkedList<>();
        check[y][x] = true;
        int num = map[y][x];
        queue.offer(new Node(x, y,0));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;
            int nowCnt = node.cnt;

            if (map[nowY][nowX] != num && map[nowY][nowX] != 0){
                return nowCnt;
            }

            for (int i=0;i<4;i++){
                int dx_x = nowX + dx[i];
                int dy_y = nowY + dy[i];
                if (dx_x < 0 || dx_x >= n || dy_y < 0 || dy_y >= n || check[dy_y][dx_x] == true || map[dy_y][dx_x] == num) continue;
                check[dy_y][dx_x] = true;
                queue.offer(new Node(dx_x, dy_y, nowCnt+1));
            }
        }
        return -1;
    }
    public static void divide(){
        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++){
                if (check[i][j] == true || map[i][j] == 0) continue;
                cnt++;
                queue.add(new Node(j,i));
                check[i][j] = true;

                while (!queue.isEmpty()){
                    Node node = queue.poll();
                    int nowX = node.x;
                    int nowY = node.y;
                    map[nowY][nowX] = cnt;

                    for (int k=0; k<4; k++){
                        int dx_x = nowX + dx[k];
                        int dy_y = nowY + dy[k];
                        if (dx_x < 0 || dx_x >= n || dy_y < 0 || dy_y >= n || check[dy_y][dx_x] == true || map[dy_y][dx_x] == 0) continue;
                        queue.offer(new Node(dx_x, dy_y));
                        check[dy_y][dx_x] = true;
                    }
                }
            }
        }
    }

    public static class Node{
        int x;
        int y;

        int cnt;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
