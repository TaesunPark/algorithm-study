import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2230 {
    public static void main(String[] args) throws IOException {
        int n,m;
        int end = 0;
        int min = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] list = new int[n];

        m = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        for (int start=0; start<n; start++){
            while (end < n && list[end] - list[start] < m) {
                end++;
            }

            if (end == n) break;
            min = Math.min(min, list[end] - list[start]);
        }

        System.out.print(min);
    }
}
