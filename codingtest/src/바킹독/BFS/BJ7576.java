package 바킹독.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ7576 {
    static int n;
    static Queue<Node> queue;
    static int m;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] check;
    static int result;
    static int cnt;

    public static void main(String[] args){
        queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); // 가로
        n = sc.nextInt();
        map = new int[n][m];
        check = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == -1) {
                    result++;
                    check[i][j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1){
                    queue.add(new Node(j,i, 0));
                    check[i][j] = true;
                }
            }
        }
        bfs();
        if(result == n * m){
            System.out.println(cnt);
        } else{
            System.out.println(-1);
        }

    }

    public static void bfs(){

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            result++;
            cnt = Math.max(cnt, node.cnt);

            for(int i = 0; i < 4; i++){
                int dx_x = dx[i] + x;
                int dy_y = dy[i] + y;

                if(dx_x < 0 || dx_x >= m || dy_y < 0 || dy_y >=n ) continue;
                if(map[dy_y][dx_x] == -1) continue;
                if(check[dy_y][dx_x] == true) continue;

                map[dy_y][dx_x] = 1;
                queue.add(new Node(dx_x, dy_y, cnt + 1));
                check[dy_y][dx_x] = true;
            }

        }
    }

    public static class Node{
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
