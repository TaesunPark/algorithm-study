package 바킹독.연습문제0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ5397RE {
    public static void main(String[] args) throws IOException {
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (cnt != 0){
            cnt--;
            String inputStr = br.readLine();
            for (int i=0; i<inputStr.length(); i++){
                Character ch = inputStr.charAt(i);

                switch (ch){
                    case '<':
                    if (!leftStack.empty()) rightStack.push(leftStack.pop());
                        break;
                    case '>':
                    if (!rightStack.empty()) leftStack.push(rightStack.pop());
                        break;
                    case '-':
                        if (!leftStack.empty()) leftStack.pop();
                        break;
                    default:
                        leftStack.push(ch);
                        break;
                }
            }
            while (!leftStack.empty()){
                rightStack.push(leftStack.pop());
            }
            while (!rightStack.empty()){
                sb.append(rightStack.pop());
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
