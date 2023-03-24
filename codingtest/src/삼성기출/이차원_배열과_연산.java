package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 이차원_배열과_연산 {
    static int r;
    static int c;
    static int k;
    static int rowSize;
    static int colSize;
    static int[][] map;
    static int[][] newMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[101][101];
        newMap = new int[101][101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()){
            int value = Integer.parseInt(st.nextToken());
            if (idx == 0){
                r = value;
            } else if(idx == 1){
                c = value;
            } else{
                k = value;
            }
            idx++;
        }

        for (int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            idx = 0;
            while (st.hasMoreTokens()){
                map[i][idx] = Integer.parseInt(st.nextToken());
                newMap[i][idx++] = map[i][idx];
            }
        }
        rowSize = 3;
        colSize = 3;
        int time = 0;

        while (time < 100){
            if (map[r-1][c-1] == k) break;

            if (rowSize <= colSize){
                // 모든 행에 대해서 정렬
                sortRow();
            } else{
                // 모든 열에 대해서 정렬
                sortCol();
            }

            time++;
        }

        if (time == 100){
            System.out.print("-1");
        } else{
            System.out.print(time);
        }
    }

    public static void sortRow(){

        int row = 0;
        int row_max = 0;
        newMap = new int[101][101];

        for (int i = 0; i < colSize; i++){
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            ArrayList<Node> list = new ArrayList<>();
            for (int j = 0; j < rowSize; j++){
                if (map[i][j] == 0) continue;
                hashMap.put(map[i][j], hashMap.getOrDefault(map[i][j], 0) + 1);
            }

            for (int value : hashMap.keySet()){
                list.add(new Node(value, hashMap.get(value)));
            }

            list.sort((o1, o2) ->{
                if (o1.cnt == o2.cnt){
                    return o1.value - o2.value;
                }else{
                    return o1.cnt - o2.cnt;
                }
            });

            row = hashMap.size() * 2;
            row_max = Math.max(row, row_max);

            if (row > 100){
                row = 100;
            }

            for (int j = 0; j < row; j++){
                if (j % 2 == 0) {
                    newMap[i][j] = list.get(j/2).value;
                } else{
                    newMap[i][j] = list.get((j/2)).cnt;
                }
            }
        }

        copy();
        rowSize = row_max;
    }

    public static void copy(){
        for (int i = 0; i < 101; i++){
            for (int j = 0; j < 101; j++){
                map[i][j] = newMap[i][j];
            }
        }
    }

    public static void sortCol(){
        int col = 0;
        int col_max = 0;
        newMap = new int[101][101];

        for (int i = 0; i < rowSize; i++){
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            ArrayList<Node> list = new ArrayList<>();
            for (int j = 0; j < colSize; j++){
                if (map[j][i] == 0) continue;
                hashMap.put(map[j][i], hashMap.getOrDefault(map[j][i], 0) + 1);
            }

            for (int value : hashMap.keySet()){
                list.add(new Node(value, hashMap.get(value)));
            }

            list.sort((o1, o2) ->{
                if (o1.cnt == o2.cnt){
                    return o1.value - o2.value;
                }else{
                    return o1.cnt - o2.cnt;
                }
            });

            col = hashMap.size() * 2;
            col_max = Math.max(col, col_max);

            if (col > 100){
                col = 100;
            }

            for (int j = 0; j < col; j++){
                if (j % 2 == 0) {
                    newMap[j][i] = list.get(j/2).value;
                } else{
                    newMap[j][i] = list.get(j/2).cnt;
                }
            }
        }
        copy();
        colSize = col_max;
    }

    public static class Node{
        int cnt;
        int value;

        public Node(int value, int cnt){
            this.value = value;
            this.cnt = cnt;
        }
    }
}
