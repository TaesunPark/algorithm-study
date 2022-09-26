package 프로그래머스.힙;

import java.util.PriorityQueue;
import java.util.Collections;

class Solution2 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(String cmd : operations){
            String[] cmdList = cmd.split(" ");

            if(cmdList[0].equals("I")){
                minQueue.add(Integer.parseInt(cmdList[1]));
                maxQueue.add(Integer.parseInt(cmdList[1]));
            } else{

                if(maxQueue.isEmpty()) continue;

                if(Integer.parseInt(cmdList[1]) < 0){
                    int value = minQueue.poll();
                    maxQueue.remove(value);
                } else{
                    int value = maxQueue.poll();
                    minQueue.remove(value);
                }
            }

        }

        if(maxQueue.isEmpty()){
            int[] answer = {0,0};
            return answer;
        }

        int[] answer = new int[2];
        answer[0] = maxQueue.poll();
        answer[1] = minQueue.poll();


        return answer;
    }
}