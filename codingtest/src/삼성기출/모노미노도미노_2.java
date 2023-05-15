package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 모노미노도미노_2 {
    static int N;
    static int[][] blueMap;
    static int[][] greenMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        blueMap = new int[N][N];
        greenMap = new int[N][N];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int type = Integer.parseInt(st.nextToken());
            queue.add(new Node(r,c,type));
        }

        while (queue.isEmpty()){
            Node node = queue.poll();
            int r = node.x;
            int c = node.y;
            int type = node.type;
            pushBlock(r,c,type);
        }

    }
    public static void pushBlock(int r, int c, int type){
        // 기본 블럭
        if (type == 1){

        } else if(type == 2){

        } else{

        }
    }

    public static void pushGreenMap(int r, int c, int type){
        // check 1 * 2 블록
        // 놓을 위치 체크, y만 체크하면 됨.
        int put_x, put_y;
        if (type == 2){
            for (int i = 0; i <= 5; i++){
                if (i != 5 && greenMap[i][r] == 0 || greenMap[i][r+1] == 0){
                    continue;
                } else{
                    if (i == 5){
                        greenMap[5][r] = 1;
                        greenMap[5][r + 1] = 1;
                    } else {
                        greenMap[i - 1][r] = 1;
                        greenMap[i - 1][r + 1] = 1;
                    }
                }
            }
        } else if(type == 3){
            for (int i = 0; i <= 5; i++){
                if (i != 5 && greenMap[i][r] == 0){
                    continue;
                } else{
                    if (i == 5){
                        greenMap[5][r] = 3;
                        greenMap[4][r] = 3;
                    } else{
                        greenMap[c][r] = 3;
                        greenMap[c-1][r] = 3;
                    }
                }
            }
        } else{

        }

    }

    public static class Node{
        int x;
        int y;
        int type;

        public Node(int x, int y, int type){
            this.x =x;
            this.y = y;
            this.type = type;
        }
    }
}
