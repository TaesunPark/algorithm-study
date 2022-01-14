package 바킹독.연습문제0x10;
import java.util.Scanner;

public class BJ9095 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] k = new int[n+1];
        int sum = 0;
        k[0] = 0;
        k[1] = 1;

        for(int i=1;i<=n;i++){
            k[i] += k[i-1];
        }

        System.out.println(k[n]);
    }
}
