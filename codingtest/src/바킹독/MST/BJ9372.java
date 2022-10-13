package 바킹독.MST;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ9372 {

    public static int T;
    public static int N;
    public static int M;
    public static int result;
    public static ArrayList<Node> list;
    public static int[] p;
    public static StringBuilder sb;

    public static void main(String[] args){
        sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int i=0; i<T; i++){
            N = sc.nextInt();
            M = sc.nextInt();
            result = 0;
            p = new int[N + 1];
            list = new ArrayList<>();

            for(int j = 1; j<=N; j++){
                p[j] = j;
            }

            for(int j = 0; j < M; j++){
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                list.add(new Node(v1, v2));
            }

            for(int j = 0; j < M; j++){
                int start = find(list.get(j).start);
                int end = find(list.get(j).end);
                if(start == end) continue;

                result += 1;
                p[end] = start;
            }
            System.out.println(result);
        }
    }

    public static int find(int child){
        if(p[child] == child){
            return child;
        } else{
            return p[child] = find(p[child]);
        }
    }

    public static class Node{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

}
