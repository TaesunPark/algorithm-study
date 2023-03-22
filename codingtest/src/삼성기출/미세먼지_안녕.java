package 삼성기출;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미세먼지_안녕 {
    // 6 <= R, C <= 50
    static int R;
    static int C;
    static int T;
    static int[][] map;
    static int[][] copyMap;
    static Queue<Node> queue;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int airPos1;
    static int airPos2;
    static int[][] tmpMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt(); // 세로
        C = sc.nextInt(); // 가로
        T = sc.nextInt();
        int airCnt = 0;
        map = new int[R][C];
        visited = new boolean[R][C];
        copyMap = new int[R][C];

        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                map[i][j] = sc.nextInt();
                copyMap[i][j] = map[i][j];
                if (map[i][j] == -1 && airCnt == 0){
                    airPos1 = i;
                    airCnt++;
                } else if (map[i][j] == -1 && airCnt == 1){
                    airPos2 = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            addQueue();
            bfs();
            copy();
            topRotate();
            downRotate();
            copy();
        }

        int result = 0;

        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                result += map[i][j];
            }
        }

        System.out.print(result + 2);
    }

    public static void addQueue(){
        queue = new LinkedList<>();

        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (map[i][j] == 0 || map[i][j] == -1) continue;

                queue.add(new Node(j, i, map[i][j]));
            }
        }
    }

    public static void bfs(){
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int now_x = node.x;
            int now_y = node.y;
            int now_size = node.size;

            if (now_size < 5) continue;
            int value = now_size / 5;
            int cnt = 0;

            for (int i = 0; i < 4; i++){
                int dx_x = now_x + dx[i];
                int dy_y = now_y + dy[i];
                if (dx_x < 0 || dy_y < 0 || dy_y >= R || dx_x >= C) continue;
                if (map[dy_y][dx_x] == -1) continue;
                map[dy_y][dx_x] += value;
                cnt++;
            }
            map[now_y][now_x] -= value * cnt;
        }
    }
    public static void printMap(){
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    // 반시계
    public static void topRotate(){
        // 아래 좌표가 airpos1
        // 맨위 <- (ok)
        for (int j = 1; j < C; j++){
            if (map[0][j - 1] == -1) continue;
            map[0][j - 1] = copyMap[0][j];
        }

        // 왼쪽
        for (int i = 1; i <= airPos1; i++){
            if (map[i][0] == -1) continue;
            if (copyMap[i-1][0] == -1) continue;
            map[i][0] = copyMap[i-1][0];
        }

        // 오른쪽 (ok)
        for (int i = 1; i <= airPos1; i++){
            if (map[i - 1][C - 1] == -1) continue;
            if (copyMap[i][C-1] == -1) continue;
            map[i - 1][C-1] = copyMap[i][C-1];
        }
        // 맨 아래 (ok)
        for (int j = 2; j < C; j++){
            map[airPos1][j] = copyMap[airPos1][j-1];
        }
        map[airPos1][1] = 0;
    }

    public static void downRotate(){
        // 시작점이 airpos2
        // 맨위
        for (int j = 2; j < C; j++){
            map[airPos2][j] = copyMap[airPos2][j-1];
        }
        map[airPos2][1] = 0;
        // 오른쪽
        for (int i = airPos2 + 1; i < R; i++){
            if (map[i][C-1] == -1) continue;
            if (copyMap[i-1][C-1] == -1) continue;
            map[i][C-1] = copyMap[i-1][C-1];
        }
        // 왼쪽
        for (int i = airPos2 + 1; i < R; i++){
            if (map[i-1][0] == -1) continue;
            if (copyMap[i][0] == -1) continue;
            map[i - 1][0] = copyMap[i][0];
        }

        // 맨 아래
        for (int j = 1; j < C; j++){
            if (map[R-1][j-1] == -1) continue;
            if (copyMap[R-1][j] == -1) continue;
            map[R - 1][j - 1] = copyMap[R - 1][j];
        }
    }

    public static void copy(){
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                copyMap[i][j] = map[i][j];
            }
        }
    }
    
    public static class Node{
        int x;
        int y;
        int size;

        public Node(int x, int y, int size){
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
    
}
