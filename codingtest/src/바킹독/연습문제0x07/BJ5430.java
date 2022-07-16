package 바킹독.연습문제0x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int loopCnt = Integer.parseInt(br.readLine());
        boolean isR;
        for (int i=0; i<loopCnt; i++){
            isR = false;
            String cmd = br.readLine();
            int cmdSize = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new LinkedList<>();
            boolean isErrored = false;

            st = new StringTokenizer(br.readLine(),"[],");

            while (st.hasMoreTokens()){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            for (int j=0; j<cmd.length(); j++){
                if (cmd.charAt(j) == 'R'){
                    isR = !isR;
                } else if (cmd.charAt(j) == 'D'){
                    if (deque.isEmpty()) {
                        sb.append("error");
                        isErrored = true;
                        break;
                    }
                    if (isR == true){
                        deque.pollLast();
                    } else{
                        deque.pollFirst();
                    }
                }
            }

            if (isErrored == false){
                sb.append("[");
                if (deque.isEmpty()){
                    sb.append("]");
                }
                while (!deque.isEmpty()){
                    if (deque.size() == 1){
                        if (isR == false) {
                            sb.append(deque.pollFirst() + "]");
                        } else{
                            sb.append(deque.pollLast() + "]");
                        }
                    } else{
                        if (isR == false) {
                            sb.append(deque.pollFirst() + ",");
                        } else{
                            sb.append(deque.pollLast() + ",");
                        }
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}
