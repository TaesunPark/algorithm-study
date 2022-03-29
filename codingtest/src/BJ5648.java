import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int lineCnt=0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Long> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()){
            Long num =Long.parseLong(st.nextToken());
            num = reverse(num);
            list.add(num);
            lineCnt++;
        }

        while (true){
            if (lineCnt == n) break;
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            while (st2.hasMoreTokens()){
                Long num =Long.parseLong(st2.nextToken());
                num = reverse(num);
                lineCnt++;
                list.add(num);
            }

        }
        Collections.sort(list);
        for (int i=0; i<n; i++){
            sb.append(list.get(i) + "\n");
        }
        System.out.print(sb);
    }

    public static Long reverse(Long num){
        String str = String.valueOf(num);
        String tmp = "";
        for (int i=str.length()-1; i>=0; i--){
            tmp += str.charAt(i);
        }
        return Long.parseLong(tmp);
    }
}
