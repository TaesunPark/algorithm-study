package 프로그래머스.정렬;

import java.util.Arrays;

class Solution2 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] list = new String[numbers.length];
        int x = 0;

        for(int number : numbers){
            list[x++] = String.valueOf(number);
        }

        Arrays.sort(list,
                (a, b) -> {
                    return (b+a).compareTo(a+b);
                });

        if(list[0].equals("0")){
            return "0";
        }

        for(String s : list){
            answer += s;
        }

        return answer;
    }
}
