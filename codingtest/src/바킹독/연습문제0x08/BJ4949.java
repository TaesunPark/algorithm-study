package 바킹독.연습문제0x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();


        while (true) {
            String input = br.readLine();
            if (input.equals(".")) break;
            stack.clear();

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '.'){
                    if (stack.isEmpty()) {
                        sb.append("yes \n");
                    } else{
                        sb.append("no \n");
                    }
                    break;
                }
                if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                    stack.push(input.charAt(i));
                } else if (input.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        sb.append("no \n");
                        break;
                    }
                } else if (input.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        sb.append("no \n");
                        break;
                    }
                }
            }

        }
        System.out.print(sb);
    }
}

