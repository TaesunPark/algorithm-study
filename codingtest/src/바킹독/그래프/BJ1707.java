package 바킹독.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1707 {
    static int[] visited;
    static ArrayList<Integer>[] list;
    static int T;
    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tk = 0; tk < T; tk++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V + 1];
            visited = new int[V + 1];
            for (int i = 1; i < V + 1; i++){
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            boolean check = false;
            for (int i = 1; i <= V; i++){
//                if (visited[i] == 0) continue;
                if (bfs(i) == false){
                    check = true;
                    System.out.println("NO");
                    break;
                }
            }
            if (check == false) {
                System.out.println("YES");
            }
        }
    }
    public static boolean bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            int pos = queue.poll();

            if (visited[pos] == 0){
                visited[pos] = 1;
            }

            for (int next : list[pos]){

                if (visited[pos] == visited[next]){
                    return false;
                }

                if (visited[next] == 0){
                    queue.add(next);
                }

                if (visited[next] == 0 && visited[pos] == 1){
                    visited[next] = 2;
                } else if(visited[next] == 0 && visited[pos] == 2){
                    visited[next] = 1;
                }

            }

        }
        return true;
    }
}
