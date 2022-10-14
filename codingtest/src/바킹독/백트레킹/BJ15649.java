package 바킹독.백트레킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ15649 {

    public static boolean[] check;
    public static StringBuilder sb;
    public static ArrayList<Integer> list;

    public static void main(String[] args){
        sb = new StringBuilder();
        list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        check = new boolean[9];
        dfs(N, M, 0);
        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(check[i] == true) continue;
            check[i] = true;
            list.add(i);
            dfs(N, M, list.size());
            list.remove(list.size() - 1);
            check[i] = false;
        }

    }

}
