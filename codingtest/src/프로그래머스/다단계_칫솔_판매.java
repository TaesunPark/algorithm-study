package 프로그래머스;

import java.util.*;
public class 다단계_칫솔_판매 {
    static int n; // 참여한 수
    static HashMap<String, Integer> map;
    static int[] answer;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        map = new HashMap<>();
        n = enroll.length;
        answer = new int[n];

        for(int i = 0; i < n; i++){
            map.put(enroll[i], i);
        }

        for(int i = 0; i < seller.length; i++){
            int sellNum = map.get(seller[i]);
            int sellAmount = amount[i];
            divide(sellNum, sellAmount * 100, referral);
        }

        return answer;
    }
    public static void divide(int sellNum, int sellAmount, String[] referral){

        int nowAmount = sellAmount - (sellAmount / 10);
        int divideAmount = sellAmount / 10;

        answer[sellNum] += nowAmount;
        if(divideAmount == 0) return;
        if(referral[sellNum].equals("-")) return;
        divide(map.get(referral[sellNum]), divideAmount, referral);
    }
}
