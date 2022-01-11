package 바킹독.연습문제0x08;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


class BJ2178{

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] check;
    static int count;
    static int[] dX = {1,0,-1,0};
    static int[] dY = {0,1,0,-1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++){
            String cmd = sc.next();
            for(int j=0; j<m;j++){
                map[i][j] = cmd.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(count);
    }
    public static void bfs(int x, int y){

        Queue<Node3> queue = new LinkedList<Node3>();
        queue.add(new Node3(x,y));
        check[x][y] = true;
        count++;

        while(!queue.isEmpty()){
            Node3 node = queue.poll();
            for(int i=0;i<4;i++){
                int dx = node.x + dX[i];
                int dy = node.y + dY[i];
                if(dx>=n || dx<0 || dy <0 || dy >= m) continue;
                if(check[dx][dy] == true || map[dx][dy] == 0) continue;
                queue.add(new Node3(dx, dy));
                count++;
                check[dx][dy] = true;
                map[dx][dy] = map[node.x][node.y] +1;
            }
        }
    }
}

class Node3{
    int x;
    int y;
    public Node3(int x, int y){
        this.x=x;
        this.y=y;
    }

}