package 바킹독.시뮬레이션;

import java.util.Scanner;

public class BJ14891 {

    public static int[][] tob;
    public static int[] dir;
    public static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tob = new int[4][8];
        dir = new int[4];

        for (int i = 0; i < 4; i++){
            String str = sc.next();
            for (int j = 0; j < 8; j++){
                tob[i][j] = str.charAt(j) - '0';
            }
        }

        k = sc.nextInt();

        while (k-- > 0) {
            int t_num = sc.nextInt();
            int rot = sc.nextInt();
            dir = new int[4];
            dir[t_num - 1] = rot;
            checkRot(t_num, rot);
            rotate();
        }

        int cnt = 1;
        int result = 0;

        for (int i = 0; i < 4; i++){
            if (tob[i][0] == 1){
                result += cnt;
            }
            cnt *= 2;
        }

        System.out.print(result);
    }

    public static void checkRot(int t_num, int rot){
        // 오른쪽 체크
        for (int i = t_num - 1; i < 3; i++){
            if (tob[i][2] == tob[i + 1][6]) break;
            dir[i + 1] = dir[i] * (-1);
        }

        // 왼쪽 체크
        for (int i = t_num - 1; i >= 1; i--){
            if (tob[i][6] == tob[i - 1][2]) break;
            dir[i - 1] = dir[i] * (-1);
        }
    }

    public static void rotate(){
        int tmp;

        for (int i = 0; i < 4; i++){
            if (dir[i] == -1){
                tmp = tob[i][0];
                for (int j = 1; j <= 7; j++){
                    tob[i][j - 1] = tob[i][j];
                }
                tob[i][7] = tmp;
            }

            if (dir[i] == 1){
                tmp = tob[i][7];
                for (int j = 7; j >= 1; j--){
                    tob[i][j] = tob[i][j - 1];
                }
                tob[i][0] = tmp;
            }
        }
    }
}
