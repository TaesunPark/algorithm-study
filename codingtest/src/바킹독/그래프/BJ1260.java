package 바킹독.그래프;

import java.util.*;

public class BJ1260 {
    public static Queue<Integer> queue;
    public static ArrayList<ArrayList<Integer>> list;
    public static StringBuilder sb1;
    public static StringBuilder sb2;
    public static boolean[] check1;

    public static void main(String[] args) {
        list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int st = sc.nextInt();
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();
        check1 = new boolean[n+1];

        for(int i = 0; i <= n; i++){
            list.add(i, new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(list.get(i));
        }


        bfs(st, n);
        dfs(st);
        System.out.println(sb1);
        System.out.println(sb2);
    }
    public static void bfs(int idx, int n){
        boolean[] check = new boolean[n+1];
        queue = new LinkedList<>();
        queue.add(idx);
        sb2.append(idx + " ");
        check[idx] = true;

        while(!queue.isEmpty()){
            int idx2 = queue.poll();

            for(int x : list.get(idx2)){
                if(check[x] == true) continue;
                check[x] = true;
                queue.add(x);
                sb2.append(x + " ");
            }
        }
    }

    public static void dfs(int idx){

        check1[idx] = true;
        sb1.append(idx + " ");

        for(int x : list.get(idx)){
            if(check1[x] == true) continue;
            dfs(x);
        }
    }

}
