package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ10026 {
    static int N;
    static int M;
    static Queue<Node> queue = new LinkedList<>();
    static char[][] map;
    static char[][] map1;
    static int[] dx= {-1,0,1,0};
    static int[] dy= {0,1,0,-1};
    static boolean[][] checked;
    static boolean[][] checked1;

    public static void main(String[] args) throws IOException {
        int cnt=0;
        int ii = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[2];
        M = Integer.parseInt(br.readLine());
        checked = new boolean[M][M];
        checked1 = new boolean[M][M];
        map = new char[M][M];
        map1 = new char[M][M];

        for (int i=0; i<M; i++){
            String string = br.readLine();
            for (int j=0; j<M; j++){
                char ch = string.charAt(j);
                map1[i][j] = ch;
                if (ch == 'G') ch = 'R';
                map[i][j] = ch;
            }
        }

        for (int k=0; k<2; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    if (checked[i][j] == false) {
                        bfs(i, j, map[i][j]);
                        cnt++;
                    }
                }
            }
            result[ii++] = cnt;
            cnt = 0;
            checked = checked1;
            map = map1;
        }
        System.out.print(result[1] + " ");
        System.out.print(result[0]);
    }

    public static void bfs(int y, int x, char color){
        queue.add(new Node(x,y));
        checked[0][0] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int dx_x = node.x;
            int dy_y = node.y;

            for (int i=0; i<4; i++){
                int idx_x = dx_x + dx[i];
                int idx_y = dy_y + dy[i];

                if (idx_x < 0 || idx_x >= M || idx_y < 0 || idx_y >= M) continue;
                if (color == map[idx_y][idx_x] && checked[idx_y][idx_x] == false){
                    checked[idx_y][idx_x] = true;
                    queue.add(new Node(idx_x, idx_y));
                }
            }

        }
    }

    public static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
