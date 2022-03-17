import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ1759 {

    static int n, m;
    static ArrayList<Character> arrayList;
    static char[] array;
    static boolean[] isUsed;
    static boolean check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        arrayList = new ArrayList<Character>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        array = new char[m];
        isUsed = new boolean[m];

        String[] str2 = br.readLine().split(" ");

        for (int i=0; i<m; i++){
            array[i] = str2[i].charAt(0);
        }

        Arrays.sort(array);

        recur(0, 0);
        System.out.print(sb);
    }
    public static void recur(int depth, int start){
        if (depth == n){
            int cnt = 0;
            for (int i=0; i<n; i++){
                if (arrayList.get(i) == 'a' || arrayList.get(i) == 'i' || arrayList.get(i) == 'o' || arrayList.get(i) == 'e' || arrayList.get(i) == 'u'){
                    check = true;
                    cnt++;
                }
            }
            if (check == true && arrayList.size() - cnt >=2) {
                for (int i = 0; i < n; i++) {
                    sb.append(arrayList.get(i));
                }
                sb.append("\n");
            }
            check = false;
            return;
        }

        for (int i=start; i<array.length; i++){
            if (isUsed[i] == true) continue;
            isUsed[i] = true;

            arrayList.add(array[i]);
            recur(depth+1, i);

            arrayList.remove(arrayList.size()-1);
            isUsed[i] = false;
        }
    }
}
