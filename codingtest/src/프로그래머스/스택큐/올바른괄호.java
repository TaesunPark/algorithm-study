package 프로그래머스.스택큐;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution1 {
    boolean solution(String s) {
        boolean answer = true;
        Deque<String> deque = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                deque.addFirst("(");
            } else{
                if(deque.isEmpty()){
                    return false;
                }
                deque.pollFirst();
            }
        }

        if(!deque.isEmpty()){
            return false;
        }
        return true;
    }
}