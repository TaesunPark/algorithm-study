package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ22862 {
    static int[] list;
    static int[] rList;
    static int N;
    static int M;
    static ArrayList<Integer> arrayList;
    static boolean[] check;
    static int cnt;
    static int cnt1;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new int[N];
        check = new boolean[10001];
        cnt = 0;
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        cnt1 = 0;
        for (int i=0; i<N; i++){
            int value = Integer.parseInt(st.nextToken());
            if (check[value] == true){
                cnt++;
                continue;
            }
            check[value] = true;
            list[cnt1] = value;
            cnt1++;
        }
        rList = new int[N-cnt];
        check = new boolean[10001];
        for (int i=0; i<cnt1; i++){
            rList[i] = list[i];
        }

        Arrays.sort(rList);

        arrayList = new ArrayList<>();
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth){
        if (depth == M){
            for (int i=0; i<M; i++){
                sb.append(arrayList.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<cnt1;i++){
            arrayList.add(rList[i]);
            dfs(arrayList.size());
            arrayList.remove(arrayList.size()-1);
        }

    }


}
