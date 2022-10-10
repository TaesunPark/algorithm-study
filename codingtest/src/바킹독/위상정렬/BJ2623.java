package 바킹독.위상정렬;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2623 {
    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Integer>> list;
    public static Queue<Integer> queue;
    public static ArrayList<Integer> result;
    public static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        check = new int[n+1];
        queue = new LinkedList<>();
        list = new ArrayList<>();
        result = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(i, new ArrayList<Integer>());
        }

        for(int i = 1; i <= m; i++){
            int k = sc.nextInt();
            Queue<Integer> tmpQueue = new LinkedList<>();

            for(int j = 0; j < k; j++){
                int tmp = sc.nextInt();
                tmpQueue.add(tmp);
            }

            while(tmpQueue.size() != 1) {
                int v1 = tmpQueue.poll();
                int v2 = tmpQueue.peek();
                list.get(v1).add(v2);
                check[v2] = check[v2] + 1;
            }
        }

        for(int i=1; i<=n; i++){
            if(check[i] == 0){
                queue.add(i);
                result.add(i);
            }
        }

        while(!queue.isEmpty()){
            int idx = queue.poll();

            for(int x : list.get(idx)){
                check[x] = check[x] - 1;

                if(check[x] == 0){
                    queue.add(x);
                    result.add(x);
                }
            }
        }
        if(result.size() != n){
            System.out.println(0);
            return;
        }
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
