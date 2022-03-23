import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11728 {
    public static void main(String[] args) throws IOException {
        int[] a;
        int[] b;
        int[] result;
        int idx=0;
        int bIdx=0;
        int aIdx=0;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        a = new int[Integer.parseInt(str[0])];
        b = new int[Integer.parseInt(str[1])];

        result = new int[Integer.parseInt(str[0]) + Integer.parseInt(str[1])];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int index=0;

        while (st.hasMoreTokens()){
            a[index++] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int index1=0;

        while (st2.hasMoreTokens()){
            b[index1++] = Integer.parseInt(st2.nextToken());
        }

        for (int i=aIdx; i<a.length;i++){
            for (int j=bIdx; j<b.length; j++){
                if (a[i] <= b[j]){
                    result[idx++] = a[i];
                    aIdx++;
                    break;
                } else{
                    result[idx++] = b[j];
                    bIdx++;
                }
            }
        }

        if (aIdx != a.length){
            for (int i=aIdx; i<a.length; i++){
                result[idx++] = a[i];
            }
        }
        if (bIdx != b.length){
            for (int i=bIdx; i<b.length; i++){
                result[idx++] = b[i];
            }
        }
        for (int i=0; i<result.length; i++){
            sb.append(result[i] + " ");
        }
        System.out.print(sb);
    }
}
