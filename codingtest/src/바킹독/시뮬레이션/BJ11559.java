package 바킹독.시뮬레이션;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ11559 {

    public static char[][] map1; // map
    public static char[][] map2;
    public static boolean[][] check;
    public static int flag;
    public static int result;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map1 = new char[12][6];
        map2 = new char[12][6];
        check = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            String str = sc.next();
            for (int k = 0; k < 6; k++) {
                map1[i][k] = str.charAt(k);
            }
        }

        while (true) {
            flag = 0;
            check = new boolean[12][6];
            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    if (check[i][j] == false && map1[i][j] != '.') {
                        bfs(j, i);
                    }
                }
            }
            if (flag == 0) break;
            gravity();
            result++;
        }
        System.out.print(result);
    }

    public static void bfs(int x, int y){
        int cnt = 1;
        char color = map1[y][x];

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> tmp = new LinkedList<>();
        queue.add(new Node(map1[y][x], x, y));
        tmp.add(new Node(map1[y][x], x, y));
        check[y][x] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int now_x = node.x;
            int now_y = node.y;

            for (int i = 0; i < 4; i++){
                int dx_x = dx[i] + now_x;
                int dy_y = dy[i] + now_y;

                if (dx_x < 0 || dx_x > 5 || dy_y < 0 || dy_y > 11) continue;
                if (check[dy_y][dx_x] == true) continue;

                if (color == map1[dy_y][dx_x]){
                    check[dy_y][dx_x] = true;
                    queue.add(new Node(color, dx_x, dy_y));
                    tmp.add(new Node(color, dx_x, dy_y));
                    cnt++;
                }
            }
        }

        if (cnt >= 4){
            flag++;
            while (!tmp.isEmpty()){
                Node node1 = tmp.poll();
                map1[node1.y][node1.x] = '.';
                check[node1.y][node1.x] = false;
            }
        }
    }

    public static void printMap(){
        for (int i = 0; i < 12; i++){
            for (int j = 0; j < 6; j++){
                System.out.print(map1[i][j]);
            }
            System.out.println("");
        }
    }

    public static void gravity(){

        for (int i = 11; i>=0; i--){
            for (int j = 0; j < 6; j++){
                for (int k = i; k >= 0; k--){
                    if (map1[i][j] == '.' && map1[k][j] != '.'){
                        map1[i][j] = map1[k][j];
                        map1[k][j] = '.';
                    }
                }
            }
        }

    }

    public static class Node{
        char color;
        int x;
        int y;

        public Node(char color, int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }
    }
}
