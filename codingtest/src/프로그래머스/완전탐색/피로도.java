package 프로그래머스.완전탐색;

class Solution1 {

    public static int max;
    public static boolean[] check;

    public int solution(int k, int[][] dungeons) {
        max = -1;
        check = new boolean[8];
        dfs(k, 0, dungeons);
        int answer = max;
        return answer;
    }

    public static void dfs(int k, int n, int[][] dungeons){

        max = Math.max(max, n);

        if(n == dungeons.length){
            return;
        }

        for(int i=0; i<dungeons.length; i++){

            if(check[i] == true) continue;
            if(k < dungeons[i][0]) continue;

            k -= dungeons[i][1];
            check[i] = true;
            dfs(k, n + 1, dungeons);
            check[i] = false;
            k += dungeons[i][1];

        }

    }

}