package 바킹독.MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 최소_스패닝_트리 {
    static int V, E;
    static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Node> list;
        V = sc.nextInt();
        E = sc.nextInt();
        d = new int[V + 1];
        list = new ArrayList<>();

        // 처음에는 다 자기가 부모임
        for (int i = 0; i <= V; i++){
            d[i] = i;
        }

        // 정점에 다 넣고

        for (int i = 0; i < E; i++){
            int st = sc.nextInt();
            int en = sc.nextInt();
            int cnt = sc.nextInt();

            list.add(new Node(st, en , cnt));
        }

        Collections.sort(list, (o1, o2) -> {
            return o1.w - o2.w;
        });
        int result = 0;

        for (int i = 0; i < V; i++){
            int st = find(list.get(i).st);
            int en = find(list.get(i).en);
            if (st == en) continue;

            if (st < en){
                d[en] = st;
            } else{
                d[st] = en;
            }

            result += list.get(i).w;
        }

        System.out.print(result);

    }
    public static int find(int st){
        if (d[st] == st) return st;
        return d[st] = find(d[st]);
    }

    public static class Node{
        int st;
        int en;
        int w;

        public Node(int st, int en, int w){
            this.st = st;
            this.en = en;
            this.w = w;
        }
    }
}
