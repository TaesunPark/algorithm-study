package 바킹독.시뮬레이션;

import java.util.Scanner;

public class BJ14888 {
    public static int cnt;
    public static int[] list;
    public static int[] operateList;
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cnt = sc.nextInt();
        list = new int[cnt];
        operateList = new int[4];

        for (int i = 0; i < cnt; i++){
            list[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++){
            operateList[i] = sc.nextInt();
        }

        dfs(0,list[0]);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int depth, int num){
        if(depth == cnt - 1){
            MAX = Math.max(num, MAX);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++){
            if (operateList[i] == 0) continue;
            operateList[i]--;
            switch (i){
                case 0:
                    dfs(depth + 1, num + list[depth + 1]);
                    break;
                case 1:
                    dfs(depth + 1, num - list[depth + 1]);
                    break;
                case 2:
                    dfs(depth + 1, num * list[depth + 1]);
                    break;
                case 3:
                    dfs(depth + 1, num / list[depth + 1]);
                    break;
            }
            operateList[i]++;
        }

    }
}
