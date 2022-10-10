package 바킹독.위상정렬;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2252 {

    public static Queue<Integer> queue;
    public static int[] checkIndex;
    public static ArrayList<Integer> resultList;
    public static ArrayList<ArrayList<Integer>> list;
    public static int n;
    public static int m;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        list = new ArrayList<>();
        resultList = new ArrayList<>();
        checkIndex = new int[n+1];
        queue = new LinkedList<>();

        for(int i=0; i<=n; i++){
            list.add(i, new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            checkIndex[v2] = checkIndex[v2] + 1;
            list.get(v1).add(v2);
        }

        for(int i=1; i<=n; i++){
            if(checkIndex[i] == 0){
                queue.add(i);
                resultList.add(i);
            }
        }

        while(!queue.isEmpty()){
           int idx = queue.poll();

           for(int x : list.get(idx)){
                checkIndex[x] = checkIndex[x] - 1;
                if(checkIndex[x] == 0){
                    queue.add(x);
                    resultList.add(x);
                }
           }
        }

        for(int i=0; i<resultList.size(); i++){
            System.out.print(resultList.get(i) + " ");
        }

    }
}
