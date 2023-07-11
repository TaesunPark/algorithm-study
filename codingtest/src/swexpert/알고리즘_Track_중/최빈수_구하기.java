package swexpert;

import java.util.Scanner;

public class 최빈수_구하기 {
    public static void main(String[] args) {
        int T;
        Scanner sc  = new Scanner(System.in);
        T = sc.nextInt();

        for (int t_case = 1; t_case <= T; t_case++){
            int t_case_num = sc.nextInt();
            int[] score = new int[101];

            for (int i = 0; i < 1000; i++){
                score[sc.nextInt()]++;
            }

            int max = 0;
            int result = 0;
            for (int i = 0; i <=100; i++){

                if (score[i] >= max){
                    max = score[i];
                    result = i;
                }
            }
            System.out.println("#"+t_case_num+" "+result);
        }

    }
}
