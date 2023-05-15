package 삼성기출;

import java.util.Scanner;

public class 경사로 {
    static int N, L;
    static int[][] map;
    static int[][] copiedMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();

        map = new int[N][N];
        copiedMap = new int[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        copyMap();

        int result = 0;

        for (int i = 0; i < N; i++){
            result += checkMap(i);
        }

        rotate();

        for (int i = 0; i < N; i++){
            result += checkMap(i);
        }

        System.out.print(result);

    }

    public static int checkMap(int h) {
        int[] height = new int[N];
        boolean[] check = new boolean[N];

        for (int i = 0; i < N; i++){
            height[i] = map[h][i];
        }

        for (int i = 0; i < N -1; i++){

            if (height[i] == height[i+1]) continue;

            if (Math.abs(height[i] - height[i+1]) > 1){
                return 0;
            }

            if (height[i] - 1 == height[i + 1]){
                for (int j = i + 1; j <= i+L; j++){
                    if (j >= N || height[i + 1] != height[j] || check[j]) return 0;
                    check[j] = true;
                }
            } else if (height[i] + 1 == height[i+1]){
                for (int j = i; j > i-L; j--){
                    if (j < 0 || height[i] != height[j] || check[j])
                        return 0;
                    check[j] = true;
                }
            }
        }

        return 1;
    }

    public static void printMap(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }

    public static void copyMap(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                copiedMap[i][j] = map[i][j];
            }
        }
    }

    public static void rotate(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                map[i][j] = copiedMap[N-j-1][i];
            }
        }
    }


}
