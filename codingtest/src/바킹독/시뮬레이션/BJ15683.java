package 바킹독.시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ15683 {
    static int n,m;
    static int[][] board1 = new int[10][10];
    static int[][] board2 = new int[10][10];

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    static ArrayList<Node> cctv;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cctv = new ArrayList<>();
        n = sc.nextInt();
        m = sc.nextInt();
        int mn = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                board1[i][j] = sc.nextInt();
                if(board1[i][j] != 0 && board1[i][j] != 6){
                    cctv.add(new Node(i,j));
                }
                if (board1[i][j] == 0){
                    mn++;
                }
            }
        }

        for (int tmp = 0; tmp < (1<<(2*cctv.size())); tmp++){
            for (int i = 0 ; i < n; i++){
                for (int j = 0; j < m; j++){
                    board2[i][j] = board1[i][j];
                }
            }
            int brute = tmp;

            for (int i = 0; i < cctv.size(); i++){
                int dir = brute % 4;
                brute /= 4;
                int x = cctv.get(i).x;
                int y = cctv.get(i).y;
                if (board1[x][y] == 1){
                    upd(x,y,dir);
                } else if(board1[x][y] == 2){
                    upd(x,y,dir);
                    upd(x,y,dir+2);
                } else if(board1[x][y] == 3){
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                } else if(board1[x][y] == 4){
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                    upd(x,y,dir+2);
                } else{
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                    upd(x,y,dir+2);
                    upd(x,y,dir+3);
                }
            }
            int val = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if(board2[i][j] == 0){
                        val += 1;
                    }
                }
            }
            mn = Math.min(mn, val);
        }
        System.out.print(mn);
    }

    public static boolean OOB(int a, int b){
        return a < 0 || a >=n || b < 0 || b >= m;
    }

    static void upd(int x, int y, int dir){
        dir %= 4;
        while (true){
            x += dx[dir];
            y += dy[dir];
            if (OOB(x,y) || board2[x][y] == 6) return;
            if (board2[x][y] != 0) continue;
            board2[x][y] = 7;
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
