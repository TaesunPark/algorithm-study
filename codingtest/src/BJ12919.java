import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ12919 {

    static int result;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        String a;
        String b;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        result = 0;
        dfs(b.length(), a,b);
        System.out.print(result);
    }

    public static void dfs(int depth, String a, String b){

        if (depth == a.length()){
            if (a.equals(b)){
                result = 1;
            }
            return;
        }

        if (b.length() == 1) return;

        if (b.charAt(b.length() - 1) == 'A'){
            dfs(depth-1, a, b.substring(0, b.length()-1));
        }

        if (b.charAt(0) == 'B'){
            dfs(depth-1, a, reverse(b.substring(1, b.length())));
        }

    }

    public static String reverse(String str){
//        String value = "";
        sb = new StringBuffer(str);
        return sb.reverse().toString();
//        for (int i = str.length() - 1; i >= 0; i--){
//            value += str.charAt(i);
//        }

//        return value;
    }

}
