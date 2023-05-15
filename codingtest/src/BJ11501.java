import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ11501 {
    public static void main(String[] args) throws IOException {
        int N;

        Stack<Integer> stack;
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            int M = Integer.parseInt(br.readLine());

            long result = 0;
            stack = new Stack<>();

            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()){
                stack.add(Integer.parseInt(st.nextToken()));
            }

            int value = stack.pop(); // 9

            while (!stack.isEmpty()) {

                while (!stack.isEmpty() && stack.peek() < value) {
                    result += value - stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == value) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() > value) {
                    value = stack.pop();
                }

            }

            sb.append(result + "\n");
        }

        System.out.print(sb);

    }
}
