package 프로그래머스.스택큐;

import java.util.Queue;
import java.util.LinkedList;

class Solution5 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int tW = 0;
        int i = 0;

        while(true){
            if(i >= truck_weights.length) break;

            if(queue.size() >= bridge_length){
                tW -= queue.poll();
            }
            if(queue.isEmpty()){
                time += 1;
                queue.add(truck_weights[i]);
                tW = truck_weights[i++];
            } else if( queue.size() < bridge_length
                    && truck_weights[i] + tW <= weight){
                time += 1;
                tW += truck_weights[i];
                queue.add(truck_weights[i++]);
            } else{
                time += 1;
                queue.add(0);
            }
        }
        return time + bridge_length;
    }

}