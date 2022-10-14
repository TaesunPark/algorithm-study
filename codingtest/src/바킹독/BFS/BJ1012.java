package 바킹독.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1012 {

    static int T;
    static int M; // 가로
    static int N; // 세로
    static int K; // 갯수
    static int[][] map;
    static int[] dx = {0, -1, 0 ,1};
    static int[] dy = {1, 0, -1 ,0};
    static boolean[][] check;
    static int cnt;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for(int t1 = 0; t1 < T; t1++){
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            cnt = 0;
            map = new int[N][M];
            check = new boolean[N][M];

            for(int i = 0; i < K; i++){
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                map[v2][v1] = 1;
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(check[i][j] == true) continue;

                    if(map[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }
    }

    public static void bfs(int n1, int m1){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(m1, n1));
        check[n1][m1] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for(int i=0; i<4; i++){
                int dx_x = x + dx[i];
                int dy_y = y + dy[i];

                if(dx_x < 0 || dx_x >= M || dy_y < 0 || dy_y >=N) continue;
                if(map[dy_y][dx_x] == 0) continue;
                if(check[dy_y][dx_x] == true) continue;
                queue.add(new Node(dx_x, dy_y));
                check[dy_y][dx_x] = true;
            }
        }

    }

    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
