package 프로그래머스.스택큐;

import java.util.Stack;

class Solution6 {
    public int[] solution(int[] prices) {
        Stack<Node> stack = new Stack<>();

        int idx = 0;
        int[] result = new int[prices.length];

        for(int a : prices){

            while(!stack.isEmpty() && stack.peek().value > a){
                Node node = stack.pop();
                result[node.index] = idx - node.index;
            }
            stack.push(new Node(idx, a));
            idx ++;
        }
        int cnt = 0;
        while(!stack.isEmpty()){
            Node node = stack.pop();
            result[node.index] = prices.length - node.index - 1;
        }


        return result;
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