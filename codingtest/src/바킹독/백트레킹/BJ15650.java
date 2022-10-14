package 바킹독.백트레킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ15650 {
    static int n;
    static int m;

    static boolean[] check;
    static ArrayList<Integer> list;
    static StringBuilder sb;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        n = sc.nextInt();
        m = sc.nextInt();
        sb = new StringBuilder();
        check = new boolean[n + 1];

        dfs(1, 0);
        System.out.println(sb);

    }
    public static void dfs(int st, int depth){
        if(depth == m){
            for(int i = 0; i < depth; i++){
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = st; i <= n; i++){
            list.add(i);
            dfs(i + 1, depth + 1);
            list.remove(list.size() - 1);

        }


    }
}
