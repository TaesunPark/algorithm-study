package 프로그래머스.힙;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i : scoville){
            queue.add(i);
        }

        while(queue.peek() < K){
            int newScovile = queue.poll() + queue.poll() * 2;
            queue.add(newScovile);
            answer = answer + 1;

            if(queue.size() == 1 && queue.peek() < K){
                return -1;
            }
        }

        return answer;
    }
}