package 삼성기출;

import java.util.ArrayList;
import java.util.Scanner;

public class 치킨_배달 {
    static int[][] map;
    static int N, M;
    static boolean[] check;
    static ArrayList<Node> chickenList;
    static ArrayList<Node> homeList;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        chickenList = new ArrayList<>();
        homeList = new ArrayList<>();
        map = new int[N][N];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1){
                    homeList.add(new Node(j, i));
                } else if(map[i][j] == 2){
                    chickenList.add(new Node(j, i));
                }
            }
        }
        check = new boolean[chickenList.size()];
        comb(0, 0);
        System.out.print(result);
    }

    public static void comb(int st, int depth){
        int sum = 0;
        if (depth == M){
            for (int i = 0; i < homeList.size(); i++){
                int ret = Integer.MAX_VALUE;
                for (int j = 0; j < chickenList.size(); j++){
                    if (check[j] == false) continue;
                    int dist = Math.abs(homeList.get(i).x - chickenList.get(j).x) + Math.abs(homeList.get(i).y - chickenList.get(j).y);
                    ret = Math.min(ret, dist);
                }
                sum += ret;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = st; i < N; i++){
            if (check[i] == true) continue;
            check[i] = true;
            comb(i + 1, depth + 1);
            check[i] = false;
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
