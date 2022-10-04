package 바킹독.연습문제0x09;

import java.util.Arrays;

public class BJ16920 {
    public static void main(String[] args) {
        int[] list = {9,7,5,4,2,0,1,2,3,-3};

        list = Arrays.stream(list)
                .filter(element -> element != 0)
                .sorted()
                .toArray();

        for (int i : list){
            System.out.println(i);
        }
    }
}
