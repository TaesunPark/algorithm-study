package 바킹독.MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ13418 {
    static int N;
    static int M;

    public static class Node{
        int st;
        int en;
        int dis;
        public Node(int st, int en, int dis){
            this.st = st;
            this.en = en;
            this.dis = dis;
        }
    }

    public static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        d = new int[N + 1];
        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i <= N; i++){
            d[i] = i;
        }

        for (int i = 0; i <= M; i++){
            int st = sc.nextInt();
            int en = sc.nextInt();
            int dis = sc.nextInt();
            list.add(new Node(st, en, dis));
        }

        Collections.sort(list, (o1, o2) ->{
            return o2.dis - o1.dis;
        });

        int cost1 = 0;

        for (int i = 0; i < list.size(); i++){
            int st = find(list.get(i).st);
            int en = find(list.get(i).en);
            if (st == en) continue;

            if (st < en){
                d[en] = st;
            } else{
                d[st] = en;
            }

            if (list.get(i).dis == 0){
                cost1++;
            }
        }

        for (int i = 0; i <= N; i++){
            d[i] = i;
        }

        Collections.sort(list, (o1, o2) ->{
            return o1.dis - o2.dis;
        });

        int cost2 = 0;

        for (int i = 0; i < list.size(); i++){
            int st = find(list.get(i).st);
            int en = find(list.get(i).en);
            if (st == en) continue;

            if (st < en){
                d[en] = st;
            } else{
                d[st] = en;
            }

            if (list.get(i).dis == 0){
                cost2++;
            }
        }

        System.out.print((cost2 * cost2) - (cost1 * cost1));

    }

    public static int find(int st){
        if (d[st] == st) return st;
        return d[st] = find(d[st]);
    }
}
