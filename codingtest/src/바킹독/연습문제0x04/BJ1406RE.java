package 바킹독.연습문제0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1406RE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int loopCnt = Integer.parseInt(br.readLine());

        for (int i=0; i<str.length(); i++){
            leftStack.push(str.charAt(i));
        }

        for (int i=0; i<loopCnt; i++){
            String inputList = br.readLine();
            Character ch = null;

            if (inputList.length() == 3){
                ch = inputList.charAt(2);
            }

            Character cmd = inputList.charAt(0);

            switch (cmd){
                case 'L':
                    if (!leftStack.empty()){
                        Character input = leftStack.pop();
                        rightStack.push(input);
                    }
                    break;
                case 'D':
                    if (!rightStack.empty()){
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':
                    if (!leftStack.empty()){
                        leftStack.pop();
                    }
                    break;
                case 'P':
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


        System.out.print(sb);
    }
}
