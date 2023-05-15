package 바킹독.백트레킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 로또 {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        while (true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] list = new int[n];
            ArrayList<Integer> result = new ArrayList<>();
            boolean[] check = new boolean[n];
            int idx = 0;
            while (st.hasMoreTokens()){
                list[idx++] = Integer.parseInt(st.nextToken());
            }
            // st, 끝, list,

            dfs(0, result, list, check, 0);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int st, ArrayList<Integer> result, int[] list, boolean[] check, int depth){
        if (depth == 6){
            for (int i = 0; i < result.size(); i++){
                sb.append(result.get(i) + " ");
            }
            sb.append("\n");
        }

        for (int i = st; i < list.length; i++){
            if (check[i] == true) continue;
            check[i] = true;
            result.add(list[i]);
            dfs(i, result, list, check, depth + 1);
            check[i] = false;
            result.remove(result.size() - 1);
        }

    }
}
