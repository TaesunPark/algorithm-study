package 동빈나;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱하기혹은더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        System.out.print(solution(value));
    }

    public static int solution(String value) {
        int result = 0;

        for (int i = 0; i < value.length(); i++){
            int v1 = value.charAt(i) - '0';

            if(v1 == 0 || v1 == 1 || result == 0 || result == 1){
                result += v1;
            } else{
                result *= v1;
            }
        }
        return result;
    }
}
