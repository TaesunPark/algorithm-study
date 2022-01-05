package 바킹독.연습문제0x05;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class BJ10773 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum=0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<n;i++){
            int item = Integer.parseInt(br.readLine());
            if(item == 0){
               stack.pop();
            } else{
                stack.push(item);
            }
        }
        while(!stack.empty()){
            sum += stack.pop();
        }

        System.out.println(sum);

    }
}
