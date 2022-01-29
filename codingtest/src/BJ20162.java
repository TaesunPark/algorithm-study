import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20162 {

    public static int[] list;
    public static int n;
    public static int maxIndex;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new int[n];
        list[0] = Integer.parseInt(br.readLine());
        maxIndex = 0;
        result = list[0];

        for(int i=1; i<n; i++){
            list[i] = Integer.parseInt(br.readLine());
            if(list[i] > list[maxIndex]){
                maxIndex = i;
                result += list[i];
            }
        }

        System.out.println(result);

    }
}
