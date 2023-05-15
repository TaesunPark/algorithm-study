import java.util.Scanner;

public class BJ1515 {
    static int K;
    static String str;
    static boolean[] checked;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 20
        K = sc.nextInt(); // 1
        str = sc.next();
        checked = new boolean[N + 1];

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'P'){
                checked[i] = true;
            } else{
                checked[i] = false;
            }
        }

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'P') {
                search(i);
            }
        }

        System.out.print(result);

    }

    public static void search(int idx){
        // 좌 탐색
        // 끝부터 탐색
        for(int l = idx - K; l <= idx + K; l++){
            if (l < 0 || l >= str.length()) continue;
            if (checked[l] == true) continue;
            checked[l] = true;
            result++;
            return;
        }

        // 우
    }
}
