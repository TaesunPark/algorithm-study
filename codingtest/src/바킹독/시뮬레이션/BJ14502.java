package 바킹독.시뮬레이션;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ14502 {
    static int[][] map;
    static Queue<Node> queue;
    static int N;
    static int M;
    static int cnt;
    static int cnt1;
    static int result;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) cnt1++;
            }
        }
        cnt1 = cnt + 3;
        dfs(0);
        System.out.print(result);
        
    }

    public static int bfs(){

        int[][] tmp = new int[N][M];
        cnt = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                tmp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 2) {
                    queue.add(new Node(j, i));
                }
            }
        }

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (tmp[ny][nx] != 0) continue;
                tmp[ny][nx] = 2;
                queue.add(new Node(nx, ny));
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (tmp[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public static void dfs(int wallCnt){
        if (wallCnt == 3){
            int a = bfs();
            result = Math.max(a, result);
            return;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wallCnt + 1);
                    map[i][j] = 0;
                }
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
