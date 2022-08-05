package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ6593 {

    static char[][][] map;
    static boolean[][][] check;
    static int[] dx = {0,0,0,0,1,-1};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {1,-1,0,0,0,0};
    static Queue<Node> queue;
    static int L; // 높이
    static int R; // y
    static int C; // x

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.clear();
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) return;

            check = new boolean[L][R][C];
            map = new char[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String input = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char ch = input.charAt(k);
                        map[i][j][k] = input.charAt(k);
                        if (ch == 'S') {
                            queue.offer(new Node(k, j, i, 0));
                            check[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs();

            if (result == 0){
                System.out.println("Trapped!");
            } else{
                System.out.print("Escaped in ");
                System.out.print(result);
                System.out.println(" minute(s).");
            }
        }

    }
    static int bfs(){
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;
            int nowZ = node.z;
            int nowCnt = node.cnt;

            if (map[nowZ][nowY][nowX] == 'E'){
                return nowCnt;
            }


            for (int j=0; j<6; j++){
                int dy_y = nowY + dy[j];
                int dx_x = nowX + dx[j];
                int dz_z = nowZ + dz[j];

                if (dz_z < 0 || dz_z >= L || dy_y < 0 || dy_y >= R || dx_x < 0 || dx_x >= C  || map[dz_z][dy_y][dx_x] == '#' || check[dz_z][dy_y][dx_x] == true) continue;
                check[dz_z][dy_y][dx_x] = true;
                queue.add(new Node(dx_x,dy_y,dz_z,nowCnt+1));
            }

        }
        return 0;
    }
    static class Node{
        int x;
        int y;
        int z;

        int cnt;

        public Node(int x, int y, int z, int cnt){
            this.x =x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }
}
