import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ6603 {
    static ArrayList<Integer> list;
    static ArrayList<Integer> resultList;
    static boolean[] isUsed;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        list = new ArrayList<Integer>();
        resultList = new ArrayList<Integer>();

        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] str = br.readLine().split(" ");
            if (Integer.parseInt(str[0]) == 0){
                break;
            }
            isUsed = new boolean[Integer.parseInt(str[0])+1];
            list.clear();

            for (int i = 1; i < str.length; i++) {
                list.add(Integer.parseInt(str[i]));
            }
            Collections.sort(list);
            recur(0, 0);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void recur(int depth, int start){
        if (depth == 6){
            for (int i=0; i<6; i++){
                sb.append(resultList.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i<list.size(); i++){
            if (isUsed[i] == true) continue;
            isUsed[i] = true;
            resultList.add(list.get(i));
            recur(depth+1, i);
            isUsed[i] = false;
            resultList.remove(resultList.size()-1);
        }
    }

}
