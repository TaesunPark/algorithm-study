import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ11652 {
    static int n;
    static int maxCnt;
    static Long maxValue;
    static int cnt;
    static int nowValue;

    static ArrayList<Long> arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arrayList = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        maxCnt = 0;
        for (int i=0; i<n; i++){
            arrayList.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(arrayList);
        Long beforeValue = arrayList.get(0);
        maxValue = arrayList.get(0);
        for (int i=1; i<n; i++){
            if (beforeValue.equals(arrayList.get(i))){
                cnt++;
            }

            if (cnt > maxCnt){
                maxValue = arrayList.get(i);
                maxCnt = cnt;
            }

            if (!beforeValue.equals(arrayList.get(i))){
                cnt=0;
                beforeValue = arrayList.get(i);
            }

        }
        System.out.print(maxValue);
    }
}
