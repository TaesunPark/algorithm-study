package 바킹독.연습문제0x05;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class BJ1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int start = 0;

        for(int i=0; i<n; i++){
            int cmd = Integer.parseInt(br.readLine());

            if(cmd > start){
                for(int j=start+1; j<=cmd; j++){
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = cmd;
            } else if(cmd != stack.peek()){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }

}
