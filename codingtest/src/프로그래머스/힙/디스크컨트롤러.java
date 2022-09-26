package 프로그래머스.힙;

import java.util.PriorityQueue;
import java.util.Arrays;

class Solution1 {
    public int solution(int[][] jobs) {
        PriorityQueue<int []> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        int cnt = 0;
        int cnt1 = 0;
        int lastTime = 0;
        int result = 0;

        while(cnt1 < jobs.length){

            while(cnt < jobs.length && jobs[cnt][0] <= lastTime){
                queue.add(jobs[cnt++]);
            }

            if(queue.isEmpty()){
                lastTime = jobs[cnt][0];
            } else{
                int[] resultValue = queue.poll();
                lastTime += resultValue[1];
                result += lastTime - resultValue[0];
                cnt1++;
            }

        }

        return (int) Math.floor(result/jobs.length);
    }
}
