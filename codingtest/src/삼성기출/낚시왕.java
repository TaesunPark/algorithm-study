package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 낚시왕 {
    
    static int R,C,M;
    static int[][] map;
    static Queue<Shark> queue;
    static int[] dx = {0,0,0,1,-1};
    static int[] dy = {0,- 1,1,0,0};

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new LinkedList<>();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[C+1][R+1];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                Shark node = new Shark(x,y,s,d,z);
                queue.add(node);
            }
        }

        // 낚시왕 이동
    }

    public static class Shark{

        int dir; // 방향
        int size; // 크기
        int speed; // 속도
        int x;
        int y;

        public Shark(int x, int y, int speed, int dir, int size){
            this.dir = dir;
            this.size = size;
            this.speed = speed;
            this.x = x;
            this.y = y;
        }

        public void move(){
            int next_x = x + (dx[dir] * speed);
            int next_y = y + (dy[dir] * speed);

            if (next_x > R){
                if ((next_x / R) % 2 == 0){
                    next_x = R - (next_x % R);
                    dir *= -1;
                } else{
                    next_x = next_x % R;
                }
            }

            if (next_y > C){

            }
        }
    }
}
