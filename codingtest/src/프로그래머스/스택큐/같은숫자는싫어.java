package 프로그래머스.스택큐;

import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> queue = new ArrayDeque<>();

        for(int a : arr){
            if(queue.isEmpty() == false && queue.peekFirst().equals(a)){
                continue;
            }else{
                queue.addFirst(a);
            }
        }

        int[] answer = new int[queue.size()];
        int i = 0;

        while(!queue.isEmpty()){
            answer[i++] = queue.pollLast();
        }

        return answer;
    }
}