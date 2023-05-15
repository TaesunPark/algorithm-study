package 바킹독.그리디;

import java.util.Scanner;

public class BJ2847 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for (int i = n - 1; i >= 1; i--){
            if (arr[i] > arr[i - 1]) continue;
            result += arr[i - 1] - arr[i] + 1;
            arr[i - 1] = arr[i] - 1;
        }
        System.out.print(result);

    }
}
