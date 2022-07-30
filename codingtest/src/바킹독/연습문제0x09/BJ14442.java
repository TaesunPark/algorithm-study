package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14442 {
    public static void main(String[] args) throws IOException {
        Queue<Node> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] miro = new int[N][M];
        boolean[][][] check = new boolean[N][M][K+1];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for (int i=0; i<N; i++){
            String s = br.readLine();
            for (int j=0; j<M; j++){
                miro[i][j] = s.charAt(j) - 48;
            }
        }

        queue.offer(new Node(0,0,1,0));
        check[0][0][0] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;

            if (nowX == M-1 && nowY == N-1){
                System.out.print(node.cnt);
                return;
            }

            int cnt = node.cnt + 1;
            int dstCnt = node.dstCnt;

            for (int i=0; i<4; i++){
                int dx_x = nowX + dx[i];
                int dy_y = nowY + dy[i];
                if (dx_x < 0 || dx_x >= M || dy_y < 0 || dy_y >= N) continue;
                // 벽이 아닐 경우

                if (check[dy_y][dx_x][dstCnt] == false && miro[dy_y][dx_x] == 0){
                    queue.offer(new Node(dx_x, dy_y, cnt, dstCnt));
                    check[dy_y][dx_x][dstCnt] = true;
                } else if(miro[dy_y][dx_x] == 1){
                    // 부신 횟수가 남았을 경우
                    if (dstCnt<K && check[dy_y][dx_x][dstCnt+1] == false){
                        queue.offer(new Node(dx_x, dy_y, cnt, dstCnt+1));
                        check[dy_y][dx_x][dstCnt+1] = true;
                    }
                }

            }
        }
        System.out.print(-1);
    }

    static class Node{
        int x;
        int y;
        int cnt;
        int dstCnt;
        public Node(int x, int y, int cnt, int dstCnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dstCnt = dstCnt;
        }
    }
}
