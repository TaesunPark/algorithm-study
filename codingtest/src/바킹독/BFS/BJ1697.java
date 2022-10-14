package 바킹독.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1697 {

    public static Queue<Node> queue;
    public static boolean[] check;
    public static int result;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        check = new boolean[100001];

        queue = new LinkedList<>();

        queue.add(new Node(0, n));
        check[n] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cnt = node.cnt;
            int value = node.value;

            if(value == m){
                System.out.println(cnt);
                return;
            }

            if(value * 2 < 100001 && check[value * 2] == false){
                check[value * 2] = true;
                queue.add(new Node(cnt + 1, value * 2));
            }

            if(value + 1 < 100001 && check[value + 1] == false){
                check[value + 1] = true;
                queue.add(new Node(cnt + 1, value + 1));
            }

            if(value - 1 >= 0 && check[value - 1] == false){
                check[value - 1] = true;
                queue.add(new Node(cnt + 1, value - 1));
            }

        }

        // -1, +1, *2
    }

    public static class Node{
        int cnt;
        int value;

        public Node(int cnt, int value){
            this.cnt = cnt;
            this.value = value;
        }

    }


}
