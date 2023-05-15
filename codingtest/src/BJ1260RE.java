import java.util.*;

public class BJ1260RE {
    static int N;
    static int M;
    static int V;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        checked = new boolean[N + 1];

        for (int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            int st = sc.nextInt();
            int en = sc.nextInt();

            list.get(st).add(en);
            list.get(en).add(st);
        }

        for (int i = 0; i <= N; i++){
            Collections.sort(list.get(i));
        }

        bfs(V);

    }

    public static void dfs(int idx){
        checked[idx] = true;
        System.out.print(idx + " ");
        for (int x : list.get(idx)){
            if (checked[x] == true) continue;
            dfs(x);
        }
    }

    public static void bfs(int idx){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        boolean[] checked = new boolean[N + 1];
        checked[idx] = true;

        while (!queue.isEmpty()){
            int now_idx = queue.poll();
            System.out.print(now_idx + " ");

            for (Integer num : list.get(now_idx)){
                if (checked[num] == true) continue;
                queue.add(num);
                checked[num] = true;
            }
        }
    }

}
