import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1806 {
    public static void main(String[] args) throws IOException {
        int n, s;
        int min = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        Integer[] list = new Integer[n];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int total=0;
        int en = 0;
        total = list[0];
        for (int start =0; start<n;start++){
            while (en < n && total < s){
                en++;
                if (en != n) total += list[en];
            }
            if (en == n) break;
            min = Math.min(min, en - start + 1);
            total -= list[start];
        }

        if (min == Integer.MAX_VALUE) System.out.print(0);
        else System.out.print(min);

    }
}
