package 바킹독.그리디;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++){
            pq1.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++){
            pq2.add(sc.nextInt());
        }

        int result = 0;

        while (!pq1.isEmpty()){
            result += (pq1.poll() * pq2.poll());
        }

        System.out.print(result);


    }
}
