import java.util.Scanner;

public class BJ1522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int aCnt = 0;

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'a'){
                aCnt++;
            }
        }
        int bCnt = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++){
            bCnt = 0;
            for (int j = i; j < (aCnt + i); j++){
                if (str.charAt(j % str.length()) == 'b') bCnt++;
            }
            result = Math.min(result, bCnt);

        }

        System.out.print(result);
    }
}
