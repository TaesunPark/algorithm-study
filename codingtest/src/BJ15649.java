import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ15649 {

    public static boolean[] isUsed;
    public static ArrayList<Integer> arrayList;
    public static int n;
    public static int m;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        String a = br.readLine();
        String[] str = a.split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        isUsed = new boolean[n+1];
        arrayList = new ArrayList<Integer>();
        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int depth){
        if (depth == m){
            for (int i=0; i<arrayList.size(); i++){
                sb.append(arrayList.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i=1; i<=n;i++){
            if (!arrayList.isEmpty() && arrayList.get(arrayList.size()-1) > i){
                continue;
            }
            arrayList.add(i);
            dfs(arrayList.size());
            arrayList.remove(arrayList.size()-1);

        }
    }

}
