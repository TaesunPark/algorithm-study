package 프로그래머스.bfsdfs;

class Solution {

    static public int result;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        result = 0;
        dfs(numbers, 0, target);
        answer = result;
        return answer;
    }

    public static void dfs(int[] numbers, int num, int target){

        if(num == numbers.length){
            int sum = 0;

            for(int i=0; i<numbers.length; i++){
                sum += numbers[i];
            }

            if(sum == target){
                result++;
            }

            return;
        }

        dfs(numbers, num+1, target);
        numbers[num] *= -1;
        dfs(numbers, num+1, target);

    }
}
