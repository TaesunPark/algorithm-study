package 프로그래머스.hash;

import java.util.HashMap;

class Solution1 {
    public int solution(int[] nums) {
        int pickNum = nums.length / 2;
        HashMap<Integer, Integer> hash = new HashMap<>();

        for(int s : nums){
            if(hash.get(s) == null){
                hash.put(s, 0);
            }
        }
        if(pickNum <= hash.size()){
            return pickNum;
        } else{
            return hash.size();
        }

    }
}