package 바킹독.연습문제0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] set = {0,0,0,0,0,0,0,0,0,0};
        int max;

        for (int i=0; i<str.length(); i++){
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (num == 9 || num == 6) num = 6;
            (set[num])++;
        }

        if (set[6] % 2 == 0){
            set[6] = (set[6] / 2);
        } else{
            set[6] = (set[6] / 2) + 1;
        }

        max = set[0];

        for (int i=1; i<9; i++){
            if (max < set[i]) max = set[i];
        }
        System.out.print(max);
    }

}
