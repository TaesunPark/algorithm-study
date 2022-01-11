package 바킹독.연습문제0x08;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BJ7576 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] check;
    static Queue<Node2> stack;
    static int[] dX = {1,0,-1,0};
    static int[] dY = {0,1,0,-1};
    static int count = 0;

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

        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                if(map[i][j] != -1 || check[i][j] == false || map[i][j] != 1){
                    check[i][j] = true;
                    count++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(count);

    }

    public static void bfs(int x, int y){
        stack = new LinkedList<>();
        stack.add(new Node2(x,y));

        while(!stack.isEmpty()){
            Node2 node = stack.poll();
            for(int i=0; i<4;i++){
                int nx = node.x + dX[i];
                int ny = node.y + dY[i];

                if(nx>=n || ny>=m || nx<0 || ny<0) continue;
                if(map[nx][ny] == -1 || map[nx][ny] == 1 || check[nx][ny] == true) continue;
                check[nx][ny] = true;
                map[nx][ny] = 1;
            }
        }

    }
}

class Node2{
    int x;
    int y;
    public Node2(int x, int y){
        this.x = x;
        this.y = y;
    }
}
