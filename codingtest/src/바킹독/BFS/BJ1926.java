package 바킹독.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1926 {

    static int[][] map;
    static int n;
    static int m;
    static int max;
    static boolean[][] check;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        check = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int value = sc.nextInt();
                map[i][j] = value;
            }
        }
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(check[i][j] == true) continue;
                if(map[i][j] == 0) continue;
                cnt++;
                max = Math.max(bfs(i, j), max);
            }

        }
        System.out.println(cnt);
        System.out.println(max);
    }

    public static int bfs(int ii, int jj){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(jj, ii, 0));
        check[ii][jj] = true;
        int tmpMax = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int cnt = node.cnt;
            int x = node.x;
            int y = node.y;

            for(int i = 0; i < 4; i++){
                int dx_x = x + dx[i];
                int dy_y = y + dy[i];
                if(dx_x < 0 || dx_x >= m || dy_y < 0 || dy_y >= n || map[dy_y][dx_x] == 0) continue;
                if(check[dy_y][dx_x] == true) continue;
                check[dy_y][dx_x] = true;
                tmpMax++;
                queue.add(new Node(dx_x, dy_y, cnt + 1));
            }
        }

        return tmpMax;
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
