import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H, W;
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int idx = 0;
        int result = 0;

        for (int i = 0; i < W; i++){
            int left = 0;
            int right = 0;
            for (int j = i - 1; j >=0; j--){
                left = Math.max(left, list.get(j));
            }

            for (int j = i + 1; j < W; j++){
                right = Math.max(right, list.get(j));
            }

            if (left < list.get(i) || right < list.get(i)) continue;

            result += Math.min(left, right) - list.get(i);
        }

        System.out.print(result);
    }
}
