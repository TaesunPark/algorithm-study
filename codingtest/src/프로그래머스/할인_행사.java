package 프로그래머스;

import java.util.HashMap;

class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;
        int size = 0;

        for(int num : number){
            size += num;
        }

        for(int i = 0; discount.length - i >= 10; i++){
            HashMap<String, Integer> h_main = new HashMap<>();
            set(want, number, h_main);
            int cnt = 0;
            for(int j = i; j < i + 10; j++){
                if(h_main.get(discount[j]) != null && h_main.get(discount[j]) > 0){
                    h_main.put(discount[j], h_main.get(discount[j]) - 1);
                    cnt++;
                }

            }

            if(cnt == size){
                answer++;
            }
        }

        return answer;
    }

    public static void set(String[] want, int[] number, HashMap<String, Integer> h_main){
        for(int i = 0; i < want.length; i++){
            h_main.put(want[i], number[i]);
        }
    }
}
