package 바킹독.연습문제0x07;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class BJ10866 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            String[] cmd = br.readLine().split(" ");

            switch(cmd[0]){
                case "push_front":
                    stack.addFirst(Integer.parseInt(cmd[1]));
                    break;
                case "push_back":
                    stack.addLast(Integer.parseInt(cmd[1]));
                    break;
                case "pop_front":
                    if(stack.isEmpty()){
                        sb.append("-1").append("\n");
                    } else{
                        sb.append(stack.getFirst()).append("\n");
                        stack.removeFirst();
                    }
                    break;
                case "pop_back":
                    if(stack.isEmpty()){
                        sb.append("-1").append("\n");
                    } else{
                        sb.append(stack.getLast()).append("\n");
                        stack.removeLast();
                    }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        sb.append("1").append("\n");
                    }else{
                        sb.append("0").append("\n");
                    }
                    break;
                case "front":
                    if(stack.isEmpty()){
                        sb.append("-1").append("\n");
                    } else{
                        sb.append(stack.getFirst()).append("\n");
                    }
                    break;
                case "back":
                    if(stack.isEmpty()){
                        sb.append("-1").append("\n");
                    } else{
                        sb.append(stack.getLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);

    }
}
