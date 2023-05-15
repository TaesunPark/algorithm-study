package 삼성기출;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인구_이동 {

    static int N,L,R;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int result = 0;
    static ArrayList<Team> teams;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        map = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        while (true) {

            teams = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j] == true) continue;
                    // 연합 발생이 0이면
                    bfs(i, j);
                }
            }

            if (teams.size() == 0){
                break;
            }

            teams.sort((o1, o2) -> o1.type - o2.type);
            for (int i = 0; i < teams.size(); i++){
                System.out.print(teams.get(i).type);
            }

            check = new boolean[N][N];
            result++;
        }


    }

    public static void bfs(int y, int x){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        teams.add(new Team(x,y, N * y + x));

        check[y][x] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int now_x = node.x;
            int now_y = node.y;

            for (int i = 0; i < 4; i++){
                int dx_x = now_x + dx[i];
                int dy_y = now_y + dy[i];

                if (dx_x < 0 || dy_y < 0 || dx_x >= N || dy_y >= N || check[dy_y][dx_x] == true) continue;
                if (Math.abs(map[now_y][now_x] - map[dy_y][dx_x]) >= L && Math.abs(map[now_y][now_x] - map[dy_y][dx_x]) <= R){
                    queue.add(new Node(dx_x, dy_y));
                    check[dy_y][dx_x] = true;
                    teams.add(new Team(dx_x,dy_y, N * y + x));
                }
            }
        }

    }
    public static class Team{
        int x;
        int y;
        int type;

        public Team(int x, int y, int type){
            this.type = type;
            this.x = x;
            this.y = y;
        }
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
