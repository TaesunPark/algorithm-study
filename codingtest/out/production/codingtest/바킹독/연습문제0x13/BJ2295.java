import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ2295 {
    static int n;
    static ArrayList<Integer> list;
    static ArrayList<Integer> sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        sum = new ArrayList<>();
        n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                int x = list.get(i) + list.get(j);
                sum.add(x);
            }
        }
        Collections.sort(list);
        Collections.sort(sum);

        for (int i=n-1; i>=0; i--){
            for (int j=0; j<i; j++){
                if (binarySearch(list.get(i) - list.get(j))){
                    System.out.print(list.get(i));
                    return;
                }
            }
        }
    }

    public static boolean binarySearch(Integer t){
        int l=0; int r = sum.size()-1;

        while (l<r){
            int m = (l + r) / 2;
            if (sum.get(m) > t){
                r = m - 1;
            } else if (sum.get(m) < t){
                l = m + 1;
            } else{
                return true;
            }
        }
        return false;
    }


}
