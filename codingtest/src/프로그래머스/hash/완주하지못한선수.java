package 프로그래머스.hash;

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> hash = new HashMap<>(); // hash 자료구조 생성

        for(String s : completion){
            if(hash.get(s) == null){
                hash.put(s, 1);
            } else{
                hash.replace(s, hash.get(s) +1);
            }
        }

        for(String s : participant){
            if(hash.get(s) == null || hash.get(s) == 0){
                return s;
            } else{
                hash.replace(s, hash.get(s) -1);
            }
        }

        String answer = "";
        return answer;
    }
}
