import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2179 {
    public static void main(String[] args) throws Exception {
        // 두 단어의 비슷한 정도는 두 단어의 접두사의 길이로 측정된다.
        // 접두사란 두 단어의 앞부분에서 공통적으로 나타나는 부분문자열
        // 두 단어의 앞에서부터 M개의 글자들이 같으면서 M이 최대인 경우
        // AHEHHEH, AHAHEH 의 접두사는 "AH",
        // 접두사의 길이가 최대인 경우가 여러 개일때는 제일 앞쪽에 있는 단어
        String max_str1="";
        String max_str2="";
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] list = new String[n + 1];
        for (int i = 0; i < n; i++){
            list[i] = br.readLine();
        }

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (list[i].compareTo(list[j]) == 0) continue;
                int cnt = getCnt(list[i], list[j]);
                if (cnt > max){
                    max_str1 = list[i];
                    max_str2 = list[j];
                    max = cnt;
                }
            }
        }
        System.out.println(max_str1);
        System.out.println(max_str2);

    }
    static int getCnt(String str1, String str2){
        int max = Math.min(str1.length(), str2.length());
        int cnt = 0;
        for (int i = 0; i < max; i++){
            if (str1.charAt(i) == str2.charAt(i)){
                cnt++;
            } else{
                break;
            }
        }
        return cnt;
    }

}
