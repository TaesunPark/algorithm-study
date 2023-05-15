package 바킹독.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 예시 {

    static int[][] board;
    static boolean[][] vis;
    static int n, m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        n = 7;
        m = 10;

        Scanner sc = new Scanner(System.in);
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();


        queue.add(new Node(0, 0));
        vis[0][0] = true;

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print("("+cur.x + ", " + cur.y + ") -> ");

            for (int dir = 0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (vis[nx][ny] || board[nx][ny] != 1) continue;
                vis[nx][ny] = true;
                queue.add(new Node(nx,ny));
            }
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
