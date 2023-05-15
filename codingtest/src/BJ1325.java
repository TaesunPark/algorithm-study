import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1325 {
    static int N;
    static int V;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        N = sc.nextInt();
        V = sc.nextInt();

        for (int i = 0; i <= N; i++){
            list.add(i, new ArrayList<>());
        }

        for (int i = 0; i < V; i++){
            int st = sc.nextInt();
            int en = sc.nextInt();

            list.get(en).add(st);
        }

        boolean[] visited = new boolean[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int max = 0;
        ArrayList<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()){
            int now_idx = queue.poll();
            int cnt = 0;

            for (int idx : list.get(now_idx)){
                if (visited[idx] == true) continue;
                queue.add(idx);
                visited[idx] = true;
                cnt++;
            }

            if (max == cnt){
                result.add(now_idx);
            }

            if (max < cnt){
                result.clear();
                result.add(now_idx);
                max = cnt;
            }
        }

        result.sort((o1,o2)->{
            return o1-o2;
        });

        for (int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }
}
