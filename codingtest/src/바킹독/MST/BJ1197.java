package 바킹독.MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ1197 {

    public static int[] p;
    public static int n;
    public static int m;
    public static ArrayList<Node> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList<>();
        int result = 0;

        p = new int[n+1];

        for(int i = 0; i <= n; i++){
            p[i] = i;
        }

        for(int i = 0; i < m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();

            list.add(new Node(v1, v2, w));
        }

        Collections.sort(list, (o1, o2) -> o1.value - o2.value);

        for(int i = 0; i < m; i++){
            int start = find(list.get(i).start);
            int end = find(list.get(i).end);
            if(start == end){
                continue;
            }
            if(start < end){
                p[end] = start;
            } else{
                p[start] = p[end];
            }
            result += list.get(i).value;

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
        int value;

        public Node(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }

    }

}
