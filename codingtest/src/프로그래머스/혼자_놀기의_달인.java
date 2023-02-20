package 프로그래머스;

import java.util.Arrays;

class 혼자_놀기의_달인 {
    public int solution(int[] cards) {
        boolean[] check = new boolean[cards.length];
        int[] result = new int[cards.length];
        int answer = 0;
        int idx = 0;

        for(int i = 0; i < cards.length; i++){
            int value = 0;
            int index = i;

            while(true){
                if(check[index] == true) break;
                check[index] = true;
                value++;
                index = cards[index] - 1;
            }
            result[i] = value;
        }

        Arrays.sort(result);

        return result[result.length - 1] * result[result.length - 2];
    }
}