package 바킹독.연습문제0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ9466 {

    static Queue<Node> queue;
    static Stack<Node> stack;

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();
        stack = new Stack<>();

        for (int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()){
                stack.push(new Node(i, Integer.parseInt(st.nextToken())));
            }

        }

    }

    static class Node{
        int from;
        int to;
        public Node(int from, int to){
            this.from = from;
            this.to = to;
        }
    }

}
