package 바킹독.연습문제0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ16987 {
    static int n;
    static ArrayList<Node> arrayList;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arrayList = new ArrayList<>();
        n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arrayList.add(new Node(w, s));
        }

        dfs(0);
        System.out.print(max);
    }

    public static void dfs(int m){
        if (m == n){
            int cnt = 0;
            for (int i=0; i<n; i++){
                if (arrayList.get(i).s <= 0) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }

        boolean check = false;
        if (arrayList.get(m).s <=0){
            dfs(m+1);
        }
        else {
            for (int i = 0; i < n; i++) {
                if (i == m) continue; // 같은 계란이면
                if (arrayList.get(i).s <= 0) continue; // 꼐란이 깨져있으면
                check = true;
                arrayList.get(i).s -= arrayList.get(m).w;
                arrayList.get(m).s -= arrayList.get(i).w;
                dfs(m + 1);
                arrayList.get(i).s += arrayList.get(m).w;
                arrayList.get(m).s += arrayList.get(i).w;
            }
            if (check == false) dfs(m + 1);
        }
    }

    public static class Node{
        int w;
        int s;

        public Node(int w, int s){
            this.s = s;
            this.w = w;
        }

    }
}
