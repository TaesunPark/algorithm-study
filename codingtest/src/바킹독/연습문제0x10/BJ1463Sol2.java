package 바킹독.연습문제0x10;
import java.util.Scanner;

public class BJ1463Sol2 {

    static int[] array;
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = new int[n];

        array[0] = 0;

        for(int i=2;i<n+1;i++){
            array[i] = array[i+1] + 1;
            if(i%2==0) array[i] = Math.min(array[i/2] + 1, array[i]) ;
            if(i%3==0) array[i] = Math.min(array[i/3] + 1, array[i]);
        }

        System.out.print(array[n]);
    }
}
