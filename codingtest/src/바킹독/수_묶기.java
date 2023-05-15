package 바킹독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 수_묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> posQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            int value = Integer.parseInt(br.readLine());

            if (value > 0){
                posQueue.add(value);
            } else{
                negQueue.add(value);
            }
        }

        int result = 0;

        while (!posQueue.isEmpty()){
            int v1 = posQueue.poll();
            if (!posQueue.isEmpty()){
                int v2 = posQueue.peek();
                if (v1 * v2 > v1){
                    v1 = v1 * posQueue.poll();
                }
            }
            result += v1;
        }

        while (!negQueue.isEmpty()){
            // -2 -1 0
            int v1 = negQueue.poll();

            if (!negQueue.isEmpty()){
                int v2 = negQueue.peek();
                if (v1 * v2 >= 0){
                    v1 = v1 * negQueue.poll();
                }
            }
            result += v1;
        }

        System.out.print(result);

    }
}
