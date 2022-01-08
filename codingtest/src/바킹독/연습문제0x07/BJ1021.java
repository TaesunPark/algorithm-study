package 바킹독.연습문제0x07;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ1021 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] array = new int[M];
        int count = 0;

        LinkedList<Integer> stack = new LinkedList<Integer>();

        for(int i=1;i<=N;i++){
            stack.addLast(i);
        }

        for(int i=0; i<M; i++){
            array[i] = sc.nextInt();
        }

        for(int i=0; i<M;i++){
            int halfIndex;
            int targetIndex = stack.indexOf(array[i]);

            if(stack.size() % 2 == 1){
                halfIndex = stack.size()/2;
            } else{
                halfIndex = (stack.size()/2) - 1;
            }

            if(targetIndex <= halfIndex){
                for(int j=0; j<targetIndex; j++){
                    int a = stack.pollFirst();
                    stack.offerLast(a);
                    count++;
                }
            } else{
                for(int j=0; j<stack.size()-targetIndex; j++){
                    int a = stack.pollLast();
                    stack.addFirst(a);
                    count++;
                }
            }
            stack.pollFirst();
        }
        System.out.println(count);
    }
}
