package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ6118 {

    static StringTokenizer st;
    static ArrayList<Integer> arrayList[];
    static Queue<Integer> queue;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();

        arrayList = new ArrayList[M+1];

        for (int i=0; i<=M;i++){
            arrayList[i] = new ArrayList<>();
        }

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arrayList[from].add(to);
            arrayList[to].add(from);
        }
        bfs(1);

    }
    public static void bfs(int start){
        boolean[] ischecked = new boolean[M+1];
        int[] cnt = new int[M+1];
        int max = 0;
        int index=0;
        int maxCount=0;

        queue.add(start);
        ischecked[start] = true;

        while (!queue.isEmpty()){
            int num = queue.poll();

            for (int s : arrayList[num]){
                if (ischecked[s] == false){
                    queue.add(s);
                    ischecked[s] = true;
                    cnt[s] = cnt[num] + 1;
                }
            }
        }

        for (int i=0; i<=M; i++){
            if (max < cnt[i]){
                max = cnt[i];
                index = i;
                maxCount = 1;
            } else if(max == cnt[i]){
                maxCount++;
            }

        }
        System.out.print(index+ " ");
        System.out.print(max+ " ");
        System.out.print(maxCount+ " ");

    }
}
