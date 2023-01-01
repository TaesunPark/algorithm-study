package 바킹독.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ1912 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }

        Collections.sort(list, Collections.reverseOrder());

        int idx = 0;

        while(true){
            if(list.get(idx) < 0) break;
            sum += list.get(idx++);
        }

        System.out.print(sum);
    }
}
