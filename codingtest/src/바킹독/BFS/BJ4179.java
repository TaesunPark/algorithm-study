package 바킹독.BFS;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ4179 {
    public static Queue<Node> fireQueue;
    public static Queue<Node> jQueue;
    public static char[][] map;
    public static int[][] jTime;
    public static int[][] fTime;
    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {1,0,-1,0};
    public static int n,m;
    public static int result;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        fireQueue = new LinkedList<>();
        jQueue = new LinkedList<>();

        map = new char[n][m];
        jTime = new int[n][m];
        fTime = new int[n][m];

        for(int i = 0; i<n; i++){
            Arrays.fill(jTime[i], -1);
            Arrays.fill(fTime[i], -1);
        }

        for(int i = 0; i < n; i++){
            String str = sc.next();

            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'J'){
                    jQueue.add(new Node(j, i));
                    jTime[i][j] = 0;
                } else if(map[i][j] == 'F'){
                    fireQueue.add(new Node(j, i));
                    fTime[i][j] = 0;
                }
            }
        }

        fBfs();
        jBfs();

        if(result == -1){
            System.out.println("IMPOSSIBLE");
        } else{
            System.out.println(result);
        }
    }

    public static void fBfs(){

        while(!fireQueue.isEmpty()){
            Node node = fireQueue.poll();
            int x = node.x;
            int y = node.y;

            for(int i = 0; i<4; i++){
                int dx_x = dx[i] + x;
                int dy_y = dy[i] + y;

                if(dx_x < 0 || dx_x >= m || dy_y < 0 || dy_y >= n) continue;
                if( fTime[dy_y][dx_x] > -1 || map[dy_y][dx_x] == '#') continue;
                fTime[dy_y][dx_x] = fTime[y][x] + 1;
                fireQueue.add(new Node(dx_x, dy_y));
            }

        }
    }

    public static void jBfs(){
        while(!jQueue.isEmpty()){
            Node node = jQueue.poll();
            int x = node.x;
            int y = node.y;


            for(int i = 0; i<4; i++){
                int dx_x = dx[i] + x;
                int dy_y = dy[i] + y;

                if(dx_x < 0 || dx_x >= m || dy_y < 0 || dy_y >= n ){
                    result = jTime[y][x] + 1;
                    return;
                }

                if(map[dy_y][dx_x] == '#') continue;
                if(jTime[dy_y][dx_x] > -1) continue;
                if(fTime[dy_y][dx_x] != -1 && fTime[dy_y][dx_x] <= jTime[y][x] + 1) continue;
                jTime[dy_y][dx_x] = jTime[y][x] + 1;
                jQueue.add(new Node(dx_x, dy_y));
            }
        }
        result = -1;
    }


    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

}
