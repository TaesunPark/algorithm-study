package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5427 {
    // 불 큐
    static Queue<Node> fireQueue = new LinkedList<>();
    // 빈공간 큐
    static Queue<Node> queue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int w;
    static int h;
    static boolean[][] isCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int cnt1=0;
            boolean check = false;
            fireQueue.clear();
            queue.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            isCheck = new boolean[h][w];
            for (int j = 0; j < h; j++) {
                String s = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = s.charAt(k);
                    if (map[j][k] == '*') {
                        fireQueue.add(new Node(k, j, 0));
                    }
                    if (map[j][k] == '@') {
                        queue.add(new Node(k, j, 1));
                        isCheck[j][k] = true;
                    }
                }
            }
            while (!queue.isEmpty()) {

                Node node = queue.poll();

                if (cnt1 != node.cnt) {
                    cnt1++;
                    burn();
                }

                int nowX = node.x;
                int nowY = node.y;

                if (nowX == 0 || nowX == w-1 || nowY == 0 || nowY == h-1){
                    check = true;
                    System.out.println(node.cnt);
                    break;
                }
                int cnt = node.cnt;

                for (int f = 0; f < 4; f++) {
                    int dx_x = dx[f] + nowX;
                    int dy_y = dy[f] + nowY;

                    if (dx_x < 0 || dx_x >= w || dy_y < 0 || dy_y >= h) continue;
                    if (map[dy_y][dx_x] == '.' && isCheck[dy_y][dx_x] == false){
                        isCheck[dy_y][dx_x] = true;
                        queue.add(new Node(dx_x, dy_y, cnt + 1));
                    }
                }
            }
            if (check == false) System.out.println("IMPOSSIBLE");
        }

    }
    static void burn() {
        int size = fireQueue.size();
        for (int i = 0; i < size; i++) {

            Node node = fireQueue.poll();
            int nowX = node.x;
            int nowY = node.y;

            for (int f = 0; f < 4; f++) {
                int dx_x = dx[f] + nowX;
                int dy_y = dy[f] + nowY;

                if (dx_x < 0 || dx_x >= w || dy_y < 0 || dy_y >= h) continue;
                if (map[dy_y][dx_x] == '.' || map[dy_y][dx_x] == '@') {
                    map[dy_y][dx_x] = '*';
                    fireQueue.add(new Node(dx_x, dy_y,0));
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
