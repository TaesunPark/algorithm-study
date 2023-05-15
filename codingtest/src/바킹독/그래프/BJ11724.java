package 바킹독.그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ11724 {

    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) {
        int N, M;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList<>();
        boolean[] check = new boolean[N + 1];

        for (int i = 0; i <=N; i++){
            list.add(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        Queue<Integer> queue = new LinkedList<>();
        int result = 0;

        for (int i = 1; i <= N; i++){
            if (check[i] == true) continue;
            result++;
            queue.add(i);
            check[i] = true;

            while (!queue.isEmpty()){
                int value = queue.poll();

                for (int values : list.get(value)){
                    if (check[values] == true) continue;
                    queue.add(values);
                    check[values] = true;
                }
            }
        }

        System.out.print(result);

    }

}
