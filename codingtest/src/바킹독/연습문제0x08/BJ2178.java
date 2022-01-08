package 바킹독.연습문제0x08;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BJ2178 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] check;
    static int[] dX = {1,0,-1,0};
    static int[] dY = {0,1,0,-1};
    static Queue<Node> queue;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n;i++){
            String input = sc.next();
            for(int j=0;j<m;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        check[0][0] = true;
        bfs(0, 0);
        System.out.println(map[n-1][m-1]);

    }
    public static void bfs(int x, int y){
        queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0; i<4;i++){
                int nx = node.x + dX[i];
                int ny = node.y + dY[i];
                if(nx >= n || ny >= m || nx<0 || ny <0) continue;
                if(map[nx][ny] == 0 || check[nx][ny]) continue;
                queue.add(new Node(nx, ny));
                check[nx][ny] = true;
                map[nx][ny] = map[node.x][node.y] + 1;
            }
        }
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}