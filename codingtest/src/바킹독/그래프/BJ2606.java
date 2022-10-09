package 바킹독.그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2606 {
    public static Queue<Integer> queue;
    public static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<=n; i++){
            list.add(i, new ArrayList<>());
        }

        for(int i=1; i<=m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        System.out.println(bfs(1, n));
    }

    public static int bfs(int st, int n){
        int cnt = 0;
        boolean[] check = new boolean[n + 1];
        queue = new LinkedList<>();
        queue.add(st);
        check[st] = true;

        while(!queue.isEmpty()){
            int idx = queue.poll();

            for(int x : list.get(idx)){
                if(check[x] == true) continue;
                queue.add(x);
                check[x] = true;
                cnt = cnt + 1;
            }

        }
        return cnt;
    }

}
