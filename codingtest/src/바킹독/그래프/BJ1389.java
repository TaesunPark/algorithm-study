package 바킹독.그래프;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1389 {
    public static ArrayList<ArrayList<Integer>> list;
    public static int n;
    public static int m;
    public static int num;
    public static int cnt = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        for(int i = 1; i<=n; i++){
            int num1 = bfs(i);
            
            if(cnt > num1){
                cnt = num1;
                num = i;
            }
        }

        System.out.println(num);

    }

    public static int bfs(int st){
        int count = 0;
        int mul = 0;
        boolean[] check = new boolean[n + 1];
        check[st] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, st));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int cnt1 = node.cnt;
            int cur = node.cur;
            mul += cnt1;
            for(int temp : list.get(cur)){
                if(check[temp] == true) continue;
                count++;
                queue.add(new Node(cnt1 + 1, temp));
                check[temp] = true;
            }

        }

        return mul;
    }

    public static class Node{
        int cnt;
        int cur;
        public Node(int cnt, int cur){
            this.cnt = cnt;
            this.cur = cur;
        }
    }

}
