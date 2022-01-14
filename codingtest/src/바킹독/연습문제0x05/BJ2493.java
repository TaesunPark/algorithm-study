package 바킹독.연습문제0x05;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ2493 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){

            int m = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){
                sb.append("0 ");
                stack.push(new Node(m, i));
            } else{
                while(true){
                    if(stack.isEmpty()){
                        sb.append("0 ");
                        stack.push(new Node(m, i));
                        break;
                    }

                    Node node = stack.peek();

                    if(node.num > m){
                        sb.append(node.index + " ");
                        stack.push(new Node(m, i));
                        break;
                    } else{
                        stack.pop();
                    }

                }
            }
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
class Node{
    int num;
    int index;
    public Node(int n, int index){
        this.num = n;
        this.index = index;
    }
}