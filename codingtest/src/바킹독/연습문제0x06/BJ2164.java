package 바킹독.연습문제0x06;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BJ2164 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=0;
        Queue<Integer> stack = new LinkedList<Integer>();

        for(int i=1;i<=n;i++){
            stack.offer(i);
        }

        while(true){

            if(count == (n*2)-2){
                System.out.print(stack.poll());
                break;
            }

            if(count%2 == 0){
                stack.poll();
                count++;
            } else{
                stack.offer(stack.poll());
                count++;
            }


        }


    }
}
