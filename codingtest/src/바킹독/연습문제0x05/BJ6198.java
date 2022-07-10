package 바킹독.연습문제0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ6198 {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loopCnt = Integer.parseInt(br.readLine());
        long cnt = 0;

        for(int i=0; i<loopCnt; i++){

            int num = Integer.parseInt(br.readLine());

            while ((stack.size() != 0) && stack.peek() - num <= 0){
                stack.pop();
            }
            cnt += stack.size();
            stack.push(num);
        }
        System.out.print(cnt);
    }
}
