package 바킹독.연습문제0x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10799 {
    public static void main(String[] args) throws IOException {
        Stack<Node> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;

        for (int i=0; i<str.length(); i++){
            if (!stack.isEmpty() && stack.peek().ch == '(' && str.charAt(i) == ')' && stack.peek().pos - i == -1){
                // 레이저
                stack.pop();
                cnt += stack.size();
                continue;
            }
            // 레이저 아닌 경우
            if (!stack.isEmpty() && stack.peek().ch == '(' && str.charAt(i) == ')' && stack.peek().pos - i != -1){
                cnt += 1;
                stack.pop();
                continue;
            }
            // 푸쉬할 때
            stack.push(new Node(i, str.charAt(i)));
        }
        System.out.print(cnt);


    }
    static public class Node{
        int pos;
        char ch;

        public Node(int pos, char ch){
            this.pos = pos;
            this.ch = ch;
        }
    }
}
