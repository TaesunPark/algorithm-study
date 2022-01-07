package 바킹독.연습문제0x06;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BJ10845 {
    public static void main(String[] args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        Queue<Integer> stack = new LinkedList<Integer>();
        int back = -1;

        while(n-- != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] cmd = new String[st.countTokens()];

            int i=0;
            while(st.hasMoreTokens()){
                cmd[i++] = st.nextToken();
            }
            switch(cmd[0]){
                case "push":
                    back = Integer.parseInt(cmd[1]);
                    stack.offer(back);
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        System.out.println("-1");
                    }else {
                        System.out.println(stack.poll());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()) {
                        System.out.println("1");
                    }
                    else {
                        System.out.println("0");
                    }
                    break;
                case "front":
                    if(stack.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(stack.peek());
                    }
                    break;
                case "back":
                    if(stack.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(back);
                    }
                    break;
            }


        }

    }
}
