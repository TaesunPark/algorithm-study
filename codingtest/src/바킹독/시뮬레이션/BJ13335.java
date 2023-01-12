package 바킹독.시뮬레이션;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ13335 {

    static int n;
    static int w;
    static int L;
    static Queue<Integer> ready;
    static Queue<Integer> road;
    static int t_w;

    static int time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();
        L = sc.nextInt();

        ready = new LinkedList<>();
        road = new LinkedList<>();

        for (int i = 0; i < n; i++){
            ready.add(sc.nextInt());
        }

        for (int i = 0; i < w; i++){
            road.add(0);
        }

        while (!road.isEmpty()){
            time += 1;
            t_w -= road.poll();

            if (!ready.isEmpty()){
                if (t_w + ready.peek() <= L){
                    t_w += ready.peek();
                    road.add(ready.poll());
                } else{
                    road.add(0);
                }
            }
        }

        System.out.print(time);
    }
}
