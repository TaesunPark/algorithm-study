package 바킹독.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ10026 {
    static int n;
    static char[][] map;
    static boolean[][] check;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new char[n][n];
        check = new boolean[n][n];
        int result1 = 0;
        int result2 = 0;

        for(int i = 0; i < n; i++){
            String str = sc.next();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(check[i][j] == true) continue;
                bfs(map[i][j], j, i, 0);
                result1++;
            }
        }

        check = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(check[i][j] == true) continue;
                bfs(map[i][j], j, i, 1);
                result2++;
            }
        }

        System.out.print(result1 + " ");
        System.out.print(result2);

    }

    public static void bfs(char name, int m1, int n1, int a){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(m1, n1, name));
        check[n1][m1] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for(int i = 0; i < 4; i++){
                int dx_x = x + dx[i];
                int dy_y = y + dy[i];

                if(dx_x < 0 || dx_x >= n || dy_y < 0 || dy_y >= n) continue;
                if(check[dy_y][dx_x] == true) continue;
                if(a == 0 && map[dy_y][dx_x] != name) continue;
                if(a == 1){
                    if(map[dy_y][dx_x] == 'G' && name == 'B') continue;
                    if(map[dy_y][dx_x] == 'R' && name == 'B') continue;
                    if(map[dy_y][dx_x] == 'B' && name == 'G') continue;
                    if(map[dy_y][dx_x] == 'B' && name == 'R') continue;
                }
                check[dy_y][dx_x] = true;
                queue.add(new Node(dx_x, dy_y, name));
            }

        }

    }

    public static class Node{
        int x;
        int y;
        char name;
        public Node(int x, int y, char name){
            this.x = x;
            this.y = y;
            this.name =name;
        }
    }
}
