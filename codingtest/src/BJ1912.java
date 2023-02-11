import java.util.Scanner;

public class BJ1912 {
    static int n;
    static int[] d;
    static int[] list;
    static int cnt = 0;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n];
        d = new int[n];

        for (int i = 0; i < n; i++){
            list[i] = sc.nextInt();
        }

        d[0] = list[0];
        max = d[0];
        
        for (int i = 1; i < n; i++){
            d[i] = Math.max(d[i - 1] + list[i], list[i]);
            max = Math.max(d[i], max);
        }

        System.out.print(max);
    }
}
