package 바킹독.연습문제0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17298 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Stack<Integer> results = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int listSize = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i=listSize-1; i>=0; i--){

            while (!stack.isEmpty() && (stack.peek() <= list.get(i))){
                stack.pop();
            }

            if (stack.isEmpty()){
                results.push(-1);
            } else {
                results.push(stack.peek());
            }
            stack.push(list.get(i));
        }

        while (!results.isEmpty()){
            sb.append(results.pop()+ " ");
        }
        System.out.print(sb);
    }
}

