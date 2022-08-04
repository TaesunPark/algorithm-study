package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1926 {
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int n;
    static int m;
    static int size;
    static Queue<Node> queue;
    static boolean[][] checked;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        checked = new boolean[n][m];
        queue = new LinkedList<>();

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n;i++){
            for (int j=0; j<m; j++){
                if ( checked[i][j] == true || map[i][j] == 0) continue;
                queue.offer(new Node(j, i));
                checked[i][j] = true;
                size++;
                int num = bfs();
                max = num > max ? num : max;
            }
        }

        System.out.println(size);
        System.out.println(max);
    }

    public static int bfs(){
        int size = 1;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int now_x = node.x;
            int now_y = node.y;

            for (int i=0; i<4; i++){
                int dx_x = now_x + dx[i];
                int dy_y = now_y + dy[i];

                if ( dx_x < 0 || dx_x >= m || dy_y < 0 || dy_y >= n || checked[dy_y][dx_x] == true || map[dy_y][dx_x] == 0) continue;

                queue.offer(new Node(dx_x, dy_y));
                checked[dy_y][dx_x] = true;
                size++;
            }
        }
        return size;
    }

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
