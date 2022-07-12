package 바킹독.연습문제0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RE6198 {
    public static void main(String[] args) throws IOException {
        Stack<Long> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        int loopCnt = Integer.parseInt(br.readLine());

        for (int i=0; i<loopCnt; i++){
            long num = Long.parseLong(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }
            result += stack.size();
            stack.push(num);
        }

        System.out.print(result);

    }
}
