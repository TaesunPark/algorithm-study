package 바킹독.연습문제0x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;

        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) == '['){
                value *= 3;
                stack.push('[');
            } else if (str.charAt(i) == '('){
                value *= 2;
                stack.push('(');
            } else if (!stack.isEmpty() && str.charAt(i) == ']'){
                if (stack.peek() == '(') break;
                if (stack.peek() == '[' && str.charAt(i-1) == '['){
                    result += value;
                }
                stack.pop();
                value /= 3;
            } else if (!stack.isEmpty() && str.charAt(i) == ')'){
                if (stack.peek() == '[') break;
                if (stack.peek() == '(' && str.charAt(i-1) == '('){
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else {
                System.out.print(0);
                return;
            }
        }
        if (stack.isEmpty()){
            System.out.print(result);
        } else{
            System.out.print(0);
        }

    }

}
