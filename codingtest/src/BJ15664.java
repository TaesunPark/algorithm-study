import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15664 {

    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N, M, index=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            array[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

    }
}
