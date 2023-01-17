package 바킹독.시뮬레이션;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ3190 {
    public static int n;
    public static int[][] map;
    public static boolean[][] check;
    public static Queue<Node> queue;
    public static Queue<Tail> tail;

    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};
    public static int dir;
    public static int time;
    public static int[] now_loc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue = new LinkedList<>();
        tail = new LinkedList<>();
        now_loc = new int[]{0,0};
        n = sc.nextInt();
        check = new boolean[n][n];
        map = new int[n][n];
        map[0][0] = 2; // 꼬리
        tail.add(new Tail(0,0));
        dir = 1; // 동
        time = -1;
        // 0 : 북 , 2 : 남, 3 : 서
        int A = sc.nextInt();

        for (int i = 0; i < A; i++){
            int q = sc.nextInt();
            int p = sc.nextInt();

            map[q-1][p-1] = 1;
        }

        int cmd = sc.nextInt();

        for (int i = 0; i < cmd; i++){
            int second = sc.nextInt();
            char cr = sc.next().charAt(0);
            queue.add(new Node(cr, second));
        }

        while (true){
            time++;

            if (!queue.isEmpty() && queue.peek().second == time){
                Node node = queue.poll();

                if (node.cmd == 'D'){
                    // 오른쪽으로 방향 전환
                    dir++;
                    if (dir == 4){
                        dir = 0;
                    }
                }

                if (node.cmd == 'L'){
                    dir--;
                    if (dir == -1){
                        dir = 3;
                    }
                }
            }

            now_loc[0] = now_loc[0] + dx[dir]; // x
            now_loc[1] = now_loc[1] + dy[dir]; // y

            if (now_loc[0] < 0 || now_loc[0] >= n || now_loc[1] < 0 || now_loc[1] >= n) break;

            if (map[now_loc[1]][now_loc[0]] == 2) break;

            if (map[now_loc[1]][now_loc[0]] == 1){
                map[now_loc[1]][now_loc[0]] = 2;
                tail.add(new Tail(now_loc[0], now_loc[1]));
            } else {
                Tail tail1 = tail.poll();
                map[tail1.y][tail1.x] = 0;
                map[now_loc[1]][now_loc[0]] = 2;
                tail.add(new Tail(now_loc[0], now_loc[1]));
            }
        }

        System.out.print(time + 1);
    }

    public static class Node{
        char cmd;
        int second;
        public Node(char cmd, int second){
            this.second = second;
            this.cmd = cmd;
        }
    }

    public static class Tail{
        int x;
        int y;
        public Tail(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}