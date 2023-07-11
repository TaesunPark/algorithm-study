package swexpert;

import java.util.ArrayList;
import java.util.Scanner;

public class 숫자_배열_회전 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t_case = 1; t_case <= T; t_case++){
            int N = sc.nextInt();
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            StringBuilder sb = new StringBuilder();
            ArrayList<StringBuilder> list = new ArrayList<>();
            for (int i = 0; i < N; i++){
                list.add(new StringBuilder());
            }

            for (int i = 0; i < 3; i++){
                map = rotate(map, N);
                for (int k = 0; k < N; k++) {
                    for (int j = 0; j < N; j++) {
                        list.get(k).append(map[k][j]);
                    }
                    list.get(k).append(" ");
                }
            }

            System.out.println("#" + t_case);
            for (int i = 0; i < N; i++){
                System.out.println(list.get(i));
            }
        }
    }

    public static int[][] rotate(int[][] map, int N){
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                tmp[i][j] = map[N - 1 - j][i];
            }
        }
        return tmp;
    }
}
