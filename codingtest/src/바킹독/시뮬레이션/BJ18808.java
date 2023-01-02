package 바킹독.시뮬레이션;

import java.util.Scanner;

public class BJ18808 {

    public static int[][] note;
    public static int[][] paper;
    public static int r, c;
    public static int n, m, k;

    public static void main(String[] args) {
        note = new int[42][42];
        paper = new int[12][12];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        while (k-- > 0){
            r = sc.nextInt();
            c = sc.nextInt();
            for (int i = 0; i < r; i++){
                for (int j = 0; j < c; j++){
                    paper[i][j] = sc.nextInt();
                }
            }
            for (int rot = 0; rot < 4; rot++){
                boolean is_paste = false;
                for (int x = 0; x <= n-r; x++){
                    if (is_paste == true) break;
                    for (int y = 0; y <= m-c; y++){
                        if (pastable(x, y)){
                            is_paste = true;
                            break;
                        }
                    }
                }
                if (is_paste == true) break;
                rotate();
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                cnt += note[i][j];
            }
        }
        System.out.print(cnt);
    }

    public static boolean pastable(int x, int y){
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (note[x + i][y + j] == 1 && paper[i][j] == 1){
                    return false;
                }
            }
        }

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (paper[i][j] == 1){
                    note[x + i][y + j] = 1;
                }
            }
        }
        return true;
    }

    public static void rotate(){
        int tmp[][] = new int[12][12];
        int t = 0;

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                tmp[i][j] = paper[i][j];
            }
        }

        for (int i =0; i < c; i++){
            for (int j = 0; j < r; j++){
                paper[i][j] = tmp[r-1-j][i];
            }
        }
        t = r;
        r = c;
        c = t;
    }
}
