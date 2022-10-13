package 바킹독.MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ1647 {

    public static ArrayList<Node> list;
    public static int[] p;

    public static void main(String[] args){
        int result = 0;
        list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        p = new int[n + 1];

        for(int i = 0; i <= n; i++){
            p[i] = i;
        }

        for(int i = 0; i < m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();;
            int w = sc.nextInt();;

            list.add(new Node(v1, v2, w));
        }

        Collections.sort(list, (o1, o2) -> o1.w - o2.w);
        int cur = 0;
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
            cur = i;
        }
        result -= list.get(cur).w;
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
