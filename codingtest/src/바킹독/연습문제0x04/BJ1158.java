package 바킹독.연습문제0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1158 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        String[] inputValues = br.readLine().split(" ");
        sb.append("<");
        for (int i=1; i<=Integer.parseInt(inputValues[0]); i++){
            queue.add(i);
        }

        while (queue.size() != 1){
            for (int i=0; i<Integer.parseInt(inputValues[1]) - 1;i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }
        System.out.print(sb + queue.poll().toString() + ">");
    }
}
