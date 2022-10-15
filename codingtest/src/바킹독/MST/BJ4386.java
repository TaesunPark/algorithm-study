package 바킹독.MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ4386 {
    public static int p[];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<CNode> connectList = new ArrayList<>();
        double result = 0;
        int n = sc.nextInt();
        p = new int[n + 1];

        for(int i = 0; i < n; i++){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            list.add(new Node(x, y));
        }

        for(int i = 0; i < n-1; i++){
            for(int j = i + 1; j < n; j++){
                connectList.add(new CNode(i, j, dis(list.get(i), list.get(j))));
            }
        }

        for(int i = 0; i <= n; i++){
            p[i] = i;
        }

        Collections.sort(connectList);

        for(int i = 0; i < connectList.size(); i++){
            CNode node = connectList.get(i);
            int start = find(node.st);
            int end = find(node.en);

            if(start == end) continue;
            p[end] = start;
            result += node.cnt;
        }

        String re1 = Double.toString(result);
        int idx = re1.indexOf('.');
        String re2 = re1.substring(0, idx + 1) + re1.substring(idx+1, idx+3);
        System.out.println(re2);
    }

    public static int find(int child){
        if(p[child] == child) return child;
        else{
            return p[child] = find(p[child]);
        }
    }

    public static double dis(Node a, Node b){
        return Math.sqrt((b.y - a.y) * (b.y - a.y) + (b.x - a.x) * (b.x - a.x));
    }

    public static class Node{
        double x;
        double y;

        public Node(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    public static class CNode implements Comparable<CNode>{
        int st;
        int en;
        double cnt;

        public CNode(int st, int en, double cnt){
            this.st = st;
            this.en = en;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(CNode node){
            if(this.cnt - node.cnt > 0) return 1;
            else if(this.cnt == node.cnt){
                return 0;
            } else{
                return -1;
            }
        }

    }
}
