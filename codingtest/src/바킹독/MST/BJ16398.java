package 바킹독.MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ16398 {
    public static int[] p;
    public static int[][] map;
    public static ArrayList<Node> list;
    public static int n;

    public static void main(String[] args){
        int result = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];
        list = new ArrayList<>();
        p = new int[n];

        for(int i = 0; i < n; i++){
            p[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int value = sc.nextInt();
                if(i == j) continue;
                list.add(new Node(i, j, value));
            }
        }

        Collections.sort(list, (o1, o2) -> o1.w - o2.w);

        for(int i = 0; i < list.size(); i++){
            int start = find(list.get(i).start);
            int end = find(list.get(i).end);

            if(start == end) continue;

            if(start > end){
                p[start] = end;
            } else{
                p[end] = start;
            }
            result += list.get(i).w;
        }
        System.out.println(result);
    }

    public static int find(int child){
        if(p[child] == child) return child;
        else{
            return p[child] = find(p[child]);
        }
    }

    public static class Node{
        int start;
        int end;
        int w;

        public Node(int start, int end, int w){
            this.start = start;
            this.end = end;
            this.w = w;
        }
    }


}
