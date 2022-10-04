package 바킹독.연습문제0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ3015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loopCnt = Integer.parseInt(br.readLine());
        long result = 0;
        Stack<Node> stack = new Stack<>();

        for (int i=0; i<loopCnt; i++){
            int num = Integer.parseInt(br.readLine());
            Node node = new Node(num, 1);

            while (!stack.empty() && stack.peek().num <= num){
                Node pop = stack.pop();
                result += pop.cnt;
                if (pop.num == num){
                    node.cnt += pop.cnt;
                }
            }

            if (!stack.empty()){
                result += 1;
            }

            stack.push(node);
        }
        System.out.print(result);
    }

    static class Node{
        int num;
        int cnt;

        public Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
}
