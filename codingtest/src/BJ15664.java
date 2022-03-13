import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class BJ15664 {

    static int n,m;
    static boolean[] isUsed;
    static int[] array;
    static int[] result;
    static HashSet hashSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        n = Integer.parseInt(a[0]);
        m = Integer.parseInt(a[1]);
        isUsed = new boolean[10];
        array = new int[n];
        result = new int[10];
        hashSet = new HashSet();
        String[] b = br.readLine().split(" ");

        for (int i=0; i<b.length; i++){
            array[i] = Integer.parseInt(b[i]);
        }

        Arrays.sort(array);

        bfs(0);
    }
    public static void bfs(int k){
        if (k == m){
            if (!hashSet.contains(result)){
                hashSet.add(result);
                for (int i=0; i<m; i++){
                    System.out.print(result[i]+" ");
                }
                System.out.print("\n");
                return;
            }
            return;
        }

        for (int i=0; i<n; i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                result[i] = array[i];

                System.out.println(result[i]+"hi");

                bfs(k+1);
                isUsed[i] = false;
            }
        }
    }
}
