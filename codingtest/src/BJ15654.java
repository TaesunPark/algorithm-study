import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15654 {
    public static int n;
    public static int m;
    public static boolean[] isUsed;
    public static int[] array;
    public static StringBuilder sb;
    public static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String str = br.readLine();
        String[] str2 = str.split(" ");
        n = Integer.parseInt(str2[0]);
        m = Integer.parseInt(str2[1]);
        array = new int[n];
        result = new ArrayList<Integer>();
        isUsed = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()){
            array[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        bfs(0, 0);
        System.out.print(sb);
    }

    static public void bfs(int depth, int start){
        if (depth == m){
            for (int i=0; i<m; i++){
                sb.append(result.get(i) + " ");
            }
            sb.append("\n");
            return;
        }
        int tmp = -1;

        for(int i=start; i<n; i++){
            if (tmp > array[i] || tmp == array[i]) continue;
            result.add(array[i]);
            tmp = array[i];
            bfs(result.size(), i);
            result.remove(result.size()-1);
        }

    }
}
