package 바킹독.연습문제0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class RE2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Node> stack = new Stack<>();

        int loopCnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<loopCnt; i++){
            int num = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().getNum() < num){
                stack.pop();
            }

            while (!stack.isEmpty() && stack.peek().getNum() > num){
                sb.append(stack.peek().getPos() + " ");
                stack.push(new Node(i+1, num));
            }

            if (stack.isEmpty()){
                sb.append("0 ");
                stack.push(new Node(i+1,num));
            }
        }
        System.out.print(sb);
    }

    static class Node{
        int pos;
        int num;
        public Node(int pos, int num){
            this.pos = pos;
            this.num = num;
        }

        public int getPos(){
            return pos;
        }

        public int getNum(){
            return num;
        }
    }


}
