package 프로그래머스;

import java.util.Queue;
import java.util.LinkedList;

class 거리두기_확인하기 {
    static Queue<Node> queue;
    static int[] dx = {-1, 0 ,1 ,0};
    static int[] dy = {0, -1 ,0 ,1};
    static boolean[][] check;
    static int[][][] map;

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        check = new boolean[5][5];
        map = new int[5][5][5];
        int idx = 0;
        int idx2 = 0;

        for(String[] strArr : places){
            idx2 = 0;
            for(String str : strArr){
                for(int i = 0; i < 5; i++){
                    map[idx][idx2][i] = str.charAt(i);
                }
                idx2++;
            }
            idx++;
        }

        for(int i = 0; i < 5; i++){
            int checked = 1;
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(map[i][j][k] == 'P'){
                        if(bfs(i,j,k) == 0){
                            checked = 0;
                            break;
                        };
                    }
                }
                if(checked == 0){
                    break;
                }
            }
            answer[i] = checked;
        }

        return answer;
    }

    public static int bfs(int i, int y, int x){
        queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        check = new boolean[5][5];
        check[y][x] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int now_x = node.x;
            int now_y = node.y;
            int now_cnt = node.cnt;

            if(node.cnt == 3){
                return 1;
            }

            if(map[i][now_y][now_x] == 'X') continue;
            if(map[i][now_y][now_x] == 'P' && now_cnt >= 1){
                return 0;
            }


            for(int m = 0; m < 4; m++){
                int dx_x = dx[m] + now_x;
                int dy_y = dy[m] + now_y;

                if(dx_x < 0 || dx_x >= 5 || dy_y < 0 || dy_y >= 5 || check[dy_y][dx_x] == true) continue;
                check[dy_y][dx_x] = true;
                queue.add(new Node(dx_x, dy_y, now_cnt + 1));
            }
        }

        return 1;
    }

    public static class Node{
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