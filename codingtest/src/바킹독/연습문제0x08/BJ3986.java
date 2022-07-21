package 바킹독.연습문제0x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ3986 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int loopCnt = Integer.parseInt(br.readLine());

        int cnt =0;

        for (int i=0; i<loopCnt; i++){
            String str = br.readLine();

            for (int j=0; j<str.length();j++){
                boolean check = false;
                while (!stack.isEmpty() && stack.peek() == str.charAt(j)){
                    stack.pop();
                    check = true;
                }
                if (check == true) continue;

                stack.push(str.charAt(j));

            }
            if (stack.isEmpty()){
                cnt++;
            }else{
                stack.clear();
            }
        }
        System.out.print(cnt);
    }
}
