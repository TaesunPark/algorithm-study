package 바킹독.트리;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ11725 {

    public static int[] parents;
    public static boolean[] check;
    public static ArrayList<ArrayList<Integer>> list;
    public static int n;

    public static void main(String[] args) {
        list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        check = new boolean[n+1];
        parents = new int[n + 1];

        for(int i=0; i<=n; i++){
            list.add(i, new ArrayList<Integer>());
        }

        for(int i=1; i<n; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            list.get(v2).add(v1);
            list.get(v1).add(v2);
        }

        for(int i=1; i<=n; i++){
            if(check[n] == true) continue;
            dfs(i);
        }

        for(int i=2; i<=n; i++){
            System.out.println(parents[i]);
        }
    }

    public static void dfs(int st){
        if(check[st] == true) return;
        check[st] = true;

        for(int x : list.get(st)){
            if(check[x] == true) continue;
            parents[x] = st;
            dfs(x);
        }

    }
}
