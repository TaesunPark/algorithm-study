package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697 {

    public static int K;
    public static int N;
    public static int[] array = new int[100001];
    public static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        if (K == N){
            System.out.print("0");
            return;
        }
        queue.add(K);
        array[K] = 1;

        while (!queue.isEmpty()){
            int tmp = queue.poll();

            for (int i=0; i<3; i++){
                int value;

                if (i==0){
                    value = tmp + 1;
                } else if(i==1){
                    value = tmp -1;
                } else{
                    value = tmp *2;
                }
                if (value == N){
                    System.out.println(array[tmp]);
                    return;
                }
                if (value >= 0 && value < 100001 && array[value] == 0){
                    queue.add(value);
                    array[value] = array[tmp] + 1;
                }
            }

        }
        System.out.print(array[N]);
    }

}
