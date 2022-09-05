package 바킹독.연습문제0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1931 {
    public static void main(String[] args) throws IOException {
        ArrayList<Node> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }
        // 끝 값으로 정렬
        Collections.sort(list);
        int cnt=0;
        int time = 0;

        for (int i=0; i<n; i++){
            if (time > list.get(i).start) continue;
            time = list.get(i).end;
            cnt++;
        }
        System.out.print(cnt);
    }
    static class Node implements Comparable<Node>{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (o.end != this.end){
                return this.end - o.end;
            } else{
                return this.start - o.start;
            }
        }
    }
}
