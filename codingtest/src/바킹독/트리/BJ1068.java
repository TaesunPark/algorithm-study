package 바킹독.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1068 {
    static int n;
    static int[] list;
    static ArrayList<Integer>[] tree;
    static boolean[] check;
    static int removeNum;
    static int root;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check = new boolean[n];
        tree = new ArrayList[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[n];
        for (int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
            if (list[i] == -1){
                root = i;
            } else{
                tree[list[i]].add(i);
            }
        }
        removeNum = Integer.parseInt(br.readLine());

        dfs(removeNum);
        countDfs(root);
        if (root != removeNum && result == 0){
            System.out.println(1);
        } else{
            System.out.println(result);
        }
    }

    public static void countDfs(int r){
        if (check[r] == true) return;
        if (tree[r].size() == 0){
            result++;
        }

        for (int leaf : tree[r]){
            countDfs(leaf);
        }
    }

    public static void dfs(Integer num){
        check[num] = true;
        if (list[num] == -1) return;
        tree[list[num]].remove(num);

        for (Integer leaf : tree[num]){
            dfs(leaf);
        }
    }
}
