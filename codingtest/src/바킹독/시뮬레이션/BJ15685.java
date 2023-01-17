package 바킹독.시뮬레이션;

import java.util.Scanner;
import java.util.Stack;

public class BJ15685 {
    static int[][] map;
    static Stack<Node> stack;
    static Stack<Node> tmp;
    static Stack<Node> tmp2;
    static int[] dx = {1,0,-1,0}; // 동, 북 , 서, 남
    static int[] dy = {0,-1,0,1};
    static boolean[][] check;
    static int d;
    static int x,y,g;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[101][101];
        check = new boolean[101][101];

        for (int i = 0; i < n; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            d = sc.nextInt();
            g = sc.nextInt();
            map[y][x] = 1;
            stack = new Stack<>();
            tmp = new Stack<>();
            tmp2 = new Stack<>();
            int next_x = x + dx[d];
            int next_y = y + dy[d];
            map[next_y][next_x] = 1;
            stack.add(new Node(x, y, next_x, next_y, d));
            //tmp.add(new Node(x, y, next_x, next_y, d));
            curve(0);
        }

        int result = 0;

        for (int i = 0; i < 101; i++){
            for (int j = 0; j < 101; j++){
                if (map[i][j] == 1 && check[i][j] == false){
                    check[i][j] = true;
                    if (map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1){
                        result++;
                    }
                }
            }
        }

        System.out.print(result);
    }

    public static void curve(int cnt){
        if (cnt == g) return;

        tmp2 = (Stack<Node>) stack.clone();

        int f_x = stack.peek().f_x;
        int f_y = stack.peek().f_y;

        while (!tmp2.isEmpty()) {
            Node node = tmp2.pop();
            int next_dir = node.dir + 1;
            if (next_dir == 4) next_dir = 0;
            f_x = f_x + dx[next_dir];
            f_y = f_y + dy[next_dir];
            map[f_y][f_x] = 1;
            stack.add(new Node(node.f_x, node.f_y, f_x, f_y, next_dir));
        }

        curve(cnt + 1);
    }

    public static class Node{
        int x;
        int y;
        int f_x;
        int f_y;
        int dir;

        public Node(int x, int y, int f_x, int f_y, int dir){
            this.x = x;
            this.y = y;
            this.f_x = f_x;
            this.f_y = f_y;
            this.dir = dir;
        }
    }
}
