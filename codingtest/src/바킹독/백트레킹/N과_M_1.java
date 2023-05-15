package 바킹독.백트레킹;

import java.util.ArrayList;
import java.util.Scanner;

public class N과_M_1 {
    static int N, M;
    static boolean[] check;
    static ArrayList<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        check = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        dfs(0, sb);
        System.out.print(sb);
    }

    public static void dfs(int n, StringBuilder sb){

        if (n == M){
            for (int i = 0; i < list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++){
            if (check[i] == true) continue;
            list.add(i);
            check[i] = true;
            dfs(n + 1, sb);
            list.remove(list.size() - 1);
            check[i] = false;
        }
    }
}
