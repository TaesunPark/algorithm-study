package 프로그래머스;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

class 무인도_여행 {

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static char[][] map;
    public static boolean[][] checkedMap;
    public static int w;
    public static int h;

    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        w = maps[0].length();
        h = maps.length;
        map = new char[h][w];
        checkedMap = new boolean[h][w];
        int tmpCnt = 0;

        for(String s : maps){

            for(int i = 0; i < s.length(); i++){
                map[tmpCnt][i] = s.charAt(i);
            }

            tmpCnt++;
        }

        boolean check = false;

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(checkedMap[i][j] == true) continue;
                if(map[i][j] != 'X'){
                    check = true;
                    list.add(bfs(j,i, map[i][j]));
                }
            }
        }

        if(check == false){
            return new int[]{-1};
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

    public static int bfs(int x, int y, char value){
        Queue<Node> queue = new LinkedList<>();
        int sum = value - 48;
        checkedMap[y][x] = true;
        queue.add(new Node(x, y, value - 48));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int now_x = node.x;
            int now_y = node.y;

            for(int i = 0; i < 4; i++){
                int dx_x = now_x + dx[i];
                int dy_y = now_y + dy[i];

                if(dx_x < 0 || dx_x >= w || dy_y >= h || dy_y < 0) continue;
                if(checkedMap[dy_y][dx_x] == true || map[dy_y][dx_x] == 'X') continue;
                checkedMap[dy_y][dx_x] = true;
                queue.add(new Node(dx_x, dy_y, map[dy_y][dx_x] - 48));
                sum += map[dy_y][dx_x] - 48;
            }
        }

        return sum;
    }

    static class Node{
        int x;
        int y;
        int value;

        public Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }

    }

}