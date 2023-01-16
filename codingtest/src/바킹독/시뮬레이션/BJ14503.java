package 바킹독.시뮬레이션;

import java.util.Scanner;

public class BJ14503 {
    static int N, M;
    static int[][] map;
    static int r, c;
    static int[] dy = {-1,0,1,0}; // 북 동 남 서
    static int[] dx = {0, 1, 0, -1};
    static int dir;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        r = sc.nextInt();
        c = sc.nextInt();
        dir = sc.nextInt();

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        cnt = 1;
        dfs(r,c,dir);
        System.out.print(cnt);
    }

    public static void dfs(int y, int x, int dir){
        map[y][x] = 2;

        for (int i = 0; i < 4; i++){
            dir = dir - 1;

            if (dir == -1){
                dir = 3;
            }

            int dx_x = x + dx[dir];
            int dy_y = y + dy[dir];

            if (dx_x < 0 || dx_x >= M || dy_y >= N || dy_y < 0) continue;

            if (map[dy_y][dx_x] == 0){
                cnt++;
                dfs(dy_y, dx_x, dir);
                return;
            }

        }

        int back = (dir + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if (bx >= 0 && bx < M && by >= 0 && by < N && map[by][bx] != 1){
            dfs(by, bx, dir);
        }

    }
}