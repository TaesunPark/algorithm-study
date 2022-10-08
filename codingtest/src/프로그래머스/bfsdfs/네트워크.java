package 프로그래머스.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
    public static boolean[] check;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];

        for(int i=0; i<n; i++){

            if(check[i] == true){
                continue;
            }
            
            answer += bfs(computers, i);
        }
        return answer;
    }
    public static int bfs(int[][] computers, int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        check[index] = true;

        while(!queue.isEmpty()){
            int idx = queue.poll();
            int[] computer = computers[idx];

            for(int i=0; i<computer.length; i++){
                if(check[i] == true) continue;
                if(computer[i] == 0) continue;
                queue.add(i);
                check[i] = true;
            }
        }

        return 1;
    }
}
