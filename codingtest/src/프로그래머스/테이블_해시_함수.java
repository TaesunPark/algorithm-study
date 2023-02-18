package 프로그래머스;

import java.util.Arrays;

class 테이블_해시_함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (o1, o2) -> {
            if(o1[col - 1] == o2[col - 1]){
                return o2[0] - o1[0];
            }
            return o1[col - 1]-o2[col -1 ];});

        int[] sum_list = new int[row_end - row_begin + 1];
        int idx = 0;

        for(int i = row_begin; i <= row_end; i++){
            int t_sum = 0;

            for(int j = 0; j < data[i - 1].length; j++){
                t_sum += (data[i - 1][j] % i);
            }

            sum_list[idx++] = t_sum;
        }

        String result = "";

        for(int i = 1; i < sum_list.length; i++){
            sum_list[0] ^= sum_list[i];
        }

        return sum_list[0];
    }
}