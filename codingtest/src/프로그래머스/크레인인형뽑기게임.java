package 프로그래머스;

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Node> stack = new Stack();
        int answer = 0;

        for(int i=0; i<moves.length; i++){
            int board_i=0;
            int board_j = moves[i]-1;

            for(int j=0;j<board[0].length;j++){
                if(board[j][board_j] != 0){
                    board_i = j;
                    break;
                }
            }
            if(board[board_i][board_j] == 0) continue;



            Node node = new Node(board_j, board[board_i][board_j]);

            if(stack.size() == 0){
                stack.add(node);
                board[board_i][board_j] = 0;
            } else{
                if(stack.peek().getNumber() == node.getNumber()){
                    answer += 2;
                    stack.pop();
                    board[board_i][board_j] = 0;
                } else{
                    stack.add(node);
                    board[board_i][board_j] = 0;
                }
            }
        }

        return answer;
    }
    static class Node{
        int y;
        int number;
        public Node(int y, int number){
            this.y = y;
            this.number = number;
        }
        public int getNumber(){
            return number;
        }
    }
}