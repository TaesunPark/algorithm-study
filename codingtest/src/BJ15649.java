import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15649 {

    static int n;
    static int m;
    static boolean[] isUsed;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr2 = br.readLine().split(" ");
        n = Integer.parseInt(arr2[0]);
        m = Integer.parseInt(arr2[1]);
        isUsed = new boolean[10];
        arr = new int[10];
        dfs(0);
    }

    public static void dfs(int k){
        if(k == m){
            for (int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.printf("\n");
            return;
        }

        for (int i=1; i<=n; i++){
            if (!isUsed[i]){
                arr[k] = i;
                isUsed[i] = true;
                dfs(k+1);
                isUsed[i] = false;
            }
        }
    }
}
