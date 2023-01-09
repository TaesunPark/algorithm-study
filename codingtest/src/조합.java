import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static ArrayList<Long> resultList;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            long N = sc.nextLong();
            int x =  sc.nextInt();
            int y =  sc.nextInt();
            long result = findMaxValue(N, x, y);
            System.out.print("#" + test_case + " ");
            System.out.println(result);
        }

    }

    public static long findMaxValue(long N, int x, int y){
        int n_size = Long.toString(N).length(); // n사이즈
        // 사이즈가 1일 때 예외처리
        if(n_size == 1){
            if(x == 0){
                if(y <= N){
                    return y;
                }
            }
            if(y == 0){
                if(x <= N){
                    return x;
                }
            }
        } else if(n_size > 2){
            int[] arr = {x, y};
            int r = n_size;
            resultList = new ArrayList<>();
            permutation(arr, new int[r], 0, r, N);
            permutation(arr, new int[r], 1, r, N);
            if(!resultList.isEmpty()){
                Collections.sort(resultList, Collections.reverseOrder());
                return resultList.get(0);
            }
        } else{
            int[] arr = {x, y};
            int r = n_size;
            resultList = new ArrayList<>();
            permutation(arr, new int[r], 0, r, N);

            if(!resultList.isEmpty()){
                Collections.sort(resultList, Collections.reverseOrder());
                return resultList.get(0);
            }
        }

        return -1;
    }

    public static void permutation(int[] arr, int[] out, int depth, int r, long N){
        if(depth == r){
            boolean check = false;
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: out) {
                if (!list.isEmpty() && list.get(list.size()-1) != num){
                    check = true;
                }
                list.add(num);
            }
            if (check == true) {
                String str = "";
                for (int i = 0; i < list.size(); i++){
                    str += list.get(i);
                }
                if(N >= Long.parseLong(str)){
                    resultList.add(Long.parseLong(str));
                }
            }

            return;
        }

        for(int i=0; i<arr.length; i++){
            out[depth] = arr[i];
            permutation(arr, out, depth+1, r, N);
        }

    }

}