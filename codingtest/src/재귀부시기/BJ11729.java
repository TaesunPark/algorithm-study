package 재귀부시기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11729 {

    public static int count;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2,n)-1+"\n");

        func(1,3,n);
        System.out.println(sb);
    }

    public static void func(int a, int b, int n){
        if(n == 1){
            sb.append(a + " "+ b+"\n");
            return;
        }
        func(a, 6-a-b, n-1);
        sb.append(a + " "+ b+"\n");
        func(6-a-b,b,n-1);
    }



}
