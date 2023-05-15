package 바킹독;

import java.io.IOException;
import java.util.Scanner;

public class 퇴사_2 {
    public static void main(String[] args) throws IOException {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Node[] list = new Node[N + 2];

        for (int i = 1; i <= N; i++){
            int t = sc.nextInt();
            int p = sc.nextInt();
            list[i] = new Node(t, p);
        }
        list[N+1] = new Node(0,0);

        int[] result = new int[N + 2];
        int max = 0;

        // N + 1일 째 되는 날 퇴사
        for (int i = 1; i <= N + 1; i++){
            Node node = list[i];
            max = Math.max(max, result[i]);
            // 받았을 때 일짜 넘어가면 continue
            if (node.t + i <= N + 1){
                result[node.t + i] = Math.max(node.p + max, result[node.t + i]);
            }
        }

        System.out.print(max);

    }
    public static class Node{
        int t; // 기간
        int p; // 금액
        public Node(int t, int p){
            this.t = t;
            this.p = p;
        }
    }
}
