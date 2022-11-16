package 바킹독.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2178 {
    public static int n;
    public static int m;
    static int[][] map;
    static boolean[][] check;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0, 1, 0 ,-1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        check = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String s = sc.next();

            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0, 1));
        check[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;

            if(x == m-1 && y == n - 1){
                return cnt;
            }

            for(int i = 0; i < 4; i++){
                int dx_x = x + dx[i];
                int dy_y = y + dy[i];

                if(dx_x < 0 || dx_x >= m || dy_y < 0 || dy_y >= n) continue;

                if(map[dy_y][dx_x] == 0 ||  check[dy_y][dx_x] == true) continue;

                queue.add(new Node(dx_x, dy_y, cnt + 1));
                check[dy_y][dx_x] = true;
            }
        }

        return 0;
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
