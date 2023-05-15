package 삼성기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 청소년_상어 {

    public static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
    public static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
    public static int[][] map = new int[4][4];
    public static Node[] fishList = new Node[17];
    public static Node shark;
    public static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        shark = new Node(0,0,0);

        for (int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++){
                int value = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                fishList[value] = new Node(j,i,dir);
            }
        }

        eatShark(0,0, map, fishList);
        result += map[0][0];
        //moveFish(fishList, map);
        moveShark(map, shark, fishList);
    }

    public static void moveShark(int[][] inMap, Node shark, Node[] inFishList){
        if (result < shark.size){
            result = shark.size;
        }
        // 물고기 움직이고
        moveFish(inFishList, inMap);
        // fish 먹고
        ArrayList<Node> list = eatFish(shark, inMap);

        for (int i = 0; i < list.size(); i++){
            int[][] copyMap = copiedMap(inMap);
            Node[] copyFish = copiedFish(inFishList);
            Node fish = list.get(i); // 이번 물고기
            // 새로운 샤크 방향 전환
            Node newShark = new Node(fish.x, fish.y, fish.dir);
            newShark.setSize(copyMap[fish.y][fish.x]);
            copyMap[fish.y][fish.x] = 0;
            moveShark(copyMap, newShark, copyFish);
        }

    }

    public static int[][] copiedMap(int[][] map){
        int[][] copy = new int[4][4];

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    public static Node[] copiedFish(Node[] fish){
        Node[] copy = new Node[17];
        for (int i = 0; i < 17; i++){
            copy[i] = fish[i];
        }
        return copy;
    }

    public static ArrayList<Node> eatFish(Node shark, int[][] inMap){
        ArrayList<Node> list = new ArrayList<>();
        int shark_dir = shark.dir;

        for (int i = 1; i <= 3; i++){
            int next_x = (shark.x + dx[shark_dir]) * i;
            int next_y = (shark.y + dy[shark_dir]) * i;
            if (next_y >= 4 || next_x >= 4 || next_x < 0 || next_y < 0) continue;
            if (inMap[next_y][next_x] == 0) continue;
            list.add(new Node(next_x, next_y, fishList[inMap[next_y][next_x]].dir));
        }

        return list;
    }

    public static void moveFish(Node[] inFishList, int[][] inMap){
        for (int i = 1; i <= 16; i++) {
            check(inFishList[i].x, inFishList[i].y, i, inMap, inFishList);
        }
    }

    public static void printMap(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    // 바꿀 수 있는 물고기를 넘겨줌
    public static boolean check(int x, int y, int num, int[][] inMap, Node[] inFishList){
        if (inMap[y][x] == 0) return false;
        int now_dir = inFishList[num].dir;

        int next_x = x + dx[now_dir];
        int next_y = y + dy[now_dir];

        for (int i = 0; i < 8; i++) {
            // 반시계 돌리기
            int next_dir = (now_dir + i) % 8;
            if (next_dir == 0){
                next_dir = 8;
            }

            next_x = x + dx[next_dir];
            next_y = y + dy[next_dir];

            if (next_y >= 4 || next_x >= 4 || next_x < 0 || next_y < 0) continue;
            if (next_y == shark.y && next_x == shark.x) continue;

            change(inFishList[inMap[y][x]], inFishList[inMap[next_y][next_x]], inMap, inFishList); // 물고기 바꾸기
            return true;
        }

        //실패
        return false;
    }

    public static void change(Node nowFish, Node nextFish, int[][] inMap, Node[] inFishList){
        Node tmp = new Node(nowFish.x, nowFish.y, nowFish.dir);
        int tmp2 = inMap[nowFish.y][nowFish.x];
        int tmp3 = inMap[nextFish.y][nextFish.x];
        inMap[nowFish.y][nowFish.x] = inMap[nextFish.y][nextFish.x];
        inMap[nextFish.y][nextFish.x] = tmp2;

        nowFish.x = nextFish.x;
        nowFish.y = nextFish.y;
        nextFish.x = tmp.x;
        nextFish.y = tmp.y;
        Node tmp4 = inFishList[tmp3];
        inFishList[tmp3] = inFishList[tmp2];
        inFishList[tmp2] = tmp4;
    }

    public static void eatShark(int x, int y, int[][] inMap, Node[] inFishList){
        shark = inFishList[inMap[y][x]];
        result += inMap[y][x];
        inMap[y][x] = 0;
    }

    public static class Node{
        int dir;
        int x;
        int y;
        int size;

        public Node(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public void setSize(int size){
            this.size += size;
        }
    }
}
