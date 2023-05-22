import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ1715 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] list = new long[N];

        for (int i = 0; i < N; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        if (N == 1){
            System.out.print(list[0]);
            return;
        } else if(N == 2){
            System.out.print(list[0] + list[1]);
            return;
        }

        long value = 0;
        queue.add(new Node(list[0] + list[1]));
        value = list[0] + list[1];
        long init = value;

        for (int i = 2; i < N; i++){
            queue.add(new Node(list[i]));
        }

        long sum = init;

        while (!queue.isEmpty()){
            long val = queue.poll().value;
            if (queue.isEmpty()) break;
            sum += val + queue.peek().value;
            queue.add(new Node(val + queue.poll().value));
        }

        System.out.print(sum);
    }

    public static class Node implements Comparable<Node>{
        long value;

        public Node(long value){
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.value, o.value);
        }
    }

}
