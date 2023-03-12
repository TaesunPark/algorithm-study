package 바킹독.백트레킹;

import java.util.ArrayList;
import java.util.Scanner;

public class 부분수열의_합 {
    static int n,s;
    static int result;
    static ArrayList<Integer> list;
    static ArrayList<Integer> list2;
    static boolean[] check;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        n = sc.nextInt();
        s = sc.nextInt();
        sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }

        for (int i = 1; i <= n; i++){
            list2.clear();
            check = new boolean[n];
            dfs(0, i, 0);
        }

        System.out.print(result);
    }

    public static void dfs(int depth, int max_depth, int st){
        if (depth == max_depth){
            int sum = 0;
            for (int i = 0; i < list2.size(); i++){
                sum += list2.get(i);
            }
            if (sum == s){
                result++;
            }
            return;
        }

        for (int i = st; i < n; i++){
            if (check[i] == true) continue;
            check[i] = true;
            list2.add(list.get(i));
            st++;
            dfs(depth + 1, max_depth, st);
            list2.remove(list2.size() - 1);
            check[i] = false;
        }

    }
}
