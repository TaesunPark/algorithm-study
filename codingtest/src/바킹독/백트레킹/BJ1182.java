package 바킹독.백트레킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ1182 {
    public static int n;
    public static int m;
    public static int[] list;
    public static ArrayList<Integer> tmpList;
    public static int result;
    public static boolean[] check;

    public static void main(String[] args){
        result = 0;
        Scanner sc = new Scanner(System.in);
        tmpList = new ArrayList<>();

        n = sc.nextInt();
        m = sc.nextInt();
        list = new int[n];

        for(int i = 0; i < n; i++){
            list[i] = sc.nextInt();
        }

        for(int i = 1; i<=n; i++){
            check = new boolean[n];
            dfs(i, 0, m);
        }
        System.out.println(result);
    }

    public static void dfs(int value, int depth, int m){

        if(depth == value){
            int tmp = 0;

            for(int i = 0; i < value; i++){
                tmp += tmpList.get(i);
            }
            if(tmp == m){
                for(int i = 0; i < value; i++){
                    System.out.print(tmpList.get(i));
                }
                System.out.println();
                result++;
            }
        }

        for(int i = 0; i < n; i++){
            if(check[i] == true) continue;
            check[i] = true;
            tmpList.add(list[i]);
            dfs(value, tmpList.size(), m);
            tmpList.remove(tmpList.size() - 1);
        }


    }



}
