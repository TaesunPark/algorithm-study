import java.util.*;

public class BJ21921 {
    public static void main(String[] args) {
        int N;
        int X;
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        N = sc.nextInt();
        X = sc.nextInt();
        long max = 0;
        long value = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++){
            deque.addLast(sc.nextInt());
            value += deque.peekLast();

            if (deque.size() == X){
                if (max == value){
                    cnt++;
                }
                if (max < value){
                    max = value;
                    cnt = 1;
                }
                value -= deque.pollFirst();
            }
        }

        if (max == 0){
            System.out.print("SAD");
            return;
        } else{
            System.out.println(max);
            System.out.print(cnt);
        }
    }
}
