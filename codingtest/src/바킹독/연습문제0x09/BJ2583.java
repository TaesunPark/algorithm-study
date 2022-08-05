package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2583 {
    static Queue<Node> queue;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Integer> result = new ArrayList<>();

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        check = new boolean[N+1][M+1];

        for (int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            draw(fx, fy, sx, sy);
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (check[i][j] == true || map[i][j] == 1) continue;
                queue.offer(new Node(j,i, 0));
                check[i][j] = true;
                result.add(bfs());
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        int size = result.size();
        for (int i=0; i<size; i++){
            System.out.print(result.get(i)+" ");
        }
    }
    public static int bfs(){
        int max = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;
            max++;
            for (int i=0; i<4; i++){
                int dx_x = nowX + dx[i];
                int dy_y = nowY + dy[i];
                if (dx_x <0 || dx_x>=M || dy_y <0 || dy_y >=N || map[dy_y][dx_x] == 1 || check[dy_y][dx_x] == true) continue;
                check[dy_y][dx_x] = true;
                queue.offer(new Node(dx_x, dy_y, 0));
            }
        }
        return max;
    }

    public static void draw(int fx, int fy, int sx, int sy){
        for (int i=fy; i<sy; i++){
            for (int j=fx; j<sx; j++){
                map[i][j] = 1;
            }
        }
    }

    static class Node{
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt){
            this.cnt = cnt;
            this.x = x;
            this.y = y;
        }
    }
}
