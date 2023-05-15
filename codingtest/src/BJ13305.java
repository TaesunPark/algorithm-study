import java.util.Scanner;

public class BJ13305 {
    public static void main(String[] args) {
        int N;
        int[] road;
        int[] price;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        road = new int[N - 1];
        price = new int[N];

        for (int i = 0; i < N - 1; i++){
            road[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++){
            price[i] = sc.nextInt();
        }

        long result = 0;

        for (int i = 0; i < N - 1; ){
            int en = i + 1;
            for (int j = i + 1; j < N - 1; j++){
                if (price[i] > price[j]){
                    en = j;
                    break;
                }
                en++;
            }
            // en은 다음 st가 될거임.
            // 거리 계산
            long total = 0;
            for (int j = i; j < en; j++){
                total += road[j];
            }

            result += total * price[i];
//            System.out.println(result);
            i = en;
        }
        System.out.print(result);
    }
}
