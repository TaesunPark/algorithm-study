package 바킹독.그래프;

import java.util.*;

public class BJ2660 {
    public static ArrayList<Integer> result;
    public static ArrayList<ArrayList<Integer>> list;
    public static Queue<Node> queue;
    public static boolean[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;

        list = new ArrayList<>();
        result = new ArrayList<>();

        for(int i=0; i<=n; i++){
            list.add(i, new ArrayList<>());
        }

        while(true){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            if(v1 == -1 && v2 == -1) break;

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        for(int i=1; i<=n; i++){
            check = new boolean[n+1];
            queue = new LinkedList<>();

            for(int x : list.get(i)){
                check[x] = true;
                queue.add(new Node(1, x));
            }

            int value = bfs(i);

            if(value == min){
                result.add(i);
            }

            if(value < min){
                min = value;
                result.clear();
                result.add(i);
            }
        }

        Collections.sort(result);
        System.out.print(min + " ");
        System.out.println(result.size());
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i) + " ");
        }

    }
    public static int bfs(int index){
        int max = 0;
        check[index] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int idx = node.idx;
            int cnt = node.cnt;
            max = Math.max(max, cnt);

            for(int x : list.get(idx)){
                if(check[x] == true) continue;
                check[x] = true;
                queue.add(new Node(cnt + 1, x));
            }
        }

        return max;
    }


    public static class Node{
        int cnt;
        int idx;

        public Node(int cnt, int idx){
            this.cnt = cnt;
            this.idx = idx;
        }
    }

}
