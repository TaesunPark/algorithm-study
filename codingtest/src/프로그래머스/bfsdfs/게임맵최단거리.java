package 프로그래머스.bfsdfs;

import java.util.Queue;
import java.util.LinkedList;

class Solution1 {
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};
    public static int min = Integer.MAX_VALUE;

    public static Queue<Node> queue;
    public int solution(int[][] maps) {
        int answer = 0;
        bfs(maps);
        answer = min;
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        return answer;
    }

    public void bfs(int[][] maps){
        Queue<Node> queue = new LinkedList<Node>();
        boolean[][] check = new boolean[maps.length][maps[0].length];
        min = Integer.MAX_VALUE;

        queue.add(new Node(0, 0, 1));
        check[0][0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;

            if(x == maps[0].length - 1 && y == maps.length - 1){
                min = Math.min(min, cnt);
            }

            for(int i=0; i<4; i++){
                int dx_x = x + dx[i];
                int dy_y = y + dy[i];

                if(dx_x < 0 || dx_x >= maps[0].length || dy_y < 0 || dy_y >= maps.length){
                    continue;
                }
                if(check[dy_y][dx_x] == true || maps[dy_y][dx_x] == 0){
                    continue;
                }
                queue.add(new Node(dx_x, dy_y, cnt + 1));
                check[dy_y][dx_x] = true;
            }
        }

    }

    public class Node{

        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
