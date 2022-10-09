package 동빈나;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 모험가길드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());
        int[] list = new int[]{2, 3, 1, 2, 2};
        System.out.print(solution(value, list));
    }

    public static int solution(int value, int[] list) {
        Arrays.sort(list);
        int result = 0;
        for(int i=value-1; i>=0; i--){
            i -= list[i];
            result += 1;
        }
        return result;
    }
}
