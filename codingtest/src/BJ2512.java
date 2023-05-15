import java.util.Arrays;
import java.util.Scanner;

public class BJ2512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int M = sc.nextInt();

        Arrays.sort(arr);
        int left = 0;
        int right = arr[N - 1];

        while (left <= right){
            int mid = (left +right)/2;

            long sum = 0;
            for (int i = 0; i < N; i++){
                if (mid < arr[i]){
                    sum += mid;
                } else{
                    sum += arr[i];
                }
            }

            if (M < sum){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }

        System.out.print(right);

    }
}
