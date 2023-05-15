package 바킹독;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static ArrayList<Node> list;
    public static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        list = new ArrayList<>();

        p = new int[V + 1];


        for (int i = 0; i < E; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Node(v1,v2,w));
        }

        for (int i = 1; i <= V; i++){
            p[i] = i;
        }

        list.sort((o1,o2)->{
            return o1.val-o2.val;
        });
        int result = 0;
        for (int i = 0; i < E; i++){
            int start = find(list.get(i).st);
            int end = find(list.get(i).en);
            if (start == end){
                continue;
            }
            p[end] = start;
            result += list.get(i).val;
        }

    }

    public static int find(int st){
        if (p[st] == st) return st;
        else{
            return p[st] = find(p[st]);
        }
    }

    public static class Node{
        int st;
        int en;
        int val;

        public Node(int st, int en, int val){
            this.st = st;
            this.en = en;
            this.val = val;
        }
    }

    public int pop(){
        return 1;
    }

}
