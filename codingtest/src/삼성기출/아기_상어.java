package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기_상어 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<Node> pq;
    static Queue<Node> queue;
    static int[] dx = {-1, 0, 0, 1}; // 북 서 동 남
    static int[] dy = {0, -1, 1, 0};
    static int sharkSize = 2;
    static int result = 0;
    static int fishCnt = 0;
    public static void main(String[] args) throws IOException {
        pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()){
                map[i][idx] = Integer.parseInt(st.nextToken());
                if (map[i][idx] == 9){
                    queue.add(new Node(idx, i, 0, 2));
                    visited[i][idx] = true;
                    map[i][idx] = 0;
                }
                idx++;
            }
        }
        bfs();

        System.out.print(result);
    }

    public static void bfs(){
        while (true) {
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int now_x = node.x;
                int now_y = node.y;
                int time = node.time;

                for (int i = 0; i < 4; i++) {
                    int dx_x = now_x + dx[i];
                    int dy_y = now_y + dy[i];

                    if (dx_x < 0 || dx_x >= N || dy_y < 0 || dy_y >= N || visited[dy_y][dx_x] == true || node.size < map[dy_y][dx_x])
                        continue;
                    // 물고기 먹으면
                    if (map[dy_y][dx_x] != 0 && node.size > map[dy_y][dx_x]) {
                        pq.add(new Node(dx_x, dy_y, time + 1, node.size));
                    } else {
                        // 0 이거나 크기가 같은 상황
                        queue.add(new Node(dx_x, dy_y, time + 1, node.size));
                    }
                    visited[dy_y][dx_x] = true;
                }
            }

            if (pq.isEmpty()) break;
            // 물고기 먹고 상어 위치 변경
            Node node = pq.poll();
            pq.clear();
            map[node.y][node.x] = 0;

            fishCnt++;
            if (fishCnt == sharkSize) {
                sharkSize++;
                fishCnt = 0;
            }
            result += node.time;
            visited = new boolean[N][N];
            visited[node.y][node.x] = true;
            queue.add(new Node(node.x, node.y, 0, sharkSize));
        }
    }

    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int time;
        int size;

        public Node(int x, int y, int time, int size){
            this.x = x;
            this.y = y;
            this.time = time;
            this.size = size;
        }

        @Override
        public int compareTo(Node o1){
            if (o1.time != this.time){
                return this.time - o1.time;
            }
            if (o1.y == this.y){
                return this.x - o1.x;
            } else{
                return this.y - o1.y;
            }
        }
    }

}