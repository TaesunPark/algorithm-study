package 바킹독.해시;

import java.util.HashMap;
import java.util.Scanner;

public class BJ1620 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> hashMap = new HashMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 1; i <= n; i++){
            String name = sc.next();
            hashMap.put(Integer.toString(i), name);
            hashMap.put(name, Integer.toString(i));
        }

        for(int i = 0; i < m; i++){
            String a = sc.next();
            System.out.println(hashMap.get(a));
        }


    }
}
