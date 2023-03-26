package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_3 {
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> queue;
    static int N;
    static int M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Node> list;
    static boolean[] checked;
    static int S;
    static ArrayList<Node> tmp;
    static int value = Integer.MAX_VALUE;
    static int wallCnt;
    static int emptyCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();

        while (st.hasMoreTokens()){
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }

        map = new int[N][N];
        visited = new boolean[N][N];
        tmp = new ArrayList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2){
                    list.add(new Node(0,j,i));
                    map[i][j] = 3;
                    S++;
                }

                if (map[i][j] == 1){
                    wallCnt++;
                }

                if (map[i][j] == 0){
                    emptyCnt++;
                }
            }
        }


        checked = new boolean[S];

        if (emptyCnt == 0){
            System.out.print(0);
            return;
        }

        dfs(0,0);
        if (value == Integer.MAX_VALUE){
            System.out.print(-1);
        } else {
            System.out.print(value);
        }
    }

    static int bfs(ArrayList<Node> arrayList){
        // 종료 조건이 빈칸이 다 없어지면 됨.
        int result = 0;
        visited = new boolean[N][N];
        queue = new LinkedList<>();
        int cnt = 0;

        for (int i = 0; i < arrayList.size(); i++){
            queue.add(new Node(0,arrayList.get(i).x, arrayList.get(i).y));
            visited[arrayList.get(i).y][arrayList.get(i).x] = true;
        }

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int now_x = node.x;
            int now_y = node.y;
            int now_time = node.time;

            for (int i = 0; i < 4; i++){
                int dx_x = dx[i] + now_x;
                int dy_y = dy[i] + now_y;

                if (dx_x < 0 || dx_x >= N || dy_y < 0 || dy_y >= N) continue;
                if (visited[dy_y][dx_x] == true) continue;
                if (map[dy_y][dx_x] == 1) continue;
                if (map[dy_y][dx_x] == 0) {
                    cnt++;
                    queue.add(new Node(now_time + 1, dx_x, dy_y));
                    visited[dy_y][dx_x] = true;
                    result = Math.max(result, now_time + 1);
                }
                if (map[dy_y][dx_x] == 3 || map[dy_y][dx_x] == 2){
                    queue.add(new Node(now_time + 1, dx_x, dy_y));
                    visited[dy_y][dx_x] = true;
                }
            }
        }

        if (emptyCnt == cnt){
            return result;
        } else{
            return Integer.MAX_VALUE;
        }

    }

    static void dfs(int st, int depth){
        if (depth == M){
            value = Math.min(bfs(tmp), value);
        }

        for (int i = st; i < S; i++){
            if (checked[i] == true) continue;
            tmp.add(new Node(0,list.get(i).x, list.get(i).y));
            checked[i] = true;
            map[list.get(i).y][list.get(i).x] = 2;
            dfs(i, depth+1);
            checked[i] = false;
            map[list.get(i).y][list.get(i).x] = 3;
            tmp.remove(tmp.size() - 1);
        }

    }

    static class Node{
        int time;
        int x;
        int y;

        public Node(int time, int x, int y){
            this.time = time;
            this.x = x;
            this.y = y;
        }
    }
}
