package 프로그래머스;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int win_count = 0;

        for(int i=0; i<6; i++){
            if(lottos[i] == 0){
                count++;
                continue;
            }
            for(int j=0;j<6;j++){
                if(lottos[i] == win_nums[j]){
                    win_count++;
                    break;
                }
            }
        }
        int result = 6-(win_count-1);
        answer[0] = result-count;
        if(result-count > 6){
            answer[0] = 6;
        }
        if(result > 6){
            result = 6;
        }
        answer[1] = result;
        return answer;
    }
}