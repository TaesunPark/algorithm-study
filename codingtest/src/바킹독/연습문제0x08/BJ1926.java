package 바킹독.연습문제0x08;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ1926{

    static int n;
    static int m;
    static boolean[][] check;
    static int[][] map;
    static int max;
    static int count;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};
    static Queue<Node1> stack;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0 || check[i][j]) continue;
                check[i][j] = true;
                count++;
                bfs(i,j);
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    public static void bfs(int x, int y){
        stack = new LinkedList<>();
        stack.add(new Node1(x,y));
        int cnt = 0;

        while(!stack.isEmpty()){
            Node1 node = stack.poll();
            cnt++;
            for(int i=0; i<4; i++){
                int nX = dX[i] + node.x;
                int nY = dY[i] + node.y;
                if(nX < 0 || nY<0 || nX >= n || nY >= m) continue;
                if(check[nX][nY] || map[nX][nY] != 1) continue;
                check[nX][nY] = true;
                stack.add(new Node1(nX,nY));
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