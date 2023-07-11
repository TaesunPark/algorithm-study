package swexpert;

import java.util.Scanner;

public class 두_개의_숫자열 {
    public static void main(String[] args) {
        int T;
        int N, M;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int t_case = 1; t_case <= T; t_case++){
            int result = 0;
            N = sc.nextInt();
            M = sc.nextInt();

            int[] a_list = new int[N];
            int[] b_list = new int[M];

            for (int i = 0; i < N; i++){
                a_list[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++){
                b_list[i] = sc.nextInt();
            }

            if (N <= M){
                result = sum(a_list, b_list);
            }

            if(N > M){
                result = sum(b_list, a_list);
            }
            System.out.println("#"+t_case + " " + result);
        }
    }
    public static int sum(int[] a, int[] b){
        // a가 b보다 작다고 가정
        int max = 0;

        for (int i = 0; i <= b.length - a.length; i++){
            int sum2 = 0;
            for (int j = 0; j < a.length; j++){
                sum2 += a[j] * b[i + j];
            }
            max = Math.max(sum2, max);
        }
        return max;
    }
}
