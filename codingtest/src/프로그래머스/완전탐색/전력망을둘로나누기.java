package 프로그래머스.완전탐색;

import java.util.Queue;
import java.util.LinkedList;

class Solution3 {

    public static Queue<Integer> queue;
    public static int[][] map;
    public static boolean[] check;

    public int solution(int n, int[][] wires) {
        int answer = -1;
        int min = Integer.MAX_VALUE;

        map = new int[n+1][n+1];

        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for(int i=0; i<n-1; i++){
            int[] wire = wires[i];
            int a = wire[0];
            int b = wire[1];
            map[a][b] = 0;
            map[b][a] = 0;
            min = Math.min(bfs(a, n), min);
            map[a][b] = 1;
            map[b][a] = 1;
        }
        answer = min;
        return answer;
    }

    public static int bfs(int n, int m){
        int cnt = 1;
        queue = new LinkedList<>();
        queue.add(n);
        check = new boolean[m+1];
        check[n] = true;

        while(!queue.isEmpty()){
            int idx = queue.poll();

            for(int i=1; i<=m; i++){
                if(check[i] == true) continue;

                if(map[idx][i] == 1){
                    queue.add(i);
                    check[idx] = true;
                    cnt++;
                }
            }
        }

        return (int)Math.abs(m -2*cnt);
    }

}
