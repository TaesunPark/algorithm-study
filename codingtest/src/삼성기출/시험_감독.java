package 삼성기출;

import java.util.Scanner;

public class 시험_감독 {
    static int N;
    static int B, C;
    static int[] list;
    static long result;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new int[N];

        for (int i = 0; i < N; i++){
            list[i] = sc.nextInt();
        }

        B = sc.nextInt();
        C = sc.nextInt();

        // 총감독
        result += N;

        for (int i = 0; i < list.length; i++){
            list[i] = list[i] - B;
        }

        for (int i = 0; i < list.length; i++){
            if (list[i] > 0){
                int value = list[i] % C > 0 ? 1 : 0;
                result += (list[i] / C) + value;
            }
        }

        System.out.print(result);
    }
}
