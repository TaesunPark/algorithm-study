import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9935 {
    public static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        result = str1;
        StringBuffer sb = new StringBuffer();

        while (true){
            int idx = str1.indexOf(str2);

            if (str1.length() < result.length()){
                result = str1;
            }

            if (idx == -1){
                break;
            }

            str1 = str1.substring(0, idx) + str1.substring(idx + str2.length(), str1.length());
        }

        if (result.equals("")){
            System.out.print("FRULA");
        } else{
            System.out.println(result);
        }

    }

    public static void dfs(String str1, String str2){
        int idx = str1.indexOf(str2);
        if (str1.length() < result.length()){
            result = str1;
        }

        if (idx == -1){
            return;
        }


        str1 = str1.substring(0, idx) + str1.substring(idx + str2.length(), str1.length());
        dfs(str1, str2);
    }
}
