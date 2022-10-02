package 프로그래머스.완전탐색;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int value = brown / 2;

        for(int i = 3;; i++){

            int wide = value - i;

            if((i-2) * wide == yellow){
                answer[1] = i;
                answer[0] = wide + 2;
                return answer;
            }
        }

    }
}