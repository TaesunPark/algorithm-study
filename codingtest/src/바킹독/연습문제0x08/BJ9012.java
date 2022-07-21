package 바킹독.연습문제0x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012 {
    public static void main(String[] args) throws IOException {
        int n;
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        boolean check;

        for (int i=0; i<n; i++){
            String str = br.readLine();
            for (int j=0; j<str.length(); j++){
                check = false;
                if (!stack.isEmpty() && stack.peek() == '(' && str.charAt(j) == ')'){
                    stack.pop();
                    check = true;
                }
                if (check == true){
                    continue;
                }
                stack.push(str.charAt(j));
            }

            if (stack.size() != 0){
                sb.append("NO\n");
                stack.clear();
            } else{
                sb.append("YES\n");
                stack.clear();
            }
        }
        System.out.print(sb);
    }
}
