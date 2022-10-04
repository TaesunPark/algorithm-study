package 바킹독.연습문제0x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ3078 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputValues = new int[2];
        Deque<Integer> deque = new ArrayDeque<>();
        long[] list = new long[21];
        long ret =0;
        int loopK = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loopCnt = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=K; i++){
            String name = br.readLine();
            int len = name.length();
            deque.addLast(len);
            list[len]++;
        }

        for (int i=K+1; i<=loopCnt; i++){
            int lenTop = deque.pop();
            list[lenTop]--;
            String name = br.readLine();
            int length = name.length();
            deque.addLast(length);
            list[length]++;
            ret += list[lenTop];
        }

        while (deque.size() >= 2){
            int len = deque.pop();
            list[len]--;
            ret += list[len];
        }
        System.out.print(ret+"\n");
    }
}