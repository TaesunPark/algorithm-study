package 바킹독.시뮬레이션;

import java.util.Scanner;

public class MyBJ18808 {
    public static int N; // 노트북의 세로 길이
    public static int M; // 노트북의 가로 길이
    public static int K; // 스티커 정보 수
    public static int sm,sn;
    public static int[][] note; // 노트북
    public static int[][] sticker; // 스티커

    public static void main(String[] args) {
        note = new int[42][42];
        sticker = new int[12][12];
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        while(K-- > 0){
            sn = sc.nextInt();
            sm = sc.nextInt();

            for (int i = 0; i < sn; i++){
                for (int j = 0; j < sm; j++){
                    sticker[i][j] = sc.nextInt();
                }
            }

            for (int rot = 0; rot < 4; rot++){

                boolean is_paste = false;

                for (int y = 0; y <= N - sn; y++){
                    if (is_paste == true) break;
                    for(int x = 0; x <= M - sm; x++){
                        if (pastable(x, y) == true){
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

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                cnt += note[i][j];
            }
        }
        System.out.print(cnt);
    }

    public static void rotate(){
        int[][] tmpSticker = new int[12][12];

        for (int i = 0; i < sn; i++){
            for (int j = 0; j < sm; j++){
                tmpSticker[i][j] = sticker[i][j];
            }
        }

        for (int i = 0; i < sm; i++){
            for (int j = 0; j < sn; j++){
                sticker[i][j] = tmpSticker[sn-1-j][i];
            }
        }
        int tmp = sn;
        sn = sm;
        sm = tmp;
    }

    public static boolean pastable(int x, int y){

        for (int i = 0; i < sn; i++){
            for (int j = 0; j < sm; j++){
                if (note[y + i][x + j] == 1 && sticker[i][j] == 1){
                    return false;
                }
            }
        }

        for (int i = 0; i < sn; i++){
            for (int j = 0; j < sm; j++){
                if (sticker[i][j] == 1){
                    note[y+i][x+j] = 1;
                }
            }
        }

        return true;
    }

}
