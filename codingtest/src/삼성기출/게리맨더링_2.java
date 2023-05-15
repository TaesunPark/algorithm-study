package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 게리맨더링_2 {
    static int[][] map;
    static int N;
    static int sum;

    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = 0;

            while (st.hasMoreTokens()){
                map[i][idx] = Integer.parseInt(st.nextToken());
                sum += map[i][idx++];
            }
        }

        set();

        for (int i = 0; i < list.size(); i++){
            divide(list.get(i).x - 1,list.get(i).y - 1, list.get(i).d1,list.get(i).d2);
            //divide(2,4,2,2);
        }
    }

    public static void set(){
        for (int x = 1; x < N; x++){
            for (int y = 1; y < N; y++){
                for (int d1 = 1; d1 < N; d1++){
                    for (int d2 = 1; d2 < N; d2++){
                        if (x + d1 + d2 > N) continue;
                        if (y + d2 > N || y - d1 < 0) continue;
                        list.add(new Node(x, y, d1, d2));
                    }
                }
            }
        }
    }

    public static void divide(int x, int y, int d1, int d2){
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;

        for (int r = 0; r < x + d1 - 1; r++){
            for (int c = 0; c < y; c++){
                sum1 += map[r][c];
            }
        }

        for (int r = 0; r < x + d2 - 1; r++){
            for (int c = y; c < N; c++){
                sum2 += map[r][c];
            }
        }

        for (int r = x + d1 - 1; r < N; r++){
            for (int c = 1; c < y - d1 + d2 - 1; c++){
                sum3 += map[r][c];
            }
        }

        for (int r = x + d2 - 1; r < N; r++){
            for (int c = y-d1+d2 - 1; c < N; c++){
                sum4 += map[r][c];
            }
        }

        int sum5 = sum - (sum1 + sum2 + sum3 + sum4);
        System.out.print(sum1 + " ");
        System.out.print(sum2 + " ");
        System.out.print(sum3 + " ");
        System.out.print(sum4 + " ");
        System.out.println(sum5 + " ");
    }

    public static class Node{
        int x;
        int y;
        int d1;
        int d2;

        public Node(int x, int y, int d1, int d2){
            this.x = x;
            this.y = y;
            this.d1 = d1;
            this.d2 = d2;
        }
    }
}
