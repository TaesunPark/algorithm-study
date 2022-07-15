package 바킹독.연습문제0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int loopCnt = Integer.parseInt(br.readLine());
        int secondPoint = 0;
        int firstPoint = 0;
        int wantedValue;
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        wantedValue = Integer.parseInt(br.readLine());

        // nlogn
        Collections.sort(list);
        secondPoint = list.size()-1;
        // 만약 1 + 끝 == 둘 다 이동
        // 1 + 끝 > 끝을 이동
        // 1 + 끝 < 1을 이동

        while (firstPoint < secondPoint){
            int firstValue = list.get(firstPoint);
            int secondValue = list.get(secondPoint);

            if (firstValue + secondValue == wantedValue){
                firstPoint++;
                secondPoint--;
                result++;
            } else if(firstValue + secondValue > wantedValue){
                secondPoint--;
            } else if(firstValue + secondValue < wantedValue){
                firstPoint++;
            }
        }
        System.out.print(result);
    }
}
