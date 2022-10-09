package 바킹독.그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ11403 {
    public static int[][] map;
    public static int[][] result;
    public static boolean[] check;
    public static Queue<Integer> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        map = new int[n][n];
        result = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            bfs(i, n);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static void bfs(int idx, int n){
        queue = new LinkedList<>();
        queue.add(idx);
        check = new boolean[n];

        while(!queue.isEmpty()){
            int index = queue.poll();

            for(int i = 0; i < n; i++){
                if(check[i] == true || map[index][i] == 0) continue;
                queue.add(i);
                check[i] = true;
                result[idx][i] = 1;
            }
        }

    }

}
