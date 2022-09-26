package 프로그래머스.정렬;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int resultIdx = 0;

        for(int[] command : commands){
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] newList = new int[j-i+1];
            int idx = 0;
            for(int ii = i-1; ii<j; ii++){
                newList[idx++] = array[ii];
            }
            Arrays.sort(newList);
            answer[resultIdx++] = newList[k-1];
        }

        return answer;
    }
}