package 바킹독.연습문제0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BJ15683{
    public static int n;
    public static int m;
    public static int max = 100;
    public static int[][] map;
    public static ArrayList<Node> arrayList;
    public static int[] dirList = {4, 2, 4 ,4 ,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arrayList = new ArrayList<Node>();
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new int[n][m];
        for (int i=0; i<n; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 0;
            while (st.hasMoreTokens()){
                map[i][index] = Integer.parseInt(st.nextToken());
                if (map[i][index] != 0 && map[i][index] != 6){
                    arrayList.add(new Node(i, index, map[i][index]-1));
                }
                index++;
            }
        }
        dfs(0);
        System.out.print(max);
    }

    public static void dfs(int size){
        if (size == arrayList.size()){
            int cnt = 0;
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    if (map[i][j] == 0){
                        cnt++;
                    }
                }
            }
            if (max>cnt){
                max = cnt;
            }
            return;
        }

        Node node = arrayList.get(size);
        int[][] tmpMap = new int[n][m];

        for (int i = 0; i<dirList[node.type]; i++){
            tmpMap = copyMap(map, tmpMap);
            switch (node.type){
                case 0:
                    update(node, i);
                    break;
                case 1:
                    update(node, i);
                    update(node, i+2);
                    break;
                case 2:
                    update(node, i);
                    update(node, i+1);
                    break;
                case 3:
                    update(node, i);
                    update(node, i+1);
                    update(node, i+2);
                    break;
                case 4:
                    update(node, i);
                    update(node, i+1);
                    update(node, i+2);
                    update(node, i+3);
                    break;
            }
            dfs(size + 1);
            map = copyMap(tmpMap, map);
        }
    }

    public static void update(Node node, int type){

        type = type % 4;

        if (type == 0){
            for (int x = node.x+1; x<m; x++){
                if (map[node.y][x] == 6) break;
                if (map[node.y][x] != 0) continue;
                map[node.y][x] = -1;
            }
        } else if(type == 1){
            for (int y = node.y-1; y>=0; y--){
                if (map[y][node.x] == 6) break;
                if (map[y][node.x] != 0) continue;
                map[y][node.x] = -1;
            }
        }else if(type == 2){
            for (int x = node.x-1; x>=0; x--){
                if (map[node.y][x] == 6) break;
                if (map[node.y][x] != 0) continue;
                map[node.y][x] = -1;
            }
        }else if(type == 3){
            for (int y = node.y+1; y<n; y++){
                if (map[y][node.x] == 6) break;
                if (map[y][node.x] != 0) continue;
                map[y][node.x] = -1;
            }
        }
    }

    public static int[][] copyMap(int[][] map, int[][] copyMap){
        for (int i=0; i<map.length; i++){
            System.arraycopy(map[i], 0, copyMap[i], 0,map[i].length);
        }
        return copyMap;
    }

    static class Node{
        int y;
        int x;
        int type;
        public Node(int y, int x, int type){
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }
}