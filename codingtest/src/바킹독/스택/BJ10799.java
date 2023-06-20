package 바킹독.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        Integer result = 0;

        for (int i = 0; i < s.length(); i++){
            int cnt = 0;
            // 레이저 개수 구하기
            while (true) {
                if (s.length() > i && s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                    cnt++;
                    i += 1;
                } else{
                    break;
                }
            }

            //레이저가 있을 때
            if (cnt > 0){
                result += cnt * stack.size();
            } else{
                if (s.charAt(i) == '('){
                    stack.add('(');
                    result += 1;
                } else{
                    stack.pop();
                }
            }
        }

        System.out.print(result);

    }
}
