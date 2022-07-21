package 바킹독.연습문제0x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ11003 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] result = new int[size];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i=0; i<size; i++){
            result[i] = Integer.parseInt(st.nextToken());

            if (!deque.isEmpty() &&  deque.getFirst() <= i - range){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && result[deque.getLast()] > result[i]){
                deque.removeLast();
            }
            deque.offer(i);
            sb.append(result[deque.getFirst()]).append(" ");
        }

        System.out.print(sb);
    }
}
