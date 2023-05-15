package 바킹독.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ7569 {
    static int[][][] map;
    static boolean[][][] check;
    static int[] dx = {0,0,1,-1,0,0};
    static int[] dy = {1,-1,0,0,0,0};
    static int[] dz = {0,0,0,0,-1,1};
     static int N,M,H;
     static int minusCnt;
    static int minusCnt2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][N][M];
        check = new boolean[H][N][M];
        Queue<Node> queue = new LinkedList<>();

        int result = 0;
        int emCnt = 0;

        for (int i = 0; i < H; i++){
            for (int j = 0; j < N; j++){
                for (int k = 0; k < M; k++){
                    int value = sc.nextInt();

                    if (value == 0){
                        minusCnt++;
                    }

                    if (value == -1){
                        emCnt++;
                    }

                    if (value == 1){
                        queue.add(new Node(k,j,i,0));
                        check[i][j][k] = true;
                    }

                    map[i][j][k] = value;
                }
            }
        }

        if (minusCnt == 0){
            System.out.print("0");
            return;
        }
        while (!queue.isEmpty()){
            Node node = queue.poll();

            for (int i = 0; i < 6; i++){
                int dx_x = dx[i] + node.x;
                int dy_y = dy[i] + node.y;
                int dz_z = dz[i] + node.z;

                if (dx_x < 0 || dx_x >= M || dy_y < 0 || dy_y >= N || dz_z < 0 || dz_z >= H) continue;
                if (check[dz_z][dy_y][dx_x] == true) continue;
                if (map[dz_z][dy_y][dx_x] == 0){
                    check[dz_z][dy_y][dx_x] = true;
                    map[dz_z][dy_y][dx_x] = 1;
                    minusCnt--;
                    result = Math.max(node.cnt + 1, result);
                    queue.add(new Node(dx_x, dy_y, dz_z, node.cnt + 1));
                }

            }
        }

        if (minusCnt != 0){
            System.out.print("-1");
        } else{
            System.out.print(result);
        }

    }

    public static class Node{
        int x;
        int y;
        int z;
        int cnt;

        public Node(int x, int y, int z, int cnt){
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }
}
