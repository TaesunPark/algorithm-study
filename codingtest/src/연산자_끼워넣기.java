import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기 {
    static int max;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 개수
        int[] list = new int[N];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[] cmd = new int[4]; // +, -, x,
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++){
            cmd[i] = Integer.parseInt(st.nextToken());
        }

        calculate(cmd, list, 0, list[0]);
        System.out.println(max);
        System.out.print(min);

    }

    public static void calculate(int[] cmd, int[] list, int n, int value){

            if (n == list.length - 1) {
                min = Math.min(value, min);
                max = Math.max(value, max);
                return;
            }

            for (int i = 0; i < 4; i++) {
                if (cmd[i] == 0) continue;
                cmd[i]--;
                switch (i) {
                    case 0:
                        calculate(cmd, list,n+1, value + list[n + 1]);
                        break;
                    case 1:
                        calculate(cmd, list,n+1, value - list[n + 1]);
                        break;
                    case 2:
                        calculate(cmd, list,n+1, value * list[n + 1]);
                        break;
                    case 3:
                        calculate(cmd, list,n+1, value / list[n + 1]);
                        break;
                }
                cmd[i]++;
            }
        }



}
