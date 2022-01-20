package 바킹독.연습문제0x0D;
import java.util.Scanner;

public class BJ15683 {

    public static int[][] map;

    public static void main(String[] args){
        int n,m;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    public static void number1(){

    }

    public static void number2(){

    }

    public static void number3(){

    }

    public static void number4(){

    }

    public static void number5(){

    }

}
