package 알고리즘_스터디;

import java.util.Arrays;
import java.util.Scanner;

public class 신호처리_전문가 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] list = new int[N];
        int[] result = new int[N];

        int idx = 0;

        for (int i = 0; i < N; i++){
            list[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++){
            int[] tmp = makeList(i, i + K, list);
            result[i] = findMidValue(tmp);
            idx++;
            if (result[i] == K){
                break;
            }
        }

        for (int i = 0; i < idx; i++){
            System.out.print(result[i] + " ");
        }

    }

    public static int[] makeList(int st, int en, int[] list){
        int[] tmp = new int[en - st + 1];
        int idx = 0;
        for (int i = st; i < en; i++){
            tmp[idx++] = list[i];
        }
        return tmp;
    }

    public static int findMidValue(int[] list){
        int mid = list.length / 2;
        Arrays.sort(list);
        return list[mid];
    }

}
