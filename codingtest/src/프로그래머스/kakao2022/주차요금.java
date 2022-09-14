package 프로그래머스.kakao2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution1 {
    static int freeTime; // 기본 시간
    static int freeFee; // 기본 요금
    static int unitTime; // 단위 시간
    static int unitFee; // 단위 요금
    public int[] solution(int[] fees, String[] records) {
        initFee(fees);
        HashMap<Integer, Integer> timesMap = new HashMap<>();
        HashMap<Integer, Integer> feesMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(String s: records){
            String[] input = s.split(" ");
            Integer num = Integer.parseInt(input[1]);

            if(!list.contains(num)){
                list.add(num);
                feesMap.put(num, 0);
            }
        }

        for(String s: records){
            String[] input = s.split(" ");
            String[] times = input[0].split(":");
            Integer time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            Integer num = Integer.parseInt(input[1]);
            String status = input[2];

            if(status.equals("IN")){
                timesMap.put(num, time);
            } else{
                feesMap.replace(num, feesMap.get(num) + time - timesMap.get(num));
                timesMap.remove(num);
            }
        }

        for(Integer num : timesMap.keySet()){
            Integer time = Integer.parseInt("23") * 60 + Integer.parseInt("59");
            feesMap.replace(num, feesMap.get(num) + time - timesMap.get(num));
        }

        int[] answer = new int[list.size()];
        Collections.sort(list);
        int cnt = 0;

        for(Integer key : list){
            int fee;
            int temp = feesMap.get(key);

            if(temp <= freeTime){
                fee = freeFee;
            } else{
                int a = (int)Math.ceil(((double) temp - (double)freeTime) / (double)unitTime);

                fee = freeFee + (a * unitFee);
            }

            answer[cnt++] = fee;
        }

        return answer;
    }

    static void initFee(int[] fees){
        freeTime = fees[0];
        freeFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];
    }

}
