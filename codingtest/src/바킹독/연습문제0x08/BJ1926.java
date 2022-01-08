package 바킹독.연습문제0x08;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BJ1926 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] check;
    static int[] dX = {1,0,-1,0};
    static int[] dY = {0,1,0,-1};
    static Queue<Node1> queue;
    static int count = 0;
    static int max = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0 || check[i][j]) continue;
                    count++;
                    check[i][j] = true;
                    bfs(i,j);
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    public static void bfs(int x, int y){
        queue = new LinkedList<>();
        queue.add(new Node1(x,y));
        int cnt = 0;

        while(!queue.isEmpty()){
            Node1 node = queue.poll();
            cnt++;

            for(int dir=0; dir<4; dir++){
                int nx = node.x + dX[dir];
                int ny = node.y + dY[dir];
                if(nx<0 || nx >= n || ny < 0 || ny >= m) continue;
                if(check[nx][ny] || map[nx][ny] != 1) continue;

                check[nx][ny] = true;
                queue.add(new Node1(nx, ny));
            }
        }

        max = Math.max(max, cnt);
    }

}

class Node1{
    int x;
    int y;
    public Node1(int x, int y){
        this.x = x;
        this.y = y;
    }
}