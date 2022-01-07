package 바킹독.연습문제0x05;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size;
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        int[] list = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a=0;
        int count = 0;

        while(st.hasMoreTokens()) {
            a = Integer.parseInt(st.nextToken());
            stack.push(a);
            list[count++] = a;
        }

        while(!stack.empty()){
            size = stack.size();

            for(int i=size-2;i>=0;i--){
                if(list[i] >= stack.peek()){
                    result.push(i+1);
                    break;
                } else if(i==0&&list[0] < stack.peek()){
                    result.push(0);
                }
            }
            stack.pop();
        }
            System.out.print("0" + " ");

            while(!result.empty()){
                System.out.print(result.pop() + " ");
            }
    }
}
