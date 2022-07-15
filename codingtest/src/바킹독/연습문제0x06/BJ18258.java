package 바킹독.연습문제0x06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int loopCnt = Integer.parseInt(br.readLine());

        for (int i=0; i<loopCnt; i++){
            String[] inputList = br.readLine().split(" ");
            String str = inputList[0];
            int num = 0;

            if (inputList.length == 2) {
                num = Integer.parseInt(inputList[1]);
            }

            switch (str){
                case "push":
                    queue.addFirst(num);
                    break;
                case "pop":
                    if (queue.isEmpty()){
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.pollLast()+"\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()+"\n");
                    break;
                case "empty":
                    if (queue.isEmpty()){
                        sb.append("1\n");
                    } else{
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()){
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.getLast() + "\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()){
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.getFirst() + "\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}
