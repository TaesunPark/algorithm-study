package 바킹독.트리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1241 {

    public static ArrayList<ArrayList<Node>> list;
    public static boolean[] check;
    public static int n;
    public static int m;
    public static int tmpResult;
    public static int result;
    public static int mV2;
    public static StringBuilder sb;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        n = sc.nextInt();
        m = sc.nextInt();
        sb = new StringBuilder();

        for(int i=0; i<=n; i++){
            list.add(i, new ArrayList<Node>());
        }

        for(int i=1; i<=n-1; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cnt = sc.nextInt();
            list.get(v1).add(new Node(v2, cnt));
            list.get(v2).add(new Node(v1, cnt));
        }

        for(int i=0; i<m; i++){
            int v1 = sc.nextInt();
            mV2 = sc.nextInt();
            check = new boolean[n + 1];
            tmpResult = 0;
            result = 0;
            bfs(v1, mV2);
            sb.append(result);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs(int v1, int v2){
        Queue<Node> queue = new LinkedList<Node>();
        check[v1] = true;
        queue.add(new Node(v1, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int idx = node.idx;
            int w = node.w;

            if(idx == v2){
                result = w;
                break;
            }

            for(Node tmp : list.get(idx)){
                int idx2 = tmp.idx;
                int cnt2 = tmp.w;

                if(check[idx2] == true) continue;
                queue.add(new Node(idx2, cnt2 + w));
                check[idx2] = true;
            }

        }

    }


    public static class Node{
        int idx;
        int w;

        public Node(int idx, int w){
            this.idx = idx;
            this.w = w;
        }
    }

}
