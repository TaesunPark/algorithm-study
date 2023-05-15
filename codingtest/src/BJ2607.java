import java.util.HashMap;
import java.util.Scanner;

public class BJ2607 {
    public static void main(String[] args) {
        // 같은 구성
        // 1. 두 개의 단어가 같은 종류의 문자로 이루어져 있다.
        // 2. 같은 문자는 같은 개수 만큼 있다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int result = 0;

        for (int i = 0; i < n - 1; i++){
            String str2 = sc.next();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < str.length(); j++){
                if (map.containsKey(str.charAt(j))) {
                    map.put(str.charAt(j), map.get(str.charAt(j)) + 1);
                } else{
                    map.put(str.charAt(j), 1);
                }
            }
            int cnt = 0;
            int chkCnt = 0;

            for (int j = 0; j < str2.length(); j++){
                if (!map.containsKey(str2.charAt(j))){
                    cnt++;
                } else{
                    if (map.get(str2.charAt(j)) == 0){
                        cnt++;
                    } else{
                        map.put(str2.charAt(j), map.get(str2.charAt(j)) - 1);
                        chkCnt++;
                    }
                }
                if (cnt == 2) break;
            }

            if (str.length() == str2.length() && cnt <= 1){
                result++;
            }
            // 작은 경우
            if (str.length() > str2.length() && cnt == 0 && chkCnt == str.length() - 1){
                result++;
            }
            // 큰 경우
            if (str.length() < str2.length() && cnt == 1){
                result++;
            }


                    }
        System.out.print(result);
    }
}
