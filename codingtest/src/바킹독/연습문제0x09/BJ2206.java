package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> queue = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        char[][] miro = new char[N][M];

        boolean[][][] visit = new boolean[2][N][M];

        for (int i=0; i<N; i++){
            String s = br.readLine();
            for (int j=0; j<M; j++){
                miro[i][j] = s.charAt(j);
            }
        }

        queue.add(new Node(0,0,1,false));
        visit[0][0][0] = true;

        while (!queue.isEmpty()){
            Node now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;
            int cnt = now.cnt;
            boolean check = now.checked;

            if (now.y == N-1 && now.x == M-1){
                System.out.println(now.cnt);
                return;
            }

            for (int i=0; i<4; i++){
                int dx_x = nowX + dx[i];
                int dy_y = nowY + dy[i];

                if (dx_x < 0 || dx_x >=M || dy_y <0 || dy_y >=N) continue;

                // 벽이면
                if (miro[dy_y][dx_x] == '0'){
                    // 부신 벽이 없으면
                    if (now.checked == false && visit[0][dy_y][dx_x] == false){
                        queue.add(new Node(dx_x, dy_y, cnt+1, false));
                        visit[0][dy_y][dx_x] = true;
                    }// 한번이라도 부셨으면
                    else if(now.checked == true && visit[1][dy_y][dx_x] == false){
                        queue.add(new Node(dx_x, dy_y, cnt+1, true));
                        visit[1][dy_y][dx_x] = true;
                    }
                } else if (miro[dy_y][dx_x] == '1'){
                    // 부신 벽이 없으면 부셔
                    if (now.checked == false){
                        queue.add(new Node(dx_x, dy_y, cnt+1, true));
                        visit[1][dy_y][dx_x] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
    public static class Node{
        int x;
        int y;
        int cnt;
        boolean checked;
        public Node(int x, int y, int cnt, boolean checked){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.checked = checked;
        }
    }
}
