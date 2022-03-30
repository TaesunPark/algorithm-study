import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Node> dp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        dp.add(new Node(1, 0));
        dp.add(new Node(0, 1));

        for (int i=2; i<=40; i++){
            int a, b;
            b = dp.get(i-1).one_cnt + dp.get(i-2).one_cnt;
            a = dp.get(i-1).zero_cnt + dp.get(i-2).zero_cnt;
            dp.add(new Node(a, b));
        }

        for (int i=0; i<n; i++){
            int n1 = Integer.parseInt(br.readLine());
            sb.append(dp.get(n1).zero_cnt +" "+ dp.get(n1).one_cnt+"\n");
        }
        System.out.print(sb);

    }

    static class Node{
        int zero_cnt;
        int one_cnt;
        public Node(int zero_cnt, int one_cnt){
            this.zero_cnt = zero_cnt;
            this.one_cnt = one_cnt;
        }
    }
}
