import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BJ11279 {
    static Deque<Integer> inputDeque;
    static int n, max;
    static ArrayList<Integer> resultList;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        inputDeque = new ArrayDeque<>();
        resultList = new ArrayList<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if (num == 0){
                if (resultList.isEmpty()){
                    sb.append("0");
                    sb.append("\n");
                } else {
                    remove();
                }
            } else{
                resultList.add(num);
            }
        }
        System.out.print(sb);
    }

    public static void remove(){
        max = 0;
        int index =0;
        for (int i=0; i<resultList.size(); i++){
            if (max < resultList.get(i)){
                max = resultList.get(i);
                index = i;
            }
        }
        sb.append(resultList.get(index) + "\n");
        resultList.remove(index);
    }
}
