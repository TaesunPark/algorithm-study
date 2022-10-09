package 바킹독.그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ11724 {

    public static ArrayList<ArrayList<Integer>> list;
    public static Queue<Integer> queue;
    public static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;
        check = new boolean[n+1];
        list = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            list.add(i, new ArrayList<>());
        }

        for (int i=0; i<m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        for(int i=1; i<=n; i++){
            if(check[i] == true) continue;
            bfs(i);
            result = result + 1;
        }
        System.out.print(result);
    }
    public static void bfs(int i){
        queue = new LinkedList<>();
        queue.add(i);
        check[i] = true;

        while(!queue.isEmpty()){
            int idx = queue.poll();

            for(int x : list.get(idx)){
                if(check[x] == true) continue;
                check[x] = true;
                queue.add(x);
            }
        }
    }
}
