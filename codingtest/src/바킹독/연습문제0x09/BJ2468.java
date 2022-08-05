package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2468 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static int[][] map;
    static boolean[][] check;
    static ArrayList<Integer> highMap;
    static Queue<Node> queue;
    static int newMap[][];
    public static void main(String[] args) throws IOException {
        boolean[] checkedMap = new boolean[101];
        highMap = new ArrayList<>();
        int size = 0;
        queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (checkedMap[num] == false) {
                    checkedMap[num] = true;
                    highMap.add(num);
                }

            }
        }


        for (Integer s : highMap) {
            max = size > max ? size:max;
            check = new boolean[N][N];
            newMap = new int[N][N];

            size = 0;

            for (int i=0; i<N;i++){
                for (int j=0; j<N;j++){
                    if (s > map[i][j]){
                        newMap[i][j] = 0;
                    } else{
                        newMap[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (newMap[i][j] == 0 || check[i][j] == true) continue;
                    queue.offer(new Node(j, i));
                    check[i][j] = true;
                    size++;
                    bfs();
                }
            }
        }
        if (max == 0){
            System.out.print(1);
        } else{
            System.out.print(max);
        }

    }
    static void bfs(){
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;
            for(int i=0; i<4; i++){
                int dx_x = nowX + dx[i];
                int dy_y = nowY + dy[i];
                if (dx_x<0 || dy_y<0 || dx_x >= N || dy_y >= N || newMap[dy_y][dx_x] == 0 || check[dy_y][dx_x] == true) continue;
                queue.offer(new Node(dx_x, dy_y));
                check[dy_y][dx_x] = true;
            }

        }
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
