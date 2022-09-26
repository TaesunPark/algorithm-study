package 프로그래머스.스택큐;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution3 {
    public int solution(int[] priorities, int location) {
        Deque<Node> deque = new ArrayDeque<>();
        int idx = 0;

        for(int a : priorities){
            deque.addLast(new Node(idx++, a));
        }

        while(true){

            Node node = deque.pollFirst();
            boolean check = false;

            for(int i=0; i<priorities.length; i++){
                if(priorities[i] > node.value){
                    deque.addLast(node);
                    check = true;
                    break;
                }
            }

            if(check == true) continue;

            priorities[node.index] = 0;

            if(node.index == location){
                return priorities.length - deque.size();
            }
        }

    }

    public class Node{
        int index;
        int value;

        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}