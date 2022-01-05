package 바킹독.연습문제0x05;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class BJ10828 {
    public static void main(String[] args) throws IOException{
        int n;
        Stack stack = new Stack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n;i++){
            String cmd = br.readLine();
            StringTokenizer st = new StringTokenizer(cmd);
            String[] cmdList= new String[st.countTokens()];
            int j=0;
            while(st.hasMoreTokens()){
                cmdList[j++] = st.nextToken();
            }

            switch(cmdList[0]){
                case "push":
                    stack.add(cmdList[1]);
                    break;
                case "pop":
                    if(stack.size() == 0)
                        System.out.println("-1");
                    else{
                        System.out.println(stack.pop());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.size() == 0){
                        System.out.println("1");
                    } else{
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if(stack.size() > 0)
                    {
                        System.out.println(stack.peek());
                    } else{
                        System.out.println("-1");
                    }
                    break;
            }
        }
    }
}
