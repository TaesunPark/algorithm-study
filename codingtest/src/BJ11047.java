import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11047 {
    public static void main(String[] args) throws IOException {
        int n,k;
        int result=0;
        int tempValue=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] list = new int[n];

        for (int i=0; i<n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }


        for (int i=n-1; i>=0; i--){
            result += k/list[i];
            k %= list[i];
        }

        System.out.print(result);

    }
}
