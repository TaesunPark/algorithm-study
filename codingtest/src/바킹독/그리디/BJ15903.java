package 바킹독.그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ15903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            pq.add(sc.nextLong());
        }

        while(m > 0){
            m--;
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a + b);
            pq.add(a + b);
        }

        long result = 0;

        while (!pq.isEmpty()){
            result += pq.poll();
        }

        System.out.print(result);
    }


}
