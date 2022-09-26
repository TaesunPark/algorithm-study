package 프로그래머스.스택큐;

import java.util.Arrays;

class Solution2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] list = new int[100];
        int index = 0;
        int day = 1;

        for(int a : progresses){
            while(progresses[index] + speeds[index] * day < 100){
                day++;
            }
            (list[day])++;
            index = index + 1;
        }

        return Arrays.stream(list).filter(i -> i!=0).toArray();
    }
}
